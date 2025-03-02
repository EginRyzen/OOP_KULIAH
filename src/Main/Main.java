package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Main.menu.tambahMenu;
import Main.menu.tampilkanMenu;
import Main.menu.getBy;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Coca Cola", 5000, "Minuman", 2, 0));
        productList.add(new Product("Nasi Goreng", 5000, "Makanan", 2, 0.2));
        productList.add(new Product("Tahu", 1000, "Gorengan", 4, 0));

        int inputMenu;

        do {
            System.out.println("\n=== Kantin Supermarket ===");
            System.out.println("1. Tampilkan Menu");
            System.out.println("2. Tambah Menu");
            System.out.println("3. Get By Menu dengan Encapulation");
            // System.out.println("3. Ubah Menu");
            // System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            inputMenu = scanner.nextInt();
            scanner.nextLine(); // Membuang newline

            switch (inputMenu) {
                case 1:
                    tampilkanMenu.listMenu(productList);
                    break;
                case 2:
                    tambahMenu.addPoduct(productList, scanner);
                    break;
                case 3:
                    getBy.getByMenu(productList, scanner);
                    break;
                // case 3:
                // ubahMenu(minumanList, scanner);
                // break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }

        } while (inputMenu != 5);

        scanner.close();

        // minumanList.get(2).setName("Aqua");
        // minumanList.get(2).setHarga(100);
        // minumanList.get(2).setQuantity(2);

        System.out.println("Get Minuman : " + productList.get(2).getName() + " \n");
    }

}
