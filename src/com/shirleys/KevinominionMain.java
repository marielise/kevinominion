package com.shirleys;

import java.util.Scanner;

public class KevinominionMain {

    private static int LIFE_POINTS = 5;
    private static Player thePlayer;
    private static BoardCorridor boardCorridor;

    public static void main(String[] args) {

	     configurePlayer();
	     startGame();

    }

    private static void configurePlayer() {
        thePlayer = new Player();

        System.out.println("Please enter player name:");
        Scanner in = new Scanner(System.in);
        String name = in.next();

        thePlayer.setName(name);
        thePlayer.setAlive(true);
        thePlayer.setLevel(0);
        thePlayer.setArmorPoints(0);
        thePlayer.setLifePoints(LIFE_POINTS);
        thePlayer.setPosition(-1); //By default the player is out of the board

        TerminalDraw.printPlayerInformation(thePlayer);

    }












    private static void initBoard() {
        //initialize the game
        boardCorridor = new BoardCorridor();
        TerminalDraw.printBoard(boardCorridor, thePlayer);
    }



    private static void startGame() {
        System.out.println("Start game");
        boolean stillPlaying = true;
        initBoard();

        Scanner in = new Scanner(System.in); // to read input from the keyboard

        while (stillPlaying) {
            dropPlayerStart();
            TerminalDraw.printBoard(boardCorridor, thePlayer);

            while (thePlayer.isAlive()) {

                TerminalDraw.printInstructions();
                char key = in.next().charAt(0);
                int newLocation = -1;
                if (key == 'A' || key == 'a') {
                    //move left
                    newLocation = thePlayer.computeNewPlayerLocation(-1);
                } else if (key == 'D' || key == 'd') {
                    //move right
                    newLocation = thePlayer.computeNewPlayerLocation(1);
                } else {
                    System.out.println("Wrong input, please try again");
                    continue;
                }

                TerminalDraw.printBoard(boardCorridor, thePlayer);

                //checkMonster at new location
                if (boardCorridor.hasAliveMonster(newLocation)) {
                    // if monster, start sub program attack monster
                } else {
                    //just move again
                }

                thePlayer.setLifePoints(thePlayer.getLifePoints() - 1);
            }

            stillPlaying = false;
        }
    }

    private static void dropPlayerStart() {
        System.out.println("Dropping player on the map");
        int randomLocation = randomValueInRange(0, BoardCorridor.CORRIDOR_SIZE - 1);

        //we try until we find a location without monster
        while (boardCorridor.hasAliveMonster(randomLocation)) {
            randomLocation = randomValueInRange(0, BoardCorridor.CORRIDOR_SIZE - 1);
        }

        thePlayer.setPosition(randomLocation);
    }

    public static int randomValueInRange(int min, int max) {
        return min + (int) Math.random() * (max - min);
    }


}
