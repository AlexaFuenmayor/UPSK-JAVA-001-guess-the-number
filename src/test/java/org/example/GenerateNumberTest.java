package org.example;
import mainGuessTheNumber.GuessTheNumberGame;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.mockito.MockitoAnnotations;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)


public class GenerateNumberTest{

    @Test
    public void  testGenerateNumber() throws Exception {
        Random mockRandom = PowerMockito.mock(Random.class);
        whenNew(Random.class).withNoArguments().thenReturn(mockRandom);
        PowerMockito.when(mockRandom.nextInt(100) + 1).thenReturn(30);

        int targetNumber =  GuessTheNumberGame.generateRandomNumber();

       //assertEquals(30,targetNumber);

    }


}
