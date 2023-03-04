import java.util.Scanner;

public class NumberGuessingApplication {
    public static void main(String[] args) {
        int answer = (int) ((Math.random() * (100 - 1)) + 1);
        int guesses = 0;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Machine!");
        System.out.println("Please select difficulty: Type 'h' for hard or 'e' for easy: ");

        String difficulty = scnr.nextLine();

        if (difficulty.equalsIgnoreCase("e")){
            guesses = 10;
        } else if (difficulty.equalsIgnoreCase("h")){
            guesses = 5;
        } else {
            System.out.println("Invalid input. Guess we're doing this the hard way.");
            guesses = 5;
        }

        System.out.println("I'm thinking of a number between 1 and 100. You have " + guesses + " guesses");
        //System.out.println("Answer is: " + answer);

        playGame(answer, guesses, scnr);


    }

    private static void playGame(int answer, int guesses, Scanner scnr) {
        boolean gameOver = false;

        while(!gameOver){
            System.out.println("Your guess: ");
            int guess = Integer.valueOf(scnr.nextLine());

            if(guess == answer){
                System.out.println("You win! The number was: "+ answer);
                break;
            } else if (guesses == 1) {
                System.out.println("Out of guesses. You lose! THe number was: " + answer);
                break;
            } else if (guess > answer){
                --guesses;
                System.out.println("Your guess was too high. You have " + guesses + " guesses remaining");
            } else if (guess < answer){
                --guesses;
                System.out.println("Your guess was too low. You have " + guesses + " guesses remaining");
            }
        }
    }
}
