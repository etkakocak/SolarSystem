package assignment4;

import java.util.ArrayList;

/**
 * Creates Star class that extends with HeavenlyBody class.
 */
public class Star extends HeavenlyBody {
  private ArrayList<Planet> planets = new ArrayList<>();

  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
  }

  /**
   * Planet radius can't be bigger than half of the radius of star.
   */
  public Planet addPlanet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Planet planet = new Planet(name, avgRadiusInKm, avgOrbitRadiusInKm);
    planets.add(planet);
    return planet;
  }

  /**
   * Get all bodies.
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    ArrayList<HeavenlyBody> heavenlyBodies = new ArrayList<>();
    heavenlyBodies.add(this);
    for (Planet planet : planets) {
      heavenlyBodies.add(planet);
      for (Moon moon : planet.moonlist) {
        heavenlyBodies.add(moon);
      }
    }
    return heavenlyBodies.toArray(new HeavenlyBody[0]);
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Star: " + getName() + ", average radius " + getAvgRadiusInKm() + " km");
    for (Planet planet : planets) {
      s.append("\n  ").append(planet.toString());
    }
    return s.toString();
  }
}
