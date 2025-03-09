package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Main.models.Product;
import Main.controllers.ProductController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Coca Cola", 5000, "Minuman", 2, 0));
        productList.add(new Product("Nasi Goreng", 5000, "Makanan", 2, 0.2));
        productList.add(new Product("Tahu", 1000, "Gorengan", 4, 0));

        int inputMenu = 0;

        do {
            System.out.println("\n=== Kantin Supermarket ===");
            System.out.println("1. Tampilkan Menu");
            System.out.println("2. Tambah Menu");
            System.out.println("3. Get By Index dengan Encapulation");
            System.out.println("5. Sorting Harga (Terendah/Tertinggi)");
            System.out.println("6. Cari Produk berdasarkan Nama");
            System.out.println("7. Keluar");

            boolean validInput = false;

            while (!validInput) {
                System.out.print("Pilih menu: ");
                if (scanner.hasNextInt()) {
                    inputMenu = scanner.nextInt();
                    scanner.nextLine(); // Membuang newline
                    validInput = true; // Jika input valid, keluar dari loop
                } else {
                    System.out.println("Input tidak valid! Harap masukkan angka.");
                    scanner.nextLine(); // Membersihkan input yang salah
                }
            }

            ProductController productController = new ProductController(productList, scanner);

            switch (inputMenu) {
                case 1:
                    productController.getProduct();
                    break;
                case 2:
                    productController.addPoduct();
                    break;
                case 3:
                    productController.getProductByIndex();
                    break;
                case 4:
                    productController.setProductByIndex();
                    break;
                case 5:
                    productController.sortProductByPrice();
                    break;
                case 6:
                    productController.searchProductByName();
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }

        } while (inputMenu != 7);

        scanner.close();
    }
}
