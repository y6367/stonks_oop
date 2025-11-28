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
                System.out.print("Enter the stock ticker: ");
                String ticker = input.nextLine();
                System.out.print("Enter your budget: ");
                String budgetStr = input.nextLine();
                double budget = Double.parseDouble(budgetStr);
                stonks.buyStonks(ticker, budget);
            } else if (selection.equals("Se") || selection.equals("se") || selection.equals("SE")
                    || selection.equals("sE")) {
                System.out.print("Enter the stock ticker: ");
                String ticker = input.nextLine();
                System.out.print("Enter the number of shares to sell: ");
                String sellStr = input.nextLine();
                double sharesSell = Double.parseDouble(sellStr);
                stonks.sellStonks(ticker, sharesSell);
            } else if (selection.equals("D") || selection.equals("d")) {
                stonks.displayStonks();
            } else if (selection.equals("S") || selection.equals("s")) {
                System.out.print("Enter new portfolio file name: ");
                String fileName = input.nextLine();
                stonks.saveStonks(fileName);
            } else if (selection.equals("Q")  || selection.equals("q")) {
                stonks.quitStonks();
            } else {
                System.out.println("Invalid choice: " + selection);
                System.out.println("Please try again");
            }
        }
    }

}
