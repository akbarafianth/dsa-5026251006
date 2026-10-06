package lw03.unguided;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        Set<String> regis = new LinkedHashSet<>(); 
        Scanner sc = new Scanner (Main.class.getResourceAsStream("registrations.txt"));
        while(sc.hasNextLine()){
            regis.add(sc.next());
        }
        sc.close();

        Set<String> ada = new HashSet<>();
        List<String> fix = new LinkedList<>();
        Scanner sc2 = new Scanner (Main.class.getResourceAsStream("checkins.txt"));
        int tolakRegist = 0;
        while(sc2.hasNextLine()){
            String id = sc2.next();
            if(!regis.contains(id)){
                fix.add(id + ": Rejected (not registered)");
                tolakRegist++;
            }
            else if(ada.contains(id)){
                fix.add(id + ": Rejected (already checked in)");
                tolakRegist++;
            }
            else{
                fix.add(id + ": Checked in");
                ada.add(id);
            }
        }
        sc2.close();
         System.out.println("===== Event Check-In Results =====");
         for(int i = 0 ; i< fix.size();i++){
            System.out.println(fix.get(i));
         }
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students:"+ regis.size());
        System.out.println("Successful check-ins:" + ada.size());
        System.out.println("Absent students:"+ (regis.size() - ada.size()));
        System.out.println("Rejected attempts:" + tolakRegist);
    }
}
