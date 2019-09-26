package main;

import java.util.*;
import java.util.concurrent.*;

public class GameFunctions {
	
	private static int wrongGuessCounter = 0;
	
	
	
	
	public static int getWrongGuessCounter() {
		return wrongGuessCounter;
	}


	public static void setWrongGuessCounter(int wrongGuessCounter) {
		GameFunctions.wrongGuessCounter = wrongGuessCounter;
	}
	
	public static void wrongGuess() {	//increments when the word does not contain the guessed letter	
		wrongGuessCounter++;	
	}
	
	public static boolean checkGuess(Set<String> letters, char[] display, String guess, char[] word ) {
		// checks if letter is present in word
		// if not present returns false
		// if present changes display to show that letter,
		// removes letter from letter set, and returns true
		boolean check = false;
		
		if(letters.contains(guess)) {
			letters.remove(guess);
			check = true;
			for(int i =0; i<word.length;i++) {
				if( word[i] == guess.charAt(0))
					display[i] = guess.charAt(0);
				
			}
		}
		
		return check;
	}




	public static void generateStand() throws InterruptedException {  //used to display the hangman stand
		
		
		switch(wrongGuessCounter) {
		
		case 0:
		System.out.printf("        ########%n"
				+ "	#%n"
				+ "	#%n"
				+ "	#%n"
				+ "	#%n"
				+ "	#%n"
			+  "     #######");
		System.out.println();
		break;
		
		case 1:
			System.out.printf("        ########%n"
					+ "	#      O%n"
					+ "	#%n"
					+ "	#%n"
					+ "	#%n"
					+ "	#%n"
				+  "     #######");
			break;
		case 2:
			System.out.printf("        ########%n"
					+ "	#      O%n"
					+ "	#      |%n"
					+ "	#%n"
					+ "	#%n"
					+ "	#%n"
				+  "     #######");
			break;
		case 3:
			System.out.printf("        ########%n"
					+ "	#      O%n"
					+ "	#     /|%n"
					+ "	#%n"
					+ "	#%n"
					+ "	#%n"
				+  "     #######");
			break;
		case 4:
			System.out.printf("        ########%n"
					+ "	#      O%n"
					+ "	#     /|\\%n"
					+ "	#%n"
					+ "	#%n"
					+ "	#%n"
				+  "     #######");
			break;
		case 5:
			System.out.printf("        ########%n"
					+ "	#      O%n"
					+ "	#     /|\\%n"
					+ "	#       \\%n"
					+ "	#%n"
					+ "	#%n"
				+  "     #######");
			break;
		case 6:
			System.out.printf("        ########%n"
					+ "	#      O%n"
					+ "	#     /|\\%n"
					+ "	#     / \\%n"
					+ "	#%n"
					+ "	#%n"
				+  "     #######");
			System.out.println();
			System.out.println("Game Over!!");
			TimeUnit.SECONDS.sleep(5);
			System.exit(1);
			break;
		
		}
	}
	
}
