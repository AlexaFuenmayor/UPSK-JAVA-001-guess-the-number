package org.example;
import mainGuessTheNumber.HumanPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


@RunWith(MockitoJUnitRunner.class)

public class HumanPlayerTest{
    @Mock
    private HumanPlayer humanPlayer;

    @Test
    public void  getNameTest() {
        String name = "Jose";
        Mockito.when(humanPlayer.getName()).thenReturn(name);
        Assert.assertEquals(name, humanPlayer.getName());
    }

    @Before
    public void setUp(){
        Scanner mockScanner = new Scanner(System.in);
        humanPlayer.makeGuess(mockScanner);

    }

    @After
    public void tearDown(){
        humanPlayer = null;
        System.setIn(System.in);
    }


    @Test
    public void testCheckTheGuessWithInvalidInput() {
        // Simula una entrada inválida del usuario
        String input = "notanumber\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int result = humanPlayer.checkTheGuess();

        assertEquals(0, result); //
    }




}
