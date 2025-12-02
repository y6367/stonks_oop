// Joewah Yu
// 11/30/2025
// CSE 122
// C3: OOP It!
// TA: Katharine Zhang
// This class is a stock market simulator, where you can buy, sell, display, and save stocks, just
// like an actual stock market.

import java.util.*;
import java.io.*;

public class StonksMain {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: write main method here
        System.out.print("Enter stocks file name: ");
        Scanner input = new Scanner(System.in);
        String inputFile = input.nextLine();
        System.out.println();
        System.out.println("Welcome to the CSE 122 Stocks Simulator!");
        Stonks stonks = new Stonks(inputFile);
        String selection = "";
        while (!selection.equals("Q") && !selection.equals("q")) {
            System.out.println();
            System.out.println("Menu: (B)uy, (Se)ll, (D)isplay, (S)ave, (Q)uit");
            System.out.print("Enter your choice: ");
            selection = input.nextLine();
            if (selection.equals("B") || selection.equals("b")) {
                buyStonks(input, stonks);
            } else if (selection.equals("Se") || selection.equals("se") || selection.equals("SE")
                    || selection.equals("sE")) {
                sellStonks(input, stonks);
            } else if (selection.equals("D") || selection.equals("d")) {
                stonks.displayStonks();
            } else if (selection.equals("S") || selection.equals("s")) {
                saveStonks(input, stonks);
            } else if (selection.equals("Q")  || selection.equals("q")) {
                stonks.quitStonks();
            } else {
                System.out.println("Invalid choice: " + selection);
                System.out.println("Please try again");
            }
        }
    }

    // Prompts the user using the given Scanner for the stock the user wants to purchase
    public static void buyStonks(Scanner input, Stonks stonks) {
        System.out.print("Enter the stock ticker: ");
        String ticker = input.nextLine();
        System.out.print("Enter your budget: ");
        String budgetStr = input.nextLine();
        double budget = Double.parseDouble(budgetStr);
        stonks.buyStonks(ticker, budget);
    }

    // Prompts the user using the given Scanner for the stock the user wants to sell from the
    // user's portfolio
    public static void sellStonks(Scanner input, Stonks stonks) {
        System.out.print("Enter the stock ticker: ");
        String ticker = input.nextLine();
        System.out.print("Enter the number of shares to sell: ");
        String sellStr = input.nextLine();
        double sharesSell = Double.parseDouble(sellStr);
        stonks.sellStonks(ticker, sharesSell);
    }

    // Prompts the user using the given Scanner for the file name to save the current stocks in
    // the user's portfolio
    public static void saveStonks(Scanner input, Stonks stonks) throws FileNotFoundException {
        System.out.print("Enter new portfolio file name: ");
        String fileName = input.nextLine();
        stonks.saveStonks(fileName);
    }

}
