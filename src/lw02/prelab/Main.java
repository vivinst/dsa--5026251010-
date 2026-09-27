package lw02.prelab;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (Main.class.getResourceAsStream("transactions.txt"));

        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customer = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        while (sc.hasNextLine()) {
            transactions.add(sc.nextLine().split(" "));
        }
        sc.close();

        for (String[] transaction : transactions) {
            boolean exist = false;

            for (String[] cust : customer) {
                if (cust[0].equals(transaction[0])) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                customer.add(new String[]{transaction[0], "0"});
            }
        }

        for (String[] transaction : transactions) {
            queue.offer(transaction);
        }

        while (!queue.isEmpty()) {
            String[] transaction = queue.poll();

            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (String[] cust : customer) {
                if (cust[0].equals(name)) {
                    int currentAmount = Integer.parseInt(cust[1]);

                    if (type.equals("DEPOSIT")) {
                        currentAmount += amount;
                    } 
                    
                    else if (type.equals("WITHDRAW")) {

                        if (currentAmount >= amount) {
                            currentAmount -= amount;
                        } 
                        
                        else {
                            failedTransactions.push(transaction);
                        }
                    }

                    cust[1] = String.valueOf(currentAmount);
                    break;
                }
            }
        }

        System.out.println("=== Final Balance ===");

            for (String[] cust : customer) {
                System.out.println(cust[0] + ": " + cust[1]);
            }

        System.out.println();

        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] transaction = failedTransactions.pop();
            System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
        }
    }
}
