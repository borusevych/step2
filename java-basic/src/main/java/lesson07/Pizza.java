package lesson07;

public class Pizza {
  String name;

  public Pizza(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    if (!(obj instanceof Pizza)) return false;
    Pizza that = (Pizza) obj;

    return that.name.equals(this.name);
  }

}
