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
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  🍽️  KANTIN SUPERMARKET  🍽️  ");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  1️. | 📝 Tampilkan Menu");
            System.out.println("  2️. | ➕ Tambah Menu");
            System.out.println("  3️. | 🔍 Get By Index (Encapsulation)");
            System.out.println("  4️. | ✏️ Edit Produk berdasarkan Index");
            System.out.println("  5️. | 📊 Sorting Harga (⬇️ Terendah / ⬆️ Tertinggi)");
            System.out.println("  6️. | 🔎 Cari Produk berdasarkan Nama");
            System.out.println("  7️. | ❌ Keluar");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            boolean validInput = false;

            while (!validInput) {
                System.out.print("👉 Pilih menu: ");
                if (scanner.hasNextInt()) {
                    inputMenu = scanner.nextInt();
                    scanner.nextLine();
                    validInput = true;
                } else {
                    System.out.println("❌ Input tidak valid! Harap masukkan angka.");
                    scanner.nextLine();
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
                    System.out.println("\n🚪 Terima kasih telah menggunakan aplikasi ini! 👋");
                    System.out.println("Created By Egin Sefiano Widodo (2025B)");
                    break;
                default:
                    System.out.println("\n⚠️ Pilihan tidak valid! Silakan pilih lagi.");
                    break;

            }

        } while (inputMenu != 7);

        scanner.close();
    }
}
