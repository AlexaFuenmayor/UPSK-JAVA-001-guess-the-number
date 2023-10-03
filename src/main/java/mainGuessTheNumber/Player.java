package mainGuessTheNumber;

import java.util.ArrayList;
import java.util.Scanner;



abstract class Player {
    private String name;
    private final Scanner scanner;

    public Player(){
        this.scanner = new Scanner(System.in);
    }
    ArrayList<Integer> guesses = new ArrayList<>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setName(){
        System.out.println("Please enter your name: ");
        name = scanner.nextLine();
    }
    public String checkName(){
        while(true){
            setName();
            if (!name.isEmpty()){
                return name;
            }else{
                System.out.println("Please your name must have almost one character ");
            }
        }
    }
    public ArrayList<Integer> getGuesses(){
        return guesses;
    }

    public void setGuesses(int guess) {
       guesses.add(guess);
    }

    public abstract int makeGuess();
}
