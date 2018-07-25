package exercises;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles {
    @Test
    public void runTests(){
        assertBoolean();
        assertResultCorrect();
        assertStringStartsWithM();
    }

    public void assertStringStartsWithM(){
       String text = "My account has been disabled.";
       Assertions.assertThat(text).as("Tekst start met de letter M").startsWith("M");
       System.out.println( "StringStartsWithM: passed");
    }
    public void assertResultCorrect(){
        int som = 5 + 3;
        Assertions.assertThat(som).as("resultaat is gelijk aan 8").isEqualTo(8);
        System.out.println("ResultCorrect: passed");
    }
    public void assertBoolean(){
        boolean testBoolean = false;
        Assertions.assertThat(testBoolean).as("Is niet waar").isNotEqualTo(true);
        System.out.println("Boolean: passed");

    }
}
