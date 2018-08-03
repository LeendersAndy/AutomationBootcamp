package exercises;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloWorldTest {
    @Test
    public void printText() {
    System.out.println("Hello World");

    List<String> lijst = new ArrayList<String>();
    lijst.add("Andy");
    lijst.add("Wendy");
    lijst.add("polteq");
    lijst.add("ravago");
    for (String s : lijst){
        System.out.println(s);
    }
    Iterator it = lijst.iterator();
    while(it.hasNext()){
        String s = (String)it.next();
        System.out.println(s);
    }

    }
}
