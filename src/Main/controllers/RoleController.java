package Main.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Main.models.Product;
import Main.models.User;

public class RoleController {

    public User loginUser(Scanner scanner, ArrayList<User> userList) {
        User loggedInUser = null;

        while (loggedInUser == null) {
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("       👤 LOGIN PENGGUNA        ");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            System.out.print("👤 Username: ");
            String inputUser = scanner.nextLine();
            System.out.print("🔒 Password: ");
            String inputPass = scanner.nextLine();

            for (User u : userList) {
                if (u.login(inputUser, inputPass)) {
                    loggedInUser = u;
                    break;
                }
            }

            if (loggedInUser == null) {
                System.out.println("❌ Username atau password salah. Silakan coba lagi.\n");
            }
        }

        return loggedInUser;
    }

    public static void tampilkanMenuOwner(User loggedInUser, ArrayList<Product> productList, Scanner scanner) {
        int inputMenu = 0;

        ProductController productController = new ProductController(productList, scanner);

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
    }

    public static void tampilkanMenuClient(User loggedInUser, ArrayList<Product> productList, Scanner scanner) {
        int inputMenu = 0;

        ProductController productController = new ProductController(productList, scanner);

        do {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  🍽️  KANTIN SUPERMARKET  🍽️  ");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  1️. | 📝 Tampilkan Menu");
            System.out.println("  2️. | 📊 Sorting Harga (⬇️ Terendah / ⬆️ Tertinggi)");
            System.out.println("  3️. | 🔎 Cari Produk berdasarkan Nama");
            System.out.println("  4️. | 🛒 Beli Produk");
            System.out.println("  5️. | ❌ Keluar");
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

            switch (inputMenu) {
                case 1:
                    productController.getProduct();
                    break;
                case 2:
                    productController.sortProductByPrice();
                    break;
                case 3:
                    productController.searchProductByName();
                    break;
                case 4:
                    productController.beliProduk();
                    break;
                case 5:
                    System.out.println("\n🚪 Terima kasih telah menggunakan aplikasi ini! 👋");
                    System.out.println("Created By Egin Sefiano Widodo (2025B)");
                    break;
                default:
                    System.out.println("\n⚠️ Pilihan tidak valid! Silakan pilih lagi.");
                    break;
            }

        } while (inputMenu != 5);
    }

}
