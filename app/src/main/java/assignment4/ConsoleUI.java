package assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The ConsoleUi class is used to handle outputs in the console.
 */
public class ConsoleUI {
  private Scanner input;

  public ConsoleUI() {
    this.input = new Scanner(System.in, "UTF-8");
  }

  /**
   * Method reads and prints all the data from the file 
   * using HeavenlyBody, Star, Planet and Moon classes.
   */
  public void printAll() {
    List<Star> stars = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(
        new FileReader("./app/src/main/java/assignment4/solarsystems.data"))) {
      String line;
      Planet currentPlanet = null;
      Moon currentMoon = null;
      Star currentStar = null;
      while ((line = reader.readLine()) != null) {
        if (line.trim().isEmpty()) {
          continue;
        }
        String[] tokens = line.split(":");
        String name = tokens[0];
        int radius = Integer.parseInt(tokens[1]);
        if (name.startsWith("-")) { // planet
          double orbitRadius = Double.parseDouble(tokens[2]);
          currentPlanet = currentStar.addPlanet(name.substring(1).trim(), radius, orbitRadius);
          currentMoon = null;
        } else if (name.startsWith(" --")) { // moon
          double orbitRadius = Double.parseDouble(tokens[2]);
          if (currentPlanet == null) {
            System.out.println("Invalid data: missing parent planet for moon " + name);
          }
          currentMoon = currentPlanet.addMoon(name.substring(3).trim(), radius, orbitRadius);
        } else { // star
          if (currentStar != null) {
            stars.add(currentStar);
          }
          if (currentMoon == null) {
            // continue
          }
          currentStar = new Star(name.trim(), radius);
          currentPlanet = null;
          currentMoon = null;
        }
      }
      if (currentStar != null) {
        stars.add(currentStar);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (stars.isEmpty()) {
      System.out.println("No stars defined in the input data");
    } else {
      for (Star star : stars) {
        System.out.println(star.toString());
        System.out.println();
      }
    }
  }

  
  /**
   * The method is used as the menu of the AddHandler class.
   */
  public void addNew() {
    AddHandler add = new AddHandler();
    int val = 0;

    while (val == 0 || val == 1 || val == 2 || val == 3) {
      System.out.println("1- Add a new star");
      System.out.println("2- Add a new planet");
      System.out.println("3- Add a new moon");
      System.out.println("4- Go back to the main menu");
      val = input.nextInt();

      if (val == 1) {
        add.addStar();
      } else if (val == 2) {
        add.addPlanet();
      } else if (val == 3) {
        add.addMoon();
      }
    }
  }

  
  /**
   * The method is used as the menu of the DelHandler class.
   */
  public void select() {
    DelHandler del = new DelHandler();
    int val = 0;

    while (val == 0 || val == 1 || val == 2 || val == 3) {
      System.out.println("1- Select a star to delete");
      System.out.println("2- Select a planet to delete");
      System.out.println("3- Select a moon to delete");
      System.out.println("4- Go back to the main menu");
      val = input.nextInt();

      if (val == 1) {
        del.delStar();
      } else if (val == 2) {
        del.delPlanet();
      } else if (val == 3) {
        del.delMoon();
      }
    }
  }
  

  /**
   * The method is used as the menu of the SortAlgorithms class.
   */
  public void sortBodies() {
    SortAlgorithms sort = new SortAlgorithms();
    int val = 0;

    while (val == 0 || val == 1 || val == 2) {
      System.out.println("1- Sort by their size");
      System.out.println("2- Sort by their orbit radius");
      System.out.println("3- Go back to the main menu");
      val = input.nextInt();

      if (val == 1) {
        sort.sizeSorting();
      } else if (val == 2) {
        sort.orbitSorting();
      }
    }
  }
  

  /**
   * The method is used as the main menu of the application.
   */
  public void start() {
    System.out.println("Welcome to the Solar System App!");
    System.out.println();
    int val = 0;

    while (val != 5) {
      System.out.println("1- List all Heavenly Bodies");
      System.out.println("2- Add a new Heavenly Body");
      System.out.println("3- Select a Body to delete");
      System.out.println("4- Sort Heavenly Bodies");
      System.out.println("5- Quit App");
      val = input.nextInt();

      if (val == 1) {
        printAll();
      } else if (val == 2) {
        addNew();
      } else if (val == 3) {
        select();
      } else if (val == 4) {
        sortBodies();
      }

    }
  }
}
