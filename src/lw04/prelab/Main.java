package lw04.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        
        int N = sc.nextInt();
        int[] branches = new int[N];
        for(int i = 0; i < N; i++) {
            branches[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] targets = new int[M];
        for(int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        for(int i=1; i<=3; i++) {
            int key = branches[i];
            int j = i - 1;
            while(j >= 0 && branches[j] < key) {
                branches[j + 1] = branches[j];
                j--;
            }
            branches[j + 1] = key;
        }
        for(int i=0; i<N; i++) {
            if(i>0) {
                System.out.print(" ");
            }
            System.out.print(branches[i]);
        }
        System.out.println();

        for(int i = 0; i <M; i++) {
            int index = -1;
            for(int j = 0; j < N; j++) {
                if(branches[j] == targets[i]) {
                    index = j;
                    break;
                }
            }
            if(index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }

}
