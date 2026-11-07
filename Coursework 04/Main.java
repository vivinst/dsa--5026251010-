/**
 * ES234317 - Algorithms and Data Structures
 * Gasal | 2026-2027
 * Coursework   : 04
 * Student ID   : 5026251010
 * Full Name    : Vivin Setyowati
 * Class        : C
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Problem Test Case 1:");
        Integer[] a = {1, 3, 1, 4, 3, 7, -2, 0, 7, -2, -2, 1};
        ArrayList<Integer> v = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(twice(v));

        System.out.println("Problem Test Case 2:");
        String[] fNames = {"Marty", "Stuart", "Jessica", "Amanda", "Meghan", "Hal"};
        String[] lNames = {"Stepp", "Reges", "Miller", "Camp", "Miller", "Perkins"};
        String[] lNamesX = {"Stepp", "Reges", "Muller", "Camp", "Miller", "Perkins"};

        TreeMap<String, String> m1 = new TreeMap<String, String>();
        for (int i = 0; i < fNames.length; i++) {
            m1.put(fNames[i], lNames[i]);
        }

        TreeMap<String, String> m2 = new TreeMap<String, String>();
        for (int i = 0; i < fNames.length; i++) {
            m2.put(fNames[i], lNamesX[i]);
        }

        System.out.println(hasDuplicateValue(m1));
        System.out.println(hasDuplicateValue(m2));

        System.out.println("Problem Test Case 3:");
        Integer[] d1 = {3, 8, 17, 9, 17, 8, 3};
        Integer[] d2 = {3, 8, 17, 9, 4, 17, 8, 3};

        Queue<Integer> q1 = new LinkedList<Integer>(Arrays.asList(d1));
        Queue<Integer> q2 = new LinkedList<Integer>(Arrays.asList(d2));

        System.out.println(isPalindrome(q1));
        System.out.println(isPalindrome(q2));
    }

    public static Set<Integer> twice(List<Integer> l) {
        Set<Integer> s = new TreeSet<Integer>();
        // complete your code here

        for (int i = 0; i < l.size(); i++) {
            int count = 0;

            for (int j = 0; j < l.size(); j++) {
                if (l.get(i).equals(l.get(j))) {
                    count++;
                }
            }

            if (count == 2) {
                s.add(l.get(i));
            }
        }

        return s;
    }

    public static boolean hasDuplicateValue(Map<String, String> m) {
        boolean s = false;
        // complete your code here

        Set<String> values = new HashSet<String>();
        values.addAll(m.values());

        if (values.size() < m.size()) {
            s = true;
        }

        return s;
    }

    public static boolean isPalindrome(Queue<Integer> q) {
        boolean s = false;
        // complete your code here

        Stack<Integer> stack = new Stack<Integer>();
        int size = q.size();
        s = true;

        for (int i = 0; i < size; i++) {
            int element = q.remove();
            stack.push(element);
            q.add(element);
        }

        for (int i = 0; i < size; i++) {
            int element = q.remove();

            if (element != stack.pop()) {
                s = false;
            }

            q.add(element);
        }

        return s;
    }

    public static void collectionMystery4(ArrayList<Integer> v) {
        for (int i = 1; i < v.size(); i += 2) {
            if (v.get(i - 1) >= v.get(i)) {
                v.remove(i);
                v.add(0, 0);
            }
        }
        System.out.println(v);
    }

    public static void collectionMystery9(Queue<Integer> queue, int p) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int element = queue.remove();

            if (element < p) {
                queue.add(element);
            } else {
                count++;
                stack.push(count);
                stack.push(element);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        System.out.println(queue);
    }
}
