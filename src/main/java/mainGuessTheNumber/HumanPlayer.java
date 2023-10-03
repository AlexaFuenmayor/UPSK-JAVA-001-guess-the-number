package mainGuessTheNumber;
import java.util.InputMismatchException;
import java.util.Scanner;
public class  HumanPlayer extends Player {
    int guess;
    Scanner scanner = new Scanner(System.in);
    public int makeGuess(){
        guess = scanner.nextInt();
        return guess;
    }

    public HumanPlayer(String name) {
        this.setName(name);
    }

    public HumanPlayer() {

    }
    public int checkTheGuess(){
        while(true){
            try{
                System.out.println(" Choose a number between 1 y 100: ");
                guess = scanner.nextInt();
                guesses.add(guess);
                break;
            }catch(InputMismatchException e){
                System.out.println("Error: ❌ You must to enter a number");
                scanner.nextLine();
            }
        }
        return guess;
    }
    @Override
    public String getName() {
        return super.getName();
    }
}