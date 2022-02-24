package com.learning;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	   String again = "yes";
	   int guess;
	   Random randomNumbers = new Random();
	   //int randNum = randomNumbers.nextInt(100);

	   int lowGuess = 0;
	   int highGuess = 100;
	   int guessCounter = 0;
	   int guessOverLimit = 0;
	   int numOfIterations = 0;
	   //TODO display header
	   Scanner keyboard = new Scanner(System.in);
	   do {
           int randNum = randomNumbers.nextInt(100);
           System.out.println(randNum); //For debugging
           System.out.printf("Number of iterations: %d Guesses over limit: %d\n", numOfIterations, guessOverLimit);
           System.out.println("Enter your first guess: ");
           guess = keyboard.nextInt();
           guessCounter++;
           while (0 > guess || guess > 100) {
               guessCounter--;
               System.out.println("Guess between 0 and 100. Your guess is out of range. Reenter-- ");
               guess = keyboard.nextInt();
               guessCounter++;
           }
           while (guess != randNum) {
               System.out.println("Number of guesses " + guessCounter);

               if (guess > randNum) {
                   System.out.println("Your guess is too high");
                   highGuess = guess;
               }
               else {
                   System.out.println("Your guess is too low");
                   lowGuess = guess;
               }
               guessCounter++;

               System.out.printf("Enter your next guess between %d and %d\n", lowGuess, highGuess);
               guess = keyboard.nextInt();
               while (lowGuess > guess || guess > highGuess) {
                   guessOverLimit++;
                   System.out.println(">>> Guess must be between lowGuess and highGuess. Try again");
                   guess = keyboard.nextInt();
               }
           }

           System.out.println("Congratulations, you guessed correctly.");
           keyboard.nextLine();
           System.out.println("Do you want to try again? (yes or no) ");
           again = keyboard.nextLine();
           numOfIterations++;

       } while (again.equalsIgnoreCase("yes"));
        System.out.println("Thanks for playing...");
    }
}
