package com.shirleys;

public class TerminalDraw {

  public static void printPlayerInformation(Player player){
    System.out.println("======================================");
    System.out.println("      KEVINOMINION !!");
    System.out.println("======================================");
    System.out.println("PLAYER NAME: " + player.getName());
    System.out.println("Life: " + player.getLifePoints());
    System.out.println("Level: " + player.getLevel());
    System.out.println();
    System.out.println("=======================================");
  }

  public static void printBoard(BoardCorridor boardCorridor, Player player) {
    int size  = BoardCorridor.CORRIDOR_SIZE;
    printBorderLine(size);
    System.out.print("|"); //end of corridor

    for (int i = 0; i < size ; i++) {
      if (player.getPosition() == i) {
        System.out.print("| P |");
      } else if (boardCorridor.hasAliveMonster(i)) {
        System.out.print("| @ |");
      } else if (boardCorridor.hasDeadMonster(i)) {
        System.out.print("| x |");
      } else {
        //there is nothing
        System.out.print("|   |");
      }
    }

    System.out.print("|\n"); //end of corridor
    printBorderLine(size);
  }

  private static void printBorderLine(int size) {
    System.out.print(" ");
    for(int i = 0; i < size; i++) {
      System.out.print(" --- ");
    }
    System.out.println(); //to get a new line
  }

  public static void printInstructions() {
    System.out.println("Please select a direction");
    System.out.println("================");
    System.out.println("A for <= (left)");
    System.out.println("D for => (right)");
    System.out.println("================");
  }



}
