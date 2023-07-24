package assignment4;

/**
 * Abstract class HeavenlyBody.
 */
public abstract class HeavenlyBody {
  String name;
  int avgRadiusInKm;

  protected HeavenlyBody(String name, int avgRadiusInKm) {
    setName(name);
    setAvgRadiusInKm(avgRadiusInKm);
  }

  private void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name must not be null or empty");
    } else if (name.isEmpty()) {
      throw new IllegalArgumentException("Name must not be null or empty");
    } else {
      this.name = name;
    }
  }

  private void setAvgRadiusInKm(int avgRadiusInKm) {
    this.avgRadiusInKm = avgRadiusInKm;
    this.avgRadiusInKm = avgRadiusInKm;
  }

  public String getName() {
    return name;
  }

  public int getAvgRadiusInKm() {
    return avgRadiusInKm;
  }

  public abstract String toString();
}