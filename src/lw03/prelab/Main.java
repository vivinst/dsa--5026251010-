package lw03.prelab;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();

        while (sc.hasNextLine()) {
            String instruction = sc.nextLine();
            String[] song = instruction.split(" ", 3);

            if(song[0].equals("ADD")) {
                playlist.add(song[1]);
            } else if (song[0].equals("REMOVE")) {
                playlist.remove(song[1]);
            } else if (song[0].equals("INSERT")) {
                int index = Integer.parseInt(song[1]);
                String songName = song[2];
                playlist.add(index, songName);
            }
        }
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for(int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println();

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;

        while (sc2.hasNextLine()) {
            String line = sc2.nextLine();
            if(participants.contains(line)) {
                duplicate++;
            } else {
                participants.add(line);
            }
        }
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int index = 1;
        for (String participant : participants) {
            System.out.println(index + ". " + participant);
            index++;
        }
        System.out.println("Duplicate registrations: " + duplicate);
        System.out.println();

        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        while (sc3.hasNextLine()) {
            String line = sc3.nextLine();
            String[] parts = line.split(" ");
            String item = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if(parts[0].equals("ADD")) {
                inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
            } else if (parts[0].equals("SELL")) {
                if(inventory.getOrDefault(item, 0) >= quantity) {
                    inventory.put(item, inventory.get(item) - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}
