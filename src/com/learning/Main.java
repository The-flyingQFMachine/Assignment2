package com.learning;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	   String again = "yes";
	   int guess;


	   int lowGuess = 0;
	   int highGuess = 100;
	   int guessCounter = 0;
	   int numOfIterations = 0;
	   //TODO display header
	   Scanner keyboard = new Scanner(System.in);
	   do {
	       RNG.resetCount();
           int randNum = RNG.rand();
           System.out.println(randNum); //For debugging
           System.out.printf("Number of iterations: %d \n", numOfIterations);
           System.out.println("Enter your first guess: ");
           guess = keyboard.nextInt();

           while (0 > guess || guess > 100) {

               System.out.println("Guess between 0 and 100. Your guess is out of range. Reenter-- ");
               guess = keyboard.nextInt();

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

               System.out.printf("Enter your next guess between %d and %d\n", lowGuess, highGuess);
               boolean isValid;
               do {
               guess = keyboard.nextInt();
               isValid = RNG.inputValidation(guess, lowGuess, highGuess);
               } while (isValid == false);
               guessCounter = RNG.getCount();
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
