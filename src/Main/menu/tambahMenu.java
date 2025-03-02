package Main.menu;

import java.util.ArrayList;
import java.util.Scanner;
import Main.Product;

public class tambahMenu {

    // Fungsi menambah menu
    public static void addPoduct(ArrayList<Product> productList, Scanner scanner) {
        System.out.println("\n=== Tambah Menu ===");
        String name;
        do {
            System.out.print("Nama Produk: ");
            // Menghapus spasi awal & akhir dari input
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Nama produk tidak boleh kosong!");
            }
        } while (name.isEmpty());

        String category;
        do {
            System.out.print("Category: ");
            // Menghapus spasi awal & akhir dari input
            category = scanner.nextLine().trim();
            if (category.isEmpty()) {
                System.out.println("Error: Category tidak boleh kosong!");
            }
        } while (category.isEmpty());

        int harga;
        while (true) {
            System.out.print("Masukan Harga, harus lebih dari 0 : ");
            // Cek apakah input adalah angka
            if (scanner.hasNextInt()) {
                harga = scanner.nextInt();
                // Pastikan harga lebih dari 0
                if (harga > 0) {
                    // Keluar dari loop jika input valid
                    break;
                } else {
                    System.out.println("Error: Harga harus lebih dari 0!");
                }
            } else {
                System.out.println("Error: Input harus berupa angka!");
                // Buang input yang salah agar tidak masuk loop terus-menerus
                scanner.next();
            }
        }

        int quantity;
        do {
            System.out.print("Masukkan Quantity harus lebih dari 0 : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Error: Masukkan angka yang valid! : ");
                scanner.next();
            }
            quantity = scanner.nextInt();
            if (quantity < 0) {
                System.out.println("Error: Quantity harus lebih dari 0!");
            }
        } while (quantity < 0);
        scanner.nextLine();

        double discountRate;
        do {
            System.out.print("Masukan Diskon : ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Error: Masukkan angka yang valid! : ");
                scanner.next();
            }
            discountRate = scanner.nextDouble();
            if (discountRate < 0) {
                System.out.println("Error: Diskon tidak boleh negatif!");
            }
        } while (discountRate < 0);

        productList.add(new Product(name, harga, category, quantity, discountRate));
        System.out.println("Produk berhasil ditambahkan!");
    }
}