package com.shirleys;

import static com.shirleys.KevinominionMain.randomValueInRange;

public class BoardCorridor {

  public final static int CORRIDOR_SIZE = 10;
  private Monster [] corridor = new Monster[10];

  public BoardCorridor() {
    reset();
  }

  public void reset() {
    int numberOfMonsters = randomValueInRange(0, BoardCorridor.CORRIDOR_SIZE/2);

    int numberOfCreatedMonsters = 0;

    while (numberOfCreatedMonsters < numberOfMonsters) {
      //pick a random location between 0 and the size of the corridor (not included)
      //an array of 10, starts from 0 to 9
      int location = randomValueInRange(0, 9);

      if (corridor[location] == null) {
        Monster m = new Monster();
        m.setName("grahhh");
        m.setBaseDamage(5);
        m.setLifePoints(20);

        corridor[location] = m;

        numberOfCreatedMonsters = numberOfCreatedMonsters + 1;
      }
    }
  }

  public boolean hasAliveMonster(int location) {
    if (corridor[location] != null) {
      Monster m = corridor[location];

      if (m.isAlive()) {
        return true;
      } else {
        return false;
      }
    }

    return false;
  }


  public boolean hasDeadMonster(int location) {
    if (corridor[location] != null) {
      Monster m = corridor[location];

      if (m.isAlive()) {
        return false;
      } else {
        return true;
      }
    }

    return false;

  }
}
