/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author christopherwatnee
 */
public class RockPaperScissors {
    
    public void playgame() {
        // Declare variables
        int currentRoundNum;
        int numRounds;
        int userChoice;
        int compChoice;
        int tieNum;
        int userWinNum;
        int compWinNum;
        String[] rockPaperScissorsArray = {"Rock", "Paper", "Scissors"};
        
        Random randomizer = new Random();
        Scanner userInput = new Scanner(System.in);
        
        // Infinite loop until there is a break;
        while (true) {
            // Set counter variables to zero
            currentRoundNum = 0;
            tieNum = 0;
            userWinNum = 0;
            compWinNum = 0;
            
            // Ask user input for number of rounds
            numRounds = readInput("How many rounds would you like to play? (1-10) ");
            
            if (numRounds >= 1 && numRounds <= 10) {
                
                // Loop while current round number is less than total rounds
                while (currentRoundNum < numRounds) {
                    // Determine choices
                    userChoice = readInput("\nWhat is your choice? (1 = Rock, 2 = Paper, 3 = Scissors) ");
                    compChoice = randomizer.nextInt(3) + 1;
                    
                    // Figure out round results and display
                    if (userChoice == compChoice) {
                        System.out.print("Tie this round! ");
                        tieNum++;
                    } else if ((userChoice == 1 && compChoice == 3) ||(userChoice == 2 && compChoice == 1) || (userChoice == 3 && compChoice == 2)) {
                        System.out.print("User wins this round! ");
                        userWinNum++;
                    } else {
                        System.out.print("Computer wins this round! ");
                        compWinNum++;
                    }
                    
                    System.out.println("Computer selected " + rockPaperScissorsArray[compChoice - 1] + ".");
                    
                    // Increment current round number
                    currentRoundNum++;
                }
                
                // Print out results after all rounds
                System.out.println("\nTies: " + tieNum + ", User wins: " + userWinNum + ", Computer wins: " + compWinNum);
                
                // Declare overall winner
                if (userWinNum == compWinNum) {
                    System.out.println("User and computer tied. No overall winner!");
                } else if (userWinNum > compWinNum) {
                    System.out.println("User is the overall winner!");
                } else {
                    System.out.println("Computer is the overall winner!");
                }
                
                // Ask user if they would like to play again
                System.out.print("\nWould you like to play again? (yes/no) ");
                String playAgain = userInput.nextLine();
                
                System.out.println();// Print blank line
                
                if (playAgain.equals("no")) {
                    System.out.println("Thanks for playing!");
                    break;
                } else if (!playAgain.equals("yes")) {
                    System.out.println("Error: Unknown option.");
                    break;
                }
            } else {
                System.out.println("Error: Round number out of range.");
                break;
            }
        }
    }
    
    public static int readInput(String prompt) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(prompt);
        String inputString = userInput.nextLine();
        int input = Integer.parseInt(inputString);
        return input;
    }
}
