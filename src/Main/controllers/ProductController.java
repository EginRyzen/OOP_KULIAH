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

    // Create Product atau addProduct
    public void addPoduct() {
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

    // Menampilkan informasi produk berdasarkan pilihan pengguna
    public void getProductByIndex() {
        int index = getValidProductIndex();
        int choice = getValidChoice();

        Product produk = productList.get(index);
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
                System.out.println("Jumlah Produk: " + produk.getQuantity());
                break;
            case 5:
                System.out.println("Diskon Produk: " + produk.getDiscountRate() + "%");
                break;
        }
    }

    // Mengubah informasi produk berdasarkan input pengguna
    public void setProductByIndex() {
        int index = getValidProductIndex();
        int choice = getValidChoice();

        Product produk = productList.get(index);
        scanner.nextLine(); // Membersihkan buffer

        switch (choice) {
            case 1:
                System.out.print("Masukkan nama baru: ");
                produk.setName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Masukkan harga baru: ");
                produk.setHarga(getValidDouble());
                break;
            case 3:
                System.out.print("Masukkan category baru: ");
                produk.setCategory(scanner.nextLine());
                break;
            case 4:
                System.out.print("Masukkan quantity baru: ");
                produk.setQuantity(getValidInt());
                break;
            case 5:
                System.out.print("Masukkan discount baru (%): ");
                produk.setDiscountRate(getValidDouble());
                break;
        }
        System.out.println("Data Produk berhasil diperbarui!");
        System.out.println(produk.getDetail());
    }

    public void sortProductByPrice() {
        System.out.println("\nPilih metode sorting:");
        System.out.println("1. Harga Terendah ke Tertinggi");
        System.out.println("2. Harga Tertinggi ke Terendah");
        System.out.print("Masukkan pilihan (1/2): ");

        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Error: Pilihan harus 1 atau 2!");
                }
            } else {
                System.out.print("Error: Masukkan angka yang valid! : ");
                scanner.next();
            }
        }

        boolean ascending = (choice == 1);
        Product.sortProducts(productList, ascending);

        // Tampilkan hasil sorting
        System.out.println("\nProduk setelah sorting:");
        for (Product product : productList) {
            System.out.println();
            System.out.println(product.getDetail());
        }

    }

    // Mendapatkan index produk yang valid
    private int getValidProductIndex() {
        int index;
        while (true) {
            System.out.print("Masukkan index produk: ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                if (index >= 0 && index < productList.size()) {
                    return index;
                } else {
                    System.out.println("Error: Index tidak valid! Masukkan antara 0 - " + (productList.size() - 1));
                }
            } else {
                System.out.println("Error: Harus memasukkan angka!");
                scanner.next();
            }
        }
    }

    // Mendapatkan pilihan menu yang valid
    private int getValidChoice() {
        int choice;
        while (true) {
            System.out.println("Pilih informasi yang ingin diakses atau diubah:");
            System.out.println("1. Nama");
            System.out.println("2. Harga");
            System.out.println("3. Category");
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

    // Validasi angka desimal
    private int getValidInt() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Error: Masukkan angka yang valid!");
                scanner.next();
            }
        }
    }

    // Validasi angka desimal (double)
    private double getValidDouble() {
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
