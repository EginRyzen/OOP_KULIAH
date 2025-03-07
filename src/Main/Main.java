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
            System.out.println("3. Get By Index dengan Encapulation");
            System.out.println("4. Set By Index dengan Encapulation");
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
                case 4:
                    setProductInfo(productList, scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }

        } while (inputMenu != 5);

        scanner.close();
    }

    // Fungsi untuk mengubah informasi produk
    public static void setProductInfo(ArrayList<Product> productList, Scanner scanner) {
        // Memilih Index produk
        int index = getValidProductIndex(scanner, productList);

        // Memilih bagian yang ingin diubah
        int choice = getValidChoice(scanner);

        // Memilih informasi yang ingin diubah
        displayProductInfo(productList, index, choice, scanner);
    }

    // Fungsi untuk meminta input Index yang valid
    public static int getValidProductIndex(Scanner scanner, ArrayList<Product> productList) {
        int index;
        while (true) {
            System.out.print("Masukkan index produk yang ingin diubah: ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                if (index >= 0 && index < productList.size()) {
                    return index;
                } else {
                    System.out
                            .println("Error: index tidak valid! Masukkan index antara 0 - " + (productList.size() - 1));
                }
            } else {
                System.out.println("Error: Harus memasukkan angka!");
                scanner.next();
            }
        }
    }

    // Fungsi untuk meminta input pilihan yang valid
    public static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.println("Ingin mengubah informasi apa?");
            System.out.println("1. Nama");
            System.out.println("2. Harga");
            System.out.println("3. Jenis");
            System.out.println("4. Quantity");
            System.out.println("5. Discount");
            System.out.print("Masukkan pilihan (1-5): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Error: Pilihan tidak valid! Masukkan angka antara 1-5.");
                }
            } else {
                System.out.println("Error: Harus memasukkan angka!");
                scanner.next();
            }
        }
    }

    // Fungsi untuk menampilkan informasi produk
    public static void displayProductInfo(ArrayList<Product> productList, int index, int choice, Scanner scanner) {
        // Mendapatkan produk yang akan diubah
        Product produk = productList.get(index);

        // Memproses input sesuai bagian yang dipilih

        switch (choice) {
            case 1: // Mengubah Nama Produk
                System.out.print("Masukkan nama baru: ");
                scanner.nextLine(); // Membersihkan buffer
                String newName = scanner.nextLine();
                produk.setName(newName);
                System.out.println("Nama Produk berhasil diubah!");
                System.out.println(produk.getDetail());
                break;
            case 2: // Mengubah Harga
                System.out.print("Masukkan harga baru: ");
                double newHarga = getValidDouble(scanner);
                produk.setHarga(newHarga);
                System.out.println("Harga Produk berhasil diubah!");
                System.out.println(produk.getDetail());
                break;
            case 3: // Mengubah Category
                System.out.print("Masukkan Category baru: ");
                scanner.nextLine(); // Membersihkan buffer
                String newCategory = scanner.nextLine();
                produk.setCategory(newCategory);
                System.out.println("Category Produk berhasil diubah!");
                System.out.println(produk.getDetail());
                break;
            case 4: // Mengubah Quantity
                System.out.print("Masukkan quantity baru: ");
                int newQuantity = getValidInt(scanner);
                produk.setQuantity(newQuantity);
                System.out.println("Quantity Produk berhasil diubah!");
                System.out.println(produk.getDetail());
                break;
            case 5: // Mengubah Discount
                System.out.print("Masukkan discount baru (%): ");
                double newDiscount = getValidDouble(scanner);
                produk.setDiscountRate(newDiscount);
                System.out.println("Discount Produk berhasil diubah!");
                System.out.println(produk.getDetail());
                break;
        }
    }

    // Untuk validasi angka bulat (int)
    public static int getValidInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Error: Masukkan angka yang valid!");
                scanner.next();
            }
        }
    }

    // Untuk validasi angka desimal (double)
    public static double getValidDouble(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Error: Masukkan angka yang valid!");
                scanner.next();
            }
        }
    }

}
