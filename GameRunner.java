package main;



import java.util.*;
public class GameRunner {
	
	
	public static void main(String args[]) throws InterruptedException {
		
		String word;											  // word being guessed

		String letterGuess;
		Set<String> letters = new HashSet<String>();			  // used to filter duplicate letters
																  // and check if word is spelled 
		
		SortedSet<String> guessedLetters = new TreeSet<String>(); // used to display already guessed letters
		 
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is the word you want them to guess?");
		word = keyboard.next();
		
		for(int i =0; i < 20 ; i++) //removes guess word from the console
			System.out.println();
		GameFunctions.generateStand();
		word = word.toLowerCase();
		
		char display[] = word.toCharArray(); //displays and correctly guessed letters
		char wordArray[] = word.toCharArray(); //used to check guessed letters agains
		
		for(char c : wordArray) { //adds letters of the word to a Set called letters
			String s = String.valueOf(c);
			letters.add(s);
		}
		
		for(int i=0; i < display.length ;  i++) // converts the display to a bunch of _ marks
			display[i] = '_';
			 
		System.out.print("Target Word: ");
		System.out.println(display);
		
		while(letters.isEmpty() != true) {
			
			System.out.println("Guessed Letters: " + guessedLetters); //displays already guessed letters
			
			System.out.println("What is your next guess?");
			letterGuess = keyboard.next();
			
			letterGuess = letterGuess.toLowerCase();
			letterGuess = letterGuess.substring(0, 1);
			
			if(guessedLetters.contains(letterGuess) == true) {
				System.out.println("Already guessed!! Guess again!!");
			}
			else {
				guessedLetters.add(letterGuess);
				if(GameFunctions.checkGuess(letters, display, letterGuess, wordArray) == false)
					GameFunctions.wrongGuess();
			}
			GameFunctions.generateStand();
			System.out.println();
			System.out.print("Target Word: ");
			System.out.println(display);
			
		}
		
		
		
		
		
		
		System.out.print("You did it");
		keyboard.close();
	}

}
