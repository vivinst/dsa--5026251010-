import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] data = {5, 8, 7, 2, 3, 4, 9};
        // bubbleSort(data);
        selectionSort(data);
    }
    // public static void bubbleSort(int[] data) {
    //     for(int a = data.length - 1; a >= 0; a--) {
    //         for(int b = 0; b < a; b++) {
    //             if(data[b] < data[b + 1]) {
    //                 int temp = data[b];
    //                 data[b] = data[b + 1];
    //                 data[b + 1] = temp;
    //             }
    //         }
    //     }
    //     for(int d : data) {
    //         System.out.print(d + " ");
    //     }
    // }
    public static void selectionSort(int[] data) {
        for(int a = 0; a < data.length - 1; a++) {
            int minIndex = a;
            for(int b = a + 1; b < data.length; b++) {
                if(data[b] < data[minIndex]) {
                    minIndex = b;
                }
            }
            int temp = data[a];
            data[a] = data[minIndex];
            data[minIndex] = temp;
        }
        for(int d : data) {
            System.out.print(d + " ");
        }
    }
    public class Main {
        public static void main(String[] args) {
            int[] arr = {8, 4, 6, 2, 10, 1};

            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }

                arr[j + 1] = key;
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    public static void binarySearch(int[] data, int target) {
    int left = 0;
    int right = data.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;

        if (data[mid] == target) {
            System.out.println(target + ": FOUND at index " + mid);
            return;
        } else if (data[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    System.out.println(target + ": NOT FOUND");
}

}
