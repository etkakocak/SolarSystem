package assignment4;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The SortAlgorithms class is used to handle sorting data from the file.
 */
public class SortAlgorithms {
  private static final String FILE_NAME = "../app/src/main/java/assignment4/solarsystems.data";

  /**
   * The method is used to sort datas from the file.
   * The sorting method is size of bodies.
   */
  public void sizeSorting() {
    try {
      File file = new File(FILE_NAME);
      Scanner scanner = new Scanner(file, "UTF-8");
      HashMap<String, Integer> data = new HashMap<>();
      String currentPlanet = "";
      String currentMoon = "";
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (line.startsWith("-")) {
          currentPlanet = line.substring(1, line.indexOf(":"));
          String[] values = line.substring(line.indexOf(":") + 1).split(":");
          data.put(currentPlanet, Integer.parseInt(values[0]));
        } else if (line.startsWith(" --")) {
          currentMoon = line.substring(4, line.indexOf(":"));
          String[] values = line.substring(line.indexOf(":") + 1).split(":");
          data.put(currentMoon, Integer.parseInt(values[0]));
        } else {
          String[] parts = line.split(":");
          data.put(parts[0], Integer.parseInt(parts[1]));
        }
      }
      scanner.close();

      System.out.println("Sorted bodies by their size:");
      data.entrySet().stream()
          .sorted(Map.Entry.comparingByValue())
          .forEach(entry -> {
            String key = entry.getKey();
            if (key.startsWith("-")) {
              key = key.substring(1);
            }
            System.out.println(key + " - " + entry.getValue());
          });
    } catch (IOException e) {
      System.out.println("An error occurred while reading from the file.");
    }
  }

  
  /**
   * The method is used to sort datas from the file.
   * The sorting method is orbit of bodies.
   */
  public void orbitSorting() {
    try {
      File file = new File(FILE_NAME);
      Scanner scanner = new Scanner(file, "UTF-8");
      HashMap<String, Double> data = new HashMap<>();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        if (line.startsWith("--") || line.startsWith("-")) {
          String[] parts = line.split(":");
          if (parts.length > 1) {
            try {
              double value = Double.parseDouble(parts[parts.length - 1]);
              String key = parts[0];
              if (line.startsWith("--")) {
                key = key.substring(2);
              }
              if (key.startsWith("-")) {
                key = key.substring(1);
              }
              data.put(key, value);
            } catch (NumberFormatException e) {
              continue;
            }
          }
        }
      }
      scanner.close();

      System.out.println("Sorted bodies by their orbit radius:");
      data.entrySet().stream()
          .sorted(Map.Entry.comparingByValue())
          .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    } catch (IOException e) {
      System.out.println("An error occurred while reading from the file.");
    }
  }
}
