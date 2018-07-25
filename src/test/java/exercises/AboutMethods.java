package exercises;

import org.testng.annotations.Test;

import java.util.Random;

public class AboutMethods {

    @Test
    public void printProduct(){
        System.out.println(multiply1(4,15));
        multiply2(2,6);
        System.out.println(multiplyRandom());
    }
    //best practice
    private int multiply1(int a, int b){
        return (a * b);
    }
    //less best practice
    private void multiply2(int a, int b){
        int uitkomst =  a * b;
        String lijn = "Het resultaat van de som: " + a + " + " + b + " = " + uitkomst;
        System.out.println(lijn);
    }
    //random number multiplier
    private int multiplyRandom(){
        Random a = new Random();
        int getal1 = a.nextInt(10);

        Random b =new Random();
        int getal2 = b.nextInt(5);


        return getal1 * getal2;
    }
}
