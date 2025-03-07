package Main.menu;

import java.util.ArrayList;
import java.util.Scanner;

import Main.Product;

public class getBy {

    // Fungsi untuk menampilkan menu
    public static void getByMenu(ArrayList<Product> productList, Scanner scanner) {
        // Meminta input Index
        int index = getValidProductIndex(scanner, productList);

        // Meminta input informasi yang ingin diambil
        int choice = getValidChoice(scanner);

        // Menampilkan hasil berdasarkan pilihan
        displayProductInfo(productList, index, choice);
    }

    // Fungsi untuk meminta input ID yang valid
    public static int getValidProductIndex(Scanner scanner, ArrayList<Product> productList) {
        int index;
        while (true) {
            System.out.print("Masukkan Index produk yang ingin Anda ambil: ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                if (index >= 0 && index < productList.size()) {
                    return index; // Index valid
                } else {
                    System.out
                            .println("Error: Index tidak valid! Masukkan Index antara 0 - " + (productList.size() - 1));
                }
            } else {
                System.out.println("Error: Harus memasukkan angka!");
                scanner.next();
            }
        }
    }

    // Fungsi untuk meminta input informasi yang ingin diambil
    public static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.println("Ingin mengambil informasi apa?");
            System.out.println("1. Nama");
            System.out.println("2. Harga");
            System.out.println("3. Category");
            System.out.println("4. Quantity");
            System.out.println("5. Discount");
            System.out.print("Masukkan pilihan (1-5): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    return choice; // Jika pilihan valid
                } else {
                    System.out.println("Error: Pilihan tidak valid! Masukkan angka antara 1-5.");
                }
            } else {
                System.out.println("Error: Harus memasukkan angka!");
                scanner.next();
            }
        }
    }

    // Fungsi untuk menampilkan hasil
    public static void displayProductInfo(ArrayList<Product> productList, int id, int choice) {
        Product produk = productList.get(id);
        switch (choice) {
            case 1:
                System.out.println("Nama Produk: " + produk.getName());
                break;
            case 2:
                System.out.println("Harga Produk: Rp. " + produk.getHarga());
                break;
            case 3:
                System.out.println("Category Produk: " + produk.getCategory());
                break;
            case 4:
                System.out.println("Jumlah Produk: " + produk.getQuatity());
                break;
            case 5:
                System.out.println("Diskon Produk: " + produk.getDicountRate() + "%");
                break;
        }
    }
}
