package lw01.prelab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PrintJob> pj = new ArrayList<PrintJob>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        while(sc.hasNext()) {
            String type = sc.next();
            String id = sc.next(); 
            int pages = sc.nextInt();
            
            if(type.equals("MONO")) {
                pj.add(new MonoPrint(id, pages));
            }
            else if(type.equals("COLOUR")) {
                pj.add(new ColourPrint(id, pages));
            }
        }

        sc.close();

        for (PrintJob job : pj) {
            System.out.println(job.summary());
        }
    }

}
