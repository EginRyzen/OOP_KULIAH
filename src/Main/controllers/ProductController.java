package Main.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import Main.models.Product;

public class ProductController {

    private ArrayList<Product> productList;
    private Scanner scanner;

    public ProductController(ArrayList<Product> productList, Scanner scanner) {
        this.productList = productList;
        this.scanner = scanner;
    }

    // Tampilkan menu / get Menu
    public void getProduct() {

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("      📋 DAFTAR PRODUK      ");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        if (productList.isEmpty()) {
            System.out.println("❌ Tidak ada menu tersedia.");
        } else {
            int i = 1;
            for (Product menu : productList) {
                System.out.println("🔹 " + i + ". -------------------");
                menu.display();
                System.out.println();
                i++;
            }
        }

    }

    // Create Product atau addProduct
    public void addPoduct() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🛒 TAMBAH PRODUK KE MENU");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        String name;
        do {
            System.out.print("📌 Nama Produk: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("⚠️  Error: Nama produk tidak boleh kosong!");
            }
        } while (name.isEmpty());

        String category;
        do {
            System.out.print("📂 Kategori: ");
            category = scanner.nextLine().trim();
            if (category.isEmpty()) {
                System.out.println("⚠️  Error: Kategori tidak boleh kosong!");
            }
        } while (category.isEmpty());

        int harga;
        while (true) {
            System.out.print("💰 Harga (Harus lebih dari 0): ");
            if (scanner.hasNextInt()) {
                harga = scanner.nextInt();
                if (harga > 0)
                    break;
                System.out.println("⚠️  Error: Harga harus lebih dari 0!");
            } else {
                System.out.println("⚠️  Error: Input harus berupa angka!");
                scanner.next();
            }
        }

        int quantity;
        do {
            System.out.print("📦 Kuantitas (Harus lebih dari 0): ");
            while (!scanner.hasNextInt()) {
                System.out.print("⚠️  Error: Masukkan angka yang valid! ");
                scanner.next();
            }
            quantity = scanner.nextInt();
            if (quantity < 1) {
                System.out.println("⚠️  Error: Kuantitas harus lebih dari 0!");
            }
        } while (quantity < 1);
        scanner.nextLine();
        double discountRate;
        do {
            System.out.print("🎁 Diskon (%): ");
            while (!scanner.hasNextDouble()) {
                System.out.print("⚠️  Error: Masukkan angka yang valid! ");
                scanner.next();
            }
            discountRate = scanner.nextDouble();
            if (discountRate < 0) {
                System.out.println("⚠️  Error: Diskon tidak boleh negatif!");
            }
        } while (discountRate < 0);

        productList.add(new Product(name, harga, category, quantity, discountRate));

