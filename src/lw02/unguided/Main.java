package lw02.unguided;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> book = new LinkedList<>();
        LinkedList<String[]> stock = new LinkedList<>();
        LinkedList<String[]> member = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> fails = new Stack<>();

        stock.add(new String[]{"Kalkulus", "2"});
        stock.add(new String[]{"Fisika", "1"});
        stock.add(new String[]{"Statistika", "2"});

        while (sc.hasNextLine()) {
            book.add(sc.nextLine().split(" "));
        }

        sc.close();

        for (String[] b : book) {

            boolean exist = false;

            for (String[] m : member) {

                if (m[0].equals(b[0])) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                member.add(new String[]{b[0], "0"});
            }
        }

        for (String[] b : book) {
            queue.offer(b);
        }

        LinkedList<String[]> success = new LinkedList<>();

        while (!queue.isEmpty()) {
            String[] b = queue.poll();
            String name = b[0];
            String bookName = b[1];
            String[] selectedBook = null;
            String[] selectedMember = null;

            for (String[] s : stock) {

                if (s[0].equals(bookName)) {
                    selectedBook = s;
                    break;
                }
            }

            for (String[] m : member) {

                if (m[0].equals(name)) {
                    selectedMember = m;
                    break;
                }
            }

            int currentStock =
                Integer.parseInt(selectedBook[1]);

            int totalBorrow =
                Integer.parseInt(selectedMember[1]);

            if (currentStock > 0 && totalBorrow < 2) {
                currentStock--;

                selectedBook[1] = String.valueOf(currentStock);
                totalBorrow++;

                selectedMember[1] = String.valueOf(totalBorrow);
                success.add(b);

            } 
            else {
                fails.push(b);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] s : success) {
            System.out.println(s[0] + " " + s[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for (String[] s : stock) {
            System.out.println(s[0] + " : " + s[1]);
        }

        System.out.println("=== Failed Requests ===");
        while (!fails.isEmpty()) {
            String[] f = fails.pop();
            System.out.println(f[0] + " " + f[1]);
        }
    }
}