import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.Scanner;

public class StonksTests {
    @Test
    public void buyStonkTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        assertTrue(stonk.buyStonks("AAPL", 150.2));
        assertFalse(stonk.buyStonks("AAPL", 3));
    }

    @Test
    public void sellStonkTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        stonk.buyStonks("AAPL", 150.2);
        assertTrue(stonk.sellStonks("AAPL", 1));
        assertFalse(stonk.sellStonks("AAPL", 2));
    }

    @Test
    public void displayStonksTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        stonk.buyStonks("AAPL", 150.2);
        stonk.buyStonks("GOOGL", 1234.5);
        assertTrue(stonk.displayStonks());
    }

    @Test
    public void saveStonksTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        stonk.buyStonks("AAPL", 150.2);
        stonk.saveStonks("temp.txt");

        Scanner scanner = new Scanner(new File("temp.txt"));
        String line = scanner.nextLine();
        assertEquals(line, "AAPL 1");
    }
}
