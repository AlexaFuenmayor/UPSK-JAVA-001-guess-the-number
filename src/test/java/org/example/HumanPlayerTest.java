package org.example;
import mainGuessTheNumber.HumanPlayer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;


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
}
