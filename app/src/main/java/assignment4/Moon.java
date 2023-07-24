package assignment4;

/**
 * Creates Moon class that extends with HeavenlyBody class.
 */
public class Moon extends HeavenlyBody {
  private double avgOrbitRadiusInKm;

  /**
   * Create public Moon.
   */
  public Moon(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
  }

  public double getAvgOrbitRadiusInKm() {
    return this.avgOrbitRadiusInKm;
  }

  @Override
  public String toString() {
    StringBuilder sm = new StringBuilder();
    sm.append("     Moon: " + getName() + ", average radius " + getAvgRadiusInKm()
        + " km, average orbit radius " + getAvgOrbitRadiusInKm() + " km");
    return sm.toString();
  }
}