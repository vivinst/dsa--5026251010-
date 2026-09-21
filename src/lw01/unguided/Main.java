package lw01.unguided;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        ArrayList<Rental> rentals = new ArrayList<Rental>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next(); 
            int days = sc.nextInt();
            int units = sc.nextInt();
            
            if(type.equals("LAPTOP")) {
                rentals.add(new LaptopRental(id, days));
            }
            else if(type.equals("PROJECTOR")) {
                rentals.add(new ProjectorRental(id, days));
            }
        }

        sc.close();

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }

}
