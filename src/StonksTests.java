// Joewah Yu
// 11/30/2025
// CSE 122
// C3: OOP It!
// TA: Katharine Zhang
// This class is to test the methods of the Stonks class.

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.Scanner;

public class StonksTests {
    @Test
    @DisplayName("Test for buying stock")
    public void buyStonkTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        assertTrue(stonk.buyStonks("AAPL", 150.2));
        assertFalse(stonk.buyStonks("AAPL", 3));
    }

    @Test
    @DisplayName("Test for selling stock")
    public void sellStonkTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        stonk.buyStonks("AAPL", 150.2);
        assertTrue(stonk.sellStonks("AAPL", 1));
        assertFalse(stonk.sellStonks("AAPL", 2));
    }

    @Test
    @DisplayName("Test for displaying stock")
    public void displayStonksTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        stonk.buyStonks("AAPL", 150.2);
        stonk.buyStonks("GOOGL", 1234.5);
        assertTrue(stonk.displayStonks());
    }

    @Test
    @DisplayName("Test for saving stocks to a file")
    public void saveStonksTest() throws FileNotFoundException {
        Stonks stonk = new Stonks("stonks.tsv");
        stonk.buyStonks("AAPL", 150.2);
        stonk.saveStonks("temp.txt");

        Scanner scanner = new Scanner(new File("temp.txt"));
        String line = scanner.nextLine();
        assertEquals(line, "AAPL 1.0");
    }
}
