package programs.games;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] words = new String[]{"game", "request", "java", "python", "hangman", "program", "computer"};

        String secretWord = words[(int) (Math.random() * words.length)].toLowerCase();
        char[] guessedLetters = new char[secretWord.length()];
        int attempts = 6;

        Arrays.fill(guessedLetters, '_');

        System.out.println("Hi player, let's play hangman");
        System.out.println("You have " + attempts + " attempts to guess the word.");

        while (attempts > 0) {

            System.out.println("Current word:" + String.valueOf(guessedLetters));
            System.out.print("Guess a letter: ");

            char guess = in.next().toLowerCase().charAt(0);

            if (!isLetter(guess)) {

                System.out.println("Invalid input. Please enter a letter.");
                continue;

            }

            if (!secretWord.contains(String.valueOf(guess))) {

                attempts--;
                System.out.println("You made a mistake, now you have " + attempts + " attempts to guess the word.");
                continue;

            } else {

                System.out.println("Congratulations, you guessed the letter(s)");

                for (int i = 0; i < guessedLetters.length; i++) {
                    if (secretWord.charAt(i) == guess) {
                        guessedLetters[i] = guess;
                    }
                }

            }

            if (String.valueOf(guessedLetters).equals(secretWord)) {
                System.out.println("Congratulations, you guessed the word: " + secretWord);
                break;
            }

        }

        if (attempts == 0) {
            System.out.println("Sorry but you didn't guess the word: " + secretWord);
        }

        in.close();
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }
}
