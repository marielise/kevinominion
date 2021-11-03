package com.shirleys;

public class Monster {

  private String name;
  private int lifePoints;
  private int baseDamage;
  private boolean isAlive;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLifePoints() {
    return lifePoints;
  }

  public void setLifePoints(int lifePoints) {
    this.lifePoints = lifePoints;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }
}
