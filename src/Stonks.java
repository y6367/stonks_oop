import java.util.*;
import java.io.*;

public class Stonks {
//    private String fileName;
    private int stockAmount;
    private String[] stocks;
    private double[] prices;
    private double[] portfolio;

    public Stonks(String fileName) throws FileNotFoundException {
//        this.fileName = fileName;
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

    public boolean displayStonks() {
        System.out.println("Portfolio:");
        for (int i = 0; i < stockAmount; i++) {
            if (portfolio[i] > 0.0) {
                System.out.println(stocks[i] + " " + portfolio[i]);
            }
        }
        return true;
    }


    public void saveStonks(String fileName) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File(fileName));
        for (int i = 0; i < stockAmount; i++) {
            if (portfolio[i] > 0.0) {
                output.println(stocks[i] + " " + portfolio[i]);
            }
        }
    }

    public void quitStonks() {
        double value = 0;
        for (int i = 0; i < stockAmount; i++) {
            value += prices[i] * portfolio[i];
        }
        System.out.println();
        System.out.println("Your portfolio is currently valued at: $" + value);
    }
}