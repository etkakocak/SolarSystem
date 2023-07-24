package assignment4;

import java.util.ArrayList;

/**
 * Create public class planet.
 */
public class Planet extends HeavenlyBody {
  private double avgOrbitRadiusInKm;
  public ArrayList<Moon> moonlist = new ArrayList<>();

  /**
   * Orbit radius of a planet can't be smaller than 18000.
   */
  public Planet(String name,  int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
  }

  /**
  * Adds planets.
  */
  public Moon addMoon(String name,  int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Moon moon1 = new Moon(name, avgRadiusInKm, avgOrbitRadiusInKm);
    moonlist.add(moon1);
    return moon1;
  }

  public double getAvgOrbitRadiusInKm() {
    return avgOrbitRadiusInKm;
  }

  /**
   * Create HeavenlyBody array.
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    ArrayList<Moon> moons = this.moonlist;
    HeavenlyBody[] allavmoons = new HeavenlyBody[moonlist.size() + 1];
    allavmoons[0] = new Planet(name, avgRadiusInKm, avgOrbitRadiusInKm);
    for (int i = 1; i < (moons.size() + 1); i++) {
      allavmoons[i] = new Moon(moons.get(i - 1).getName(),
       moons.get(i - 1).getAvgRadiusInKm(), moons.get(i - 1).getAvgOrbitRadiusInKm());
    }
    return allavmoons; 
  }

  @Override
  public String toString() {
    StringBuilder pm = new StringBuilder();
    pm.append(" Planet: " + getName() + ", average radius " + getAvgRadiusInKm() 
        + "km, average orbit radius " + getAvgOrbitRadiusInKm() + "km");
    for (Moon moon : moonlist) {
      pm.append("\n " + (moon.toString()));
    }
    return pm.toString();
  }
}
