package com.learning;
import java.util.*;

public class RandomNumberGuesser {

    public static void main(String[] args) {
	   String again;
	   int guess;
	   int lowGuess = 0;
	   int highGuess = 100;
	   int numOfIterations = 1;
	   boolean isValid;
	   System.out.println("This is a number guessing game. Try guessing number between 1 and 100: ");
	   Scanner keyboard = new Scanner(System.in);
	   do {
	       // Reset everything at the beginning of new game.
	       RNG.resetCount();
	       lowGuess = 0;
	       highGuess = 100;
           int randNum = RNG.rand();
           System.out.println("The generated number is (for testing purposes): " + randNum); //For debugging
           System.out.printf("Number of iterations: %d \n", numOfIterations);
           System.out.println("Enter your first guess: ");

           //Makes sure that the guess is between 0 and 100
           guess = getValidGuess(keyboard, lowGuess, highGuess);

           while (guess != randNum) {
               System.out.println("Number of guesses " + RNG.getCount());

               if (guess > randNum) {
                   System.out.println("Your guess is too high");
                   highGuess = guess;
               }
               else {
                   System.out.println("Your guess is too low");
                   lowGuess = guess;
               }

               System.out.printf("Enter your next guess between %d and %d\n", lowGuess, highGuess);
               //Narrows down the choices and validates user input
               guess = getValidGuess(keyboard, lowGuess, highGuess);
           }

           System.out.println("Congratulations, you guessed correctly.");
           keyboard.nextLine();
           System.out.println("Do you want to try again? (yes or no) ");
           again = keyboard.nextLine(); //Consume newline character in the keyboard buffer
           numOfIterations++;  //Increments number of iterations in the end.
       } while (again.equalsIgnoreCase("yes"));
        System.out.println("Thanks for playing...");
    }

    /**
     * Accepts user input for guess and validates it according to the current values of lowGuess and highGuess.
     * @param keyboard
     * @param lowGuess
     * @param highGuess
     * @return guess that satisfies the conditions
     */
    private static int getValidGuess(Scanner keyboard, int lowGuess, int highGuess) {
        int guess;
        boolean isValid;
        do {
            guess = keyboard.nextInt();
            isValid = RNG.inputValidation(guess, lowGuess, highGuess);
        } while (!isValid);
        return guess;
    }
}