        System.out.println("\n✅ Produk berhasil ditambahkan!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // Menampilkan informasi produk berdasarkan pilihan pengguna
    public void getProductByIndex() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🔍 CARI PRODUK BERDASARKAN INDEX");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int index = getValidProductIndex();
        int choice = getValidChoice();
        Product produk = productList.get(index);

        System.out.println("\n📌 Informasi Produk:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        switch (choice) {
            case 1:
                System.out.println("🍽️ Nama Produk: " + produk.getName());
                break;
            case 2:
                System.out.println("💰 Harga Produk: Rp " + String.format("%,.2f", produk.getHarga()));
                break;
            case 3:
                System.out.println("📂 Kategori Produk: " + produk.getCategory());
                break;
            case 4:
                System.out.println("📦 Jumlah Produk: " + produk.getQuantity());
                break;
            case 5:
                System.out.println("🎁 Diskon Produk: " + produk.getDiscountRate() + "%");
                break;
            default:
                System.out.println("⚠️ Pilihan tidak valid!");
                break;
        }

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // Mengubah informasi produk berdasarkan input pengguna
    public void setProductByIndex() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("✏️  UPDATE DATA PRODUK");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int index = getValidProductIndex();
        int choice = getValidChoice();

        Product produk = productList.get(index);
        scanner.nextLine();
        System.out.println("\n🔄 Perbarui Informasi Produk:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        switch (choice) {
            case 1:
                System.out.print("📛 Masukkan nama baru: ");
                produk.setName(scanner.nextLine());
                break;
            case 2:
                System.out.print("💰 Masukkan harga baru: Rp ");
                produk.setHarga(getValidDouble());
                break;
            case 3:
                System.out.print("📂 Masukkan kategori baru: ");
                produk.setCategory(scanner.nextLine());
                break;
            case 4:
                System.out.print("📦 Masukkan jumlah baru: ");
                produk.setQuantity(getValidInt());
                break;
            case 5:
                System.out.print("🎁 Masukkan diskon baru (%): ");
                produk.setDiscountRate(getValidDouble());
                break;
            default:
                System.out.println("⚠️ Pilihan tidak valid!");
                return;
        }

        System.out.println("\n✅ Data Produk berhasil diperbarui!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        produk.display();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // Sort dengan menggunakan price
    public void sortProductByPrice() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📌 PILIH METODE SORTING");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1️⃣ Harga 🔽 Terendah → Tertinggi");
        System.out.println("2️⃣ Harga 🔼 Tertinggi → Terendah");
        System.out.print("📝 Masukkan pilihan (1/2): ");

        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("❌ Error: Pilihan harus 1 atau 2!");
                }
            } else {
                System.out.print("❌ Error: Masukkan angka yang valid! : ");
                scanner.next();
            }
        }

        boolean ascending = (choice == 1);
        Product.sortProducts(productList, ascending);

        // Menampilkan hasil sorting
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📦 DAFTAR PRODUK SETELAH SORTING");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        if (productList.isEmpty()) {
            System.out.println("⚠️ Tidak ada produk tersedia.");
        } else {
            int i = 1;
            for (Product product : productList) {
                System.out.println("🔹 Produk #" + i++);
                product.display();
                System.out.println();
            }
        }

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }

    // Search berdasarkan nama
    public void searchProductByName() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🔍 PENCARIAN PRODUK");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("📝 Masukkan nama produk yang ingin dicari: ");

        String searchName = scanner.nextLine().trim();

        if (searchName.isEmpty()) {
            System.out.println("❌ Error: Nama produk tidak boleh kosong!");
            return;
        }

        Product.searchProductByName(productList, searchName);
    }

    // Mendapatkan index produk yang valid
    private int getValidProductIndex() {
        int index;
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📌 PILIH PRODUK BERDASARKAN INDEX");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");

        while (true) {
            System.out.print("➡️ Masukkan index produk: ");

            if (scanner.hasNextInt()) {
                index = scanner.nextInt();

                if (index >= 0 && index < productList.size()) {
                    System.out.println("✅ Produk ditemukan! Index: " + index);
                    return index;
                } else {
                    System.out.println("❌ Error: Index tidak valid! Pilih antara 0 - " + (productList.size() - 1));
                }
            } else {
                System.out.println("⚠️ Error: Harus memasukkan angka!");
                scanner.next();
            }
        }
    }

    // Mendapatkan pilihan menu yang valid
    private int getValidChoice() {
        int choice;
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📌 PILIH INFORMASI PRODUK");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1️. Nama Produk");
        System.out.println("2️. Harga Produk");
        System.out.println("3️. Kategori Produk");
        System.out.println("4️. Jumlah Produk");
        System.out.println("5️. Diskon Produk");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        while (true) {
            System.out.print("➡️ Masukkan pilihan (1-5): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= 5) {
                    System.out.println("✅ Pilihan dikonfirmasi: " + choice);
                    return choice;
                } else {
                    System.out.println("❌ Error: Pilihan tidak valid! Masukkan angka antara 1-5.");
                }
            } else {
                System.out.println("⚠️ Error: Harus memasukkan angka!");
                scanner.next();
            }
        }
    }

    // Validasi angka desimal
    private int getValidInt() {
        while (true) {
            System.out.print("🔢 Masukkan angka: ");

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println("✅ Input diterima: " + number);
                return number;
            } else {
                System.out.println("❌ Error: Masukkan angka yang valid!");
                scanner.next();
            }
        }
    }

    // Validasi angka desimal (double)
    private double getValidDouble() {
        while (true) {
            System.out.print("💰 Masukkan angka desimal: ");

            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                System.out.println("✅ Input diterima: " + number);
                return number;
            } else {
                System.out.println("❌ Error: Masukkan angka desimal yang valid!");
                scanner.next();
            }
        }
    }

}
