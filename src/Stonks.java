// Joewah Yu
// 11/30/2025
// CSE 122
// C3: OOP It!
// TA: Katharine Zhang
// This class facilitates all the actions requested by the user. It processes all the buying,
// selling, displaying, saving of stocks, and when exiting the stock market.

import java.util.*;
import java.io.*;

public class Stonks {
    private int stockAmount;
    private String[] stocks;
    private double[] prices;
    private double[] portfolio;

    // This constructor takes in a file containing a stock market that we base our stock market
    // simulator around
    // Exceptions:
    // - if file inputted doesn't exist, throw FileNotFoundException
    // Parameters:
    // - fileName: name of file to base stocks from
    public Stonks(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScan = new Scanner(file);
        this.stockAmount = fileScan.nextInt();

        this.stocks = new String[this.stockAmount];
        this.prices = new double[this.stockAmount];
        this.portfolio = new double[this.stockAmount];

        fileScan.nextLine();
        fileScan.nextLine();
        for (int i = 0; i < stockAmount; i++) {
            stocks[i] = fileScan.next();
            prices[i] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        System.out.println("There are " + stockAmount + " stocks on the market:");
        for (int i = 0; i < stockAmount; i++) {
            System.out.println(stocks[i] + ": " + prices[i]);
        }
    }

    // This method buys stocks with a minimum purchase of $5.
    // Returns:
    // - true/false depending on the stock was successfully bought
    // Parameters:
    // - ticker: to pick a stock to buy
    // - budget: to buy the amount of shares to buy with our budget
    public boolean buyStonks(String ticker, double budget) {
        if (budget < 5.0) {
            System.out.println("Budget must be at least $5");
            return false;
        } else {
            for (int i = 0; i < stockAmount; i++) {
                if (stocks[i].equals(ticker)) {
                    portfolio[i] += budget / prices[i];
                }
            }
            System.out.println("You successfully bought " + ticker + ".");
            return true;
        }
    }

    // This method sells stocks in portfolio only if user has enough shares to sell.
    // Returns:
    // - true/false depending on the stock was successfully sold
    // Parameters:
    // - ticker: to pick a stock to buy
    // - sharesSell: to buy the amount of shares to sell
    public boolean sellStonks(String ticker, double sharesSell) {
        for (int i = 0; i < stockAmount; i++) {
            if (stocks[i].equals(ticker)) {
                if (portfolio[i] < sharesSell) {
                    System.out.println("You do not have enough shares of " + ticker +
                            " to sell " + sharesSell + " shares.");
                    return false;
                } else {
                    portfolio[i] -= sharesSell;
                    System.out.println("You successfully sold " + sharesSell +
                            " shares of " + ticker + ".");
                    return true;
                }
            }
        }
        return false;
    }

    // This method displays shares of each owned stock.
    // Returns:
    // - true/false depending on the stock was successfully displayed
    public boolean displayStonks() {
        System.out.println("Portfolio:");
        for (int i = 0; i < stockAmount; i++) {
            if (portfolio[i] > 0.0) {
                System.out.println(stocks[i] + " " + portfolio[i]);
            }
        }
        return true;
    }

    // This method puts stocks that are in portfolio to new text file.
    // Exception:
    // - if file given by user fails to open, throw FileNotFoundException
    // Parameters:
    // - fileName: name of file to save stocks to
    public void saveStonks(String fileName) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        for (int i = 0; i < stockAmount; i++) {
            if (portfolio[i] > 0.0) {
                output.println(stocks[i] + " " + portfolio[i]);
            }
        }
    }

    // This method prints portfolio value before exiting the stock market simulator
    public void quitStonks() {
        double value = 0;
        for (int i = 0; i < stockAmount; i++) {
            value += prices[i] * portfolio[i];
        }
        System.out.println();
        System.out.println("Your portfolio is currently valued at: $" + value);
    }
}