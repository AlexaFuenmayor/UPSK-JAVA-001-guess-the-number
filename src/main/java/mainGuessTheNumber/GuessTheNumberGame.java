package mainGuessTheNumber;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class GuessTheNumberGame {
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) +1;
    }

    public static void main(String[] args) {
        System.out.println("**********************************************");
        System.out.println("=== Welcome to GuessTheNumber Game ===");
        System.out.println("**********************************************");
        int targetNumber = generateRandomNumber();
        System.out.println(targetNumber);
        checkGuess(targetNumber);
    }
    public static void checkGuess(int args){
        int turn = 0;
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();

        //Scanner input = new Scanner(System.in);
        String playerName = humanPlayer.getName();
       // System.out.println(">>----------------------------------------------<<");
        //System.out.println(playerName + " Choose a number between 1 y 100: ");
        int humanNumberChoose = humanPlayer.makeGuess();


        // System.out.println(numberChoose);


        int computerNumberChoose = computerPlayer.makeGuess();
        ArrayList<Integer> numbersListHuman;
        ArrayList<Integer> numbersListComputer = new ArrayList<>();


        while(turn >= 0){
            if(turn % 2 == 0){

                if(args > humanNumberChoose && humanNumberChoose >= 1){
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println(playerName + " " +  humanNumberChoose + " Is very low .  It´s the Computer´s turn: ");
                    turn ++;
                    computerNumberChoose = computerPlayer.makeGuess();

                }else if(humanNumberChoose == 0 || humanNumberChoose > 100) {
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Error: 😣 " + playerName + " You must choose a number between 1 and 100. It´s the Computer´s turn: ");
                    humanPlayer.getGuesses(humanNumberChoose);
                    turn++;
                    computerNumberChoose = computerPlayer.makeGuess();

                }else if(args < humanNumberChoose){
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println(playerName + " " + humanNumberChoose + " Is very high. It´s the Computer´s turn: ");
                    humanPlayer.getGuesses(humanNumberChoose);

                    turn++;
                    computerNumberChoose = computerPlayer.makeGuess();

                }else{
                    numbersListHuman = humanPlayer.getGuesses(humanNumberChoose);
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Congrats " + playerName +" You won. " +"Good job 🎉");
                    System.out.println("Your elections were: " + numbersListHuman);
                    break;
                }
            }else{
                if(args > computerNumberChoose){
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Computer chose: " +computerNumberChoose + " Is very low.  " );
                    System.out.println("--------------------------------------------------");
                    System.out.println(" It´s: "+ playerName  + "'s turn:"  );
                    numbersListComputer = computerPlayer.getGuesses(computerNumberChoose);
                    turn ++;
                    humanNumberChoose = humanPlayer.makeGuess();

                }else if(args < computerNumberChoose) {
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Computer chose: " + computerNumberChoose + " Is very high");
                    System.out.println("--------------------------------------------------");
                    System.out.println(" It´s: " + playerName + "'s turn:");
                    numbersListComputer = computerPlayer.getGuesses(computerNumberChoose);
                    turn++;
                    humanNumberChoose = humanPlayer.makeGuess();

                }else{
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("The computer won");
                    System.out.println("Their elections were: " + numbersListComputer);
                    break;
                }

            }

        }


    }
}
