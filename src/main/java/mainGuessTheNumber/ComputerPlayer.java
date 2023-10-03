package mainGuessTheNumber;
import java.util.Random;

public class ComputerPlayer extends Player {


    Random random = new Random();
    //int numberRandom = random.nextInt(100)+1;

    //Override se utiliza en Java para indicar que un método en una subclase
    // está destinado a anular (reemplazar) un método con la misma firma (nombre, parámetros y tipo de retorno)
    // en la superclase. Esta anotación no es obligatoria, pero es una buena práctica
    @Override
    public int makeGuess() {
        return random.nextInt(100)+1;
    }

}
