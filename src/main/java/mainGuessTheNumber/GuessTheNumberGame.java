package mainGuessTheNumber;
import java.util.Random;
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
    public static void checkGuess(int number){
        int turn = 0;

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();


        String playerName = humanPlayer.checkName();
        int humanNumberChoose = humanPlayer.checkTheGuess();
        int computerNumberChoose = computerPlayer.makeGuess();


        //Clean arrays
        humanPlayer.getGuesses().clear();
        computerPlayer.getGuesses().clear();


        while(turn >= 0){
            if(turn % 2 == 0){
                if(number > humanNumberChoose && humanNumberChoose >= 1){
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println(playerName + " " +  humanNumberChoose + " Is very low .  It´s the Computer´s turn: ");
                    turn ++;
                    humanPlayer.setGuesses(humanNumberChoose);
                    computerNumberChoose = computerPlayer.makeGuess();


                }else if(humanNumberChoose == 0 || humanNumberChoose > 100) {
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Error: 😣 " + playerName + " You must choose a number between 1 and 100. It´s the Computer´s turn: ");
                    humanPlayer.setGuesses(humanNumberChoose);
                    turn++;
                    computerNumberChoose = computerPlayer.makeGuess();

                }else if(number < humanNumberChoose){
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println(playerName + " " + humanNumberChoose + " Is very high. It´s the Computer´s turn: ");
                   humanPlayer.setGuesses(humanNumberChoose);

                    turn++;
                    computerNumberChoose = computerPlayer.makeGuess();

                }else{
                    humanPlayer.setGuesses(humanNumberChoose);
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Congrats " + playerName +". You won. " +"Good job 🎉");
                    System.out.println("Your elections were: " + humanPlayer.getGuesses());
                    break;
                }
            }else{
                if(number > computerNumberChoose){
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Computer chose: " + computerNumberChoose + " Is very low.  " );
                    System.out.println("--------------------------------------------------");
                    System.out.println(" It´s: "+ playerName  + "'s turn:"  );
                    computerPlayer.setGuesses(computerNumberChoose);
                    turn ++;
                    humanNumberChoose = humanPlayer.makeGuess();

                }else if(number < computerNumberChoose) {
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("Computer chose: " + computerNumberChoose + " Is very high");
                    System.out.println("--------------------------------------------------");
                    System.out.println(" It´s: " + playerName + "'s turn:");
                    computerPlayer.setGuesses(computerNumberChoose);
                    turn++;
                    humanNumberChoose = humanPlayer.makeGuess();

                }else{
                    computerPlayer.setGuesses(computerNumberChoose);
                    System.out.println(">>----------------------------------------------<<");
                    System.out.println("The computer won");
                    System.out.println("Their elections were: " + computerPlayer.getGuesses());

                    break;
                }

            }
        }
    }
}
