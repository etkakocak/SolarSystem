package assignment4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The AddHandler class is used to save new Heavenly Bodies to the file.
 */
public class AddHandler {
  private Scanner input;
  private static final String FILE_NAME = "../app/src/main/java/assignment4/solarsystems.data";

  public AddHandler() {
    this.input = new Scanner(System.in, "UTF-8");
  }

  /**
   * The method is used to save a new star to the file.
   */
  public void addStar() {
    try (FileWriter fw = new FileWriter(FILE_NAME, true);
        PrintWriter out = new PrintWriter(new BufferedWriter(fw))) {
      String starName = null;
      System.out.println("Enter the name of the star:");
      starName = input.nextLine();
      System.out.println("Enter the radius of the star in kilometers:");
      int starRadius = input.nextInt();
      input.nextLine(); 
      out.write(System.lineSeparator()); 
      out.printf("%s:%d", starName, starRadius);
      System.out.println("Star added successfully!");
    } catch (IOException e) {
      System.out.println("An error occurred while adding the star to the file.");
    }
  }

  /**
   * The method is used to save a new planet to the file.
   */
  public void addPlanet() {
    try {
      File file = new File(FILE_NAME);
      Scanner scanner = new Scanner(file, "UTF-8");
      ArrayList<String> stars = new ArrayList<>();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.startsWith("--") && !line.startsWith(" ")) {
          stars.add(line);
        } else if (line.startsWith(" ")) {
          stars.add(line);
        } else {
          stars.add(" " + line);
        }
      }
      scanner.close();
      System.out.println("Enter the name of the star that you want to add a planet to:");
      String starName = input.nextLine();
      boolean starExists = false;
      int starIndex = 0;
      for (int i = 0; i < stars.size(); i++) {
        String line = stars.get(i);
        if (line.trim().startsWith(starName)) {
          starExists = true;
          starIndex = i;
          break;
        }
      }
      if (!starExists) {
        System.out.println("The star does not exist in the file.");
        return;
      }
      String planetName = null;
      System.out.println("Enter the name of the planet:");
      planetName = input.nextLine();
      System.out.println("Enter the radius of the planet in kilometers:");
      int planetRadius = input.nextInt();
      System.out.println("Enter the orbit radius of the planet in kilometers:");
      int planetOrbitRadius = input.nextInt();
      input.nextLine(); 
      String newPlanet = "-" + planetName + ":" + planetRadius + ":" + planetOrbitRadius;
      int planetIndex = -1;
      for (int i = starIndex + 1; i < stars.size(); i++) {
        String line = stars.get(i);
        if (line.startsWith("  ")) {
          planetIndex = i;
        } else if (!line.startsWith(" ")) {
          break;
        }
      }
      if (planetIndex == -1) {
        stars.add(starIndex + 1, "" + newPlanet);
      } else {
        stars.add(planetIndex + 1, "" + newPlanet);
      }
      PrintWriter out = new PrintWriter(file, "UTF-8");
      for (String line : stars) {
        if (line.startsWith(" ")) {
          out.println(line);
        } else {
          out.println("" + line);
        }
      }
      out.close();
      System.out.println("Planet added successfully!");
    } catch (IOException e) {
      System.out.println("An error occurred while adding the planet to the file.");
    }
  }

  
  /**
   * The method is used to save a new moon to the file.
   */
  public void addMoon() {
    try {
      File file = new File(FILE_NAME);
      Scanner scanner = new Scanner(file, "UTF-8");
      ArrayList<String> stars = new ArrayList<>();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.startsWith("--") && !line.startsWith(" ")) {
          stars.add(line);
        } else if (line.startsWith(" ")) {
          stars.add(line);
        } else {
          stars.add(" " + line);
        }
      }
      scanner.close();
      System.out.println("Enter the name of the star that you want to add a moon to:");
      String starName = input.nextLine();
      boolean starExists = false;
      int starIndex = 0;
      for (int i = 0; i < stars.size(); i++) {
        String line = stars.get(i);
        if (line.trim().startsWith(starName)) {
          starExists = true;
          starIndex = i;
          break;
        }
      }
      if (!starExists) {
        System.out.println("The star does not exist in the file.");
        return;
      }
      System.out.println("Enter the name of the planet that you want to add a moon to:");
      String planetName = input.nextLine();
      int planetIndex = -1;
      for (int i = starIndex + 1; i < stars.size(); i++) {
        String line = stars.get(i);
        if (line.trim().startsWith("-" + planetName)) {
          planetIndex = i;
          break;
        }
      }
      if (planetIndex == -1) {
        System.out.println("The planet does not exist in the file.");
        return;
      }
      String moonName = null;
      System.out.println("Enter the name of the moon:");
      moonName = input.nextLine();
      System.out.println("Enter the radius of the moon in kilometers:");
      int moonRadius = input.nextInt();
      System.out.println("Enter the orbit radius of the moon in kilometers:");
      int moonOrbitRadius = input.nextInt();
      input.nextLine(); 
      String newMoon = " --" + moonName + ":" + moonRadius + ":" + moonOrbitRadius;
      int moonIndex = -1;
      for (int i = planetIndex + 1; i < stars.size(); i++) {
        String line = stars.get(i);
        if (line.trim().startsWith(" --")) {
          moonIndex = i;
        } else if (!line.startsWith(" ")) {
          break;
        }
      }
      if (moonIndex == -1) {
        stars.add(planetIndex + 1, newMoon);
      } else {
        stars.add(moonIndex + 1, newMoon);
      }
      PrintWriter out = new PrintWriter(file, "UTF-8");
      for (String line : stars) {
        if (line.startsWith(" ")) {
          out.println(line);
        } else {
          out.println("" + line);
        }
      }
      out.close();
      System.out.println("Moon added successfully!");
    } catch (IOException e) {
      System.out.println("An error occurred while adding the moon to the file.");
    }
  }
}
