package lw02.unguided;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Restaurant{
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> listfood = new LinkedList<>();
        LinkedList<String[]> listdrink = new LinkedList<>();
        LinkedList<String[]> orderBerhasil = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> orderGagal = new Stack<>();

        Scanner listOrder = new Scanner(Restaurant.class.getResourceAsStream("orders.txt"));

        while(listOrder.hasNextLine()){
            String baris = listOrder.nextLine();   
            String[] data = baris.split(" ");
            orders.add(data);
        }
         listOrder.close();

        listfood.add(new String[]{"Bakso", "2"});
        listfood.add(new String[]{"Sate", "1"});
        listfood.add(new String[]{"Soto", "2"});
        listdrink.add(new String[]{"EsTeh", "4"});
        listdrink.add(new String[]{"EsJeruk", "2"});

        queue.addAll(orders);

        while (!queue.isEmpty()) {
            String [] order = queue.poll();
            String food = order[1];
            String drink = order[2];

            String[] listfoods = null;
            String[] listdrinks = null;
            boolean ada = true;

           if(!food.equals("-")){
            for(String[] daftarfood : listfood){
                if(listfoods[0].equals(food)){
                    listfoods = daftarfood;
                    break;
                }
            }
            if(Integer.parseInt(listfoods[1])<= 0){
                ada = false;
            }
        }
          if(!drink.equals("-")){
                for(String[] daftarDrink : listdrink){
                    if(listdrinks[0].equals(drink)){
                        daftarDrink = daftarDrink;
                        break;
                    }
                }
                if (Integer.parseInt(listdrinks[1]) <= 0) {
                    ada = false;
                }
            }

            if(ada){
                if(listfoods != null){
                    int record = Integer.parseInt(listfoods[1]);
                    listfoods[1] = String.valueOf(record - 1);
                }
                if(listdrinks != null){
                    int record = Integer.parseInt(listdrinks[1]);
                    listdrinks[1] = String.valueOf(record -1);
                }
                orderBerhasil.add(order);
            } else {
                orderGagal.add(order);
            }
        }

        System.out.println("\n=== Successfully Processed Orders === ");
        for(String[] succes : orderBerhasil){
            System.out.println(succes[0] + " " + succes[1] + " "+ succes[2] + " " + succes[3]);
        }

        System.out.println("\n=== Remaining Food Stock ===");
        for(String[] makanan : listfood){
            System.out.println(makanan[0] + " : " + makanan[1]);
        }

        System.out.println("\n=== Remaining Drink Stock ===");
        for(String[] minuman : listdrink){
            System.out.println(minuman[0] + " : " + minuman[1]);
        }

        System.out.println("\n=== Failed Orders === ");
        while (!orderGagal.isEmpty()) {
            String[] orderGagal1 = orderGagal.pop();
            System.out.println(orderGagal1[0] + " " + orderGagal1[1] + " " + orderGagal1[2] + " " + orderGagal1[3]);
        }
    }   
}