package lw01.unguided;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {

        List<WashService> washs = new ArrayList<>();

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("lw01/unguided/washes.txt"));

       int n = scanner.nextInt();
            WashService[] wash = new WashService[n];
            int[] ArrayUnits = new int[n];

            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                int units = scanner.nextInt();

                ArrayUnits[i] = units;

            if (type.equalsIgnoreCase("Car")) {
                    wash[i] = new CarWash(id, days);
                } else if (type.equalsIgnoreCase("Motorcycle")) {
                    wash[i] = new MotorcycleWash(id, days);
                }
        }

           for (int i = 0; i < n; i++) {
                int totalCharge = wash[i].calculateCharge(ArrayUnits[i]);
                System.out.println(wash[i].getId() + " | " + wash[i].label() + " | " + totalCharge);
            }

            scanner.close();
        }
    }

