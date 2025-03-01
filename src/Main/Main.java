package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Coca Cola", 5000, "Kopi", 2, 0));
        productList.add(new Product("Coca Cola", 5000, "Teh", 2, 0));
        productList.add(new Product("Coca Cola", 5000, "Air Putih", 4, 0.2));

        int inputMenu;

        do {
            System.out.println("\n=== Kantin Supermarket ===");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Hapus Menu");
            System.out.println("3. Ubah Menu");
            System.out.println("4. Tampilkan Menu");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            inputMenu = scanner.nextInt();
            scanner.nextLine(); // Membuang newline

            switch (inputMenu) {
                case 1:
                    tambahMenu(productList, scanner);
                    break;
                // case 2:
                // hapusMenu(minumanList, scanner);
                // break;
                // case 3:
                // ubahMenu(minumanList, scanner);
                // break;
                // case 4:
                // tampilkanMenu(minumanList);
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

        for (Product air : productList) {

            air.display();
            System.out.println();
        }

    }

    // Fungsi menambah menu
    public static void tambahMenu(ArrayList<Product> productList, Scanner scanner) {
        System.out.println("\n=== Tambah Menu ===");
        System.out.print("Nama Produk: ");
        String name = scanner.nextLine();
        System.out.print("Harga: ");
        int harga = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Diskon: ");
        double discountRate = scanner.nextDouble();

        productList.add(new Product(name, harga, category, quantity, discountRate));
        System.out.println("Produk berhasil ditambahkan!");
    }

}
