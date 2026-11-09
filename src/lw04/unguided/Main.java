package lw04.unguided;
import java.util.*;

public class Main {
    public static void SelectionSort(int[] data, int pass) {
        for(int i = 0; i < pass && i < data.length - 1; i++) {
            int Index = i;
            for(int j = i + 1; j < data.length; j++) {
                if(data[j] < data[Index]) {
                    Index = j;
                }
            }
            if(Index != i) {
                int temp = data[i];
                data[i] = data[Index];
                data[Index] = temp;
            }
        }
    }

    public static int LinearSearch(int[] data, int target) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = sc.nextInt();
        int[] cards = new int[n];
        for(int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for(int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        SelectionSort(cards, 2);

        for(int i = 0; i < n; i++) {
            System.out.print(cards[i]);
            if(i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int i = 0; i < m; i++) {
            int index = LinearSearch(cards, targets[i]);
            if(index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }

}
