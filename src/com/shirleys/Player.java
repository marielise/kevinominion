package com.shirleys;

public class Player {

  private String name;
  private int level;
  private int armorPoints;
  private int lifePoints;
  private boolean isAlive;

  //Position on the board
  private int position;

  private PlayerClass playerClass;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getArmorPoints() {
    return armorPoints;
  }

  public void setArmorPoints(int armorPoints) {
    this.armorPoints = armorPoints;
  }

  public PlayerClass getPlayerClass() {
    return playerClass;
  }

  public void setPlayerClass(PlayerClass playerClass) {
    this.playerClass = playerClass;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public int getLifePoints() {
    return lifePoints;
  }

  public void setLifePoints(int lifePoints) {
    this.lifePoints = lifePoints;
    if (lifePoints <= 0) {
      isAlive = false;
    }
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }

  public int computeNewPlayerLocation(int i) {
    int newLocation = position + i;
    if (newLocation < 0 || newLocation > BoardCorridor.CORRIDOR_SIZE) {
      System.out.println("Can't go further");
      //we don't change the position
    } else {
      //this is the new position
      position = newLocation;
    }
    return position;
  }
}
