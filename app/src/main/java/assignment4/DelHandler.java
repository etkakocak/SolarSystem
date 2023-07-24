package assignment4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The DelHandler class is used to handle deleting data from the file.
 */
public class DelHandler {
  private Scanner input;
  private static final String FILE_NAME = "../app/src/main/java/assignment4/solarsystems.data";

  public DelHandler() {
    this.input = new Scanner(System.in, "UTF-8");
  }

  /**
   * The method is used to delete a star from the file.
   */
  public void delStar() {
    try {
      File file = new File(FILE_NAME);
      Scanner scanner = new Scanner(file, "UTF-8");
      ArrayList<String> lines = new ArrayList<>();
      System.out.println("Enter the name of the star that you want to delete:");
      String starName = input.nextLine();
      boolean deleteNextLines = false;
      Boolean starFound = false;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!deleteNextLines) {
          if (!line.trim().startsWith(starName)) {
            lines.add(line);
          } else {
            starFound = true;
            deleteNextLines = true;
          }
        } else {
          if (line.trim().startsWith("-") || line.trim().startsWith(" --")) {
            continue;
          } else {
            deleteNextLines = false;
            if (!line.isBlank()) {
              lines.add(line);
            }
          }
        }
      }
      scanner.close();

      if (!starFound) {
        System.out.println("Star not found");
        return;
      }

      PrintWriter out = new PrintWriter(file, "UTF-8");
      for (String line : lines) {
        out.println(line);
      }
      out.close();

      System.out.println("Star deleted successfully!");
    } catch (IOException e) {
      System.out.println("An error occurred while deleting the star from the file.");
    }
  }

  /**
   * The method is used to delete a planet from the file.
   */
  public void delPlanet() {
    try {
      File file = new File(FILE_NAME);
      Scanner scanner = new Scanner(file, "UTF-8");
      ArrayList<String> lines = new ArrayList<>();

      System.out.println("Enter the name of the star which has the planet you want to delete:");
      String starName = input.nextLine();
      System.out.println("Enter the name of the planet that you want to delete:");
      String planetName = input.nextLine();

      boolean starFound = false;
      boolean planetFound = false;
      boolean deletingMoons = false;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!starFound && line.trim().startsWith(starName)) {
          starFound = true;
        }

        if (starFound && !planetFound) {
          if (line.trim().startsWith("-" + planetName)) {
            planetFound = true;
            deletingMoons = true;
            continue;
          }
        } else if (planetFound) {
          if (deletingMoons && line.startsWith(" -")) {
            continue;
          } else {
            deletingMoons = false;
          }
        }

        lines.add(line);
        if (!scanner.hasNextLine() && planetFound) {
          break;
        }
      }
      scanner.close();

      if (!planetFound) {
        System.out.println("Planet not found");
        return;
      }

      PrintWriter out = new PrintWriter(file, "UTF-8");
      for (String line : lines) {
        out.println(line);
      }
      out.close();

      System.out.println("Planet deleted successfully!");
    } catch (IOException e) {
      System.out.println("An error occurred while deleting the planet from the file.");
    }
  }

  /**
   * The method is used to delete a moon from the file.
   */
  public void delMoon() {
    try {
      File file = new File(FILE_NAME);
      ArrayList<String> lines = new ArrayList<>();

      System.out.println("Enter the name of the star which has the planet " 
          + "you want to delete the moon from:");
      String starName = input.nextLine();
      System.out.println("Enter the name of the planet that has the moon you want to delete:");
      String planetName = input.nextLine();
      System.out.println("Enter the name of the moon that you want to delete:");
      String moonName = input.nextLine();

      boolean starFound = false;
      boolean planetFound = false;
      boolean moonFound = false;
      Scanner scanner = new Scanner(file, "UTF-8");
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!starFound && line.trim().startsWith(starName)) {
          starFound = true;
        }

        if (starFound && !planetFound) {
          if (line.trim().startsWith("-" + planetName)) {
            planetFound = true;
          }
        }

        if (planetFound && !moonFound) {
          if (line.trim().substring(2).startsWith(moonName)) {
            moonFound = true;
            continue;
          }
        }

        lines.add(line);
        if (!scanner.hasNextLine() && moonFound) {
          break;
        }
      }
      scanner.close();

      if (!moonFound) {
        System.out.println("Moon not found");
        return;
      }

      PrintWriter out = new PrintWriter(file, "UTF-8");
      for (String line : lines) {
        out.println(line);
      }
      out.close();

      System.out.println("Moon deleted successfully!");
    } catch (IOException e) {
      System.out.println("An error occurred while deleting the moon from the file.");
    }
  }

}
