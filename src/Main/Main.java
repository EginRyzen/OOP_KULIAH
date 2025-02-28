package Main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Minuman> minumanList = new ArrayList<>();
        minumanList.add(new Minuman("Coca Cola", "Putih", 5000, "Kopi", 2, 0));
        minumanList.add(new Minuman("Coca Cola", "Putih", 5000, "Teh", 2, 0));
        minumanList.add(new Minuman("Coca Cola", "Putih", 5000, "Air Putih", 4, 0.2));

        minumanList.get(2).setName("Aqua");
        minumanList.get(2).setHarga(-1);
        minumanList.get(2).setQuantity(2);

        System.out.println("\nGet Minuman : " + minumanList.get(2).getName() + " \n");

        for (Minuman air : minumanList) {

            air.display();
            System.out.println();
        }

    }
}
