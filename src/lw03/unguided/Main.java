package lw03.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        List<String> enrollment = new ArrayList<>();
        Set<String> uniqueEnrollment = new HashSet<>();
        Map<String, Integer> enrollmentCount = new HashMap<>();
        int rejectedOperations = 0;
        System.out.println("===== Enrollment Checks =====");

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String operation = parts[0];
            String courseCode = parts[1];

            if (operation.equals("REGISTER")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0) {
                    rejectedOperations++;
                } else {
                    if (!uniqueEnrollment.contains(courseCode)) {
                        uniqueEnrollment.add(courseCode);
                        enrollment.add(courseCode);
                        enrollmentCount.put(courseCode, count);
                    }else {
                        int currentCount = enrollmentCount.get(courseCode);
                        enrollmentCount.put(courseCode, currentCount + count);
                    }
                }
            } else if (operation.equals("WITHDRAW")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0) {
                    rejectedOperations++;
                }else if (!uniqueEnrollment.contains(courseCode)) {
                    rejectedOperations++;
                }
                else if (enrollmentCount.get(courseCode) < count) {
                    rejectedOperations++;
                }else {
                    int currentCount = enrollmentCount.get(courseCode);
                    enrollmentCount.put(courseCode, currentCount - count);
                }
            } else if (operation.equals("CHECK")) {
                if (uniqueEnrollment.contains(courseCode)) {
                    System.out.println(courseCode + ": " + enrollmentCount.get(courseCode) + " students");
                } else {
                    System.out.println(courseCode + ": Not found");
                }
            }
        }
        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (String course : enrollment) {
            System.out.println(course + ": " + enrollmentCount.get(course) + " students");
        }
        System.out.println();
        System.out.println("Rejected operations: " + rejectedOperations);
    }
}