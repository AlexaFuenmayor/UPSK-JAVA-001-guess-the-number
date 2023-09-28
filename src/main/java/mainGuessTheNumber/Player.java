package mainGuessTheNumber;

import java.util.ArrayList;
import java.util.Scanner;



abstract class Player {
    String name;

    ArrayList<Integer> guesses = new ArrayList<>();

    // ArrayList<Integer> guesses;


    abstract int makeGuess();
    public String getName(){
        System.out.println("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        while(name.isEmpty()){
            System.out.println("Please your name must be greater than two characters. Try again: ");
            name = scanner.nextLine();
        }
        return name;

    }
    public ArrayList<Integer> getGuesses(int number){
        return guesses;
    }

}
