package Main.menu;

import java.util.ArrayList;

import Main.Product;

public class tampilkanMenu {
    public static void listMenu(ArrayList<Product> productList) {

        System.out.println("=== Daftar Product ===");

        if (productList.isEmpty()) {
            System.out.println("Tidak ada menu tersedia.");
            return;
        } else {
            int i = 1;
            for (Product menu : productList) {
                System.out.println(i + ".");
                menu.display();
                System.out.println();
                i++;
            }
        }
    }

}
