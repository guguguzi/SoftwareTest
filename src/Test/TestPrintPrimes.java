package Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import Triangle.PrintPrimes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import Triangle.PrintPrimes;


@RunWith(Parameterized.class)
public class TestPrintPrimes {
    private int n;
    private String expected;
    private PrintPrimes printPrimes;
    private PrintStream console = null;          
    private ByteArrayOutputStream bytes = null;  

    public TestPrintPrimes(int n, String expected) {
        this.n = n;
        this.expected = expected;
    }

    @Before
    public void setUp(){
        printPrimes = new PrintPrimes();
        bytes = new ByteArrayOutputStream();    
        console = System.out;                   
        System.setOut(new PrintStream(bytes));  
    }

    @After
    public void tearDown(){
        System.setOut(console);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {1, "Prime: 2\n"},
                {3, "Prime: 2\nPrime: 3\nPrime: 5\n"},
                {5, "Prime: 2\nPrime: 3\nPrime: 5\nPrime: 7\nPrime: 11\n"}
        });
    }

    @Test
    public void testPrintPrimes(){
        printPrimes.printPrimes(n);
        assertEquals(expected , bytes.toString());
    }
}
