package Main.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Product {
    String name;
    private String category;
    protected double harga;
    public int quantity;

    protected double discountRate;

    public Product(String name, int harga, String category, int quantity, double discountRate) {
        this.name = name;
        this.harga = harga;
        this.category = category;
        this.quantity = quantity;
        this.discountRate = discountRate;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga >= 0.0) {
            this.harga = harga;
        } else {
            System.out.println("\nInvalid set harga karena harga dibawah Rp. 0\n");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Invalid set Quantity");
        }
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate >= 1) {
            this.discountRate = discountRate;
        } else {
            System.out.println("Invalid DicountRate");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // public double calculateTotalPrice() {
    // double total = harga * quantity;
    // double dicount = total * discountRate;
    // return total - dicount;
    // }

    public String getDetail() {
        return "Nama: " + name + "\nHarga: " + harga +
                "\nCategory: " + category + "\nQuantity: " + quantity +
                "\nDiscount: " + discountRate + "%";
    }

    // Proses sort harga dari yang mahal atau murah
    public static void sortProducts(ArrayList<Product> productList, boolean ascending) {
        if (ascending) {
            Collections.sort(productList, Comparator.comparingDouble(Product::getHarga));
        } else {
            Collections.sort(productList, Comparator.comparingDouble(Product::getHarga).reversed());
        }
    }

    // Search nama barang
    public static void searchProductByName(List<Product> productList, String searchName) {
        boolean found = false;
        System.out.println("\nHasil Pencarian:");
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(product.getDetail());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    public void display() {
        System.out.println("Informasi Minuman : ");
        System.out.println("Name: " + name);
        System.out.println("Harga Rp. : " + String.format("%,.2f", getHarga()));
        System.out.println("Category: " + category);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount Rate: " + (getDiscountRate() * 100) + "%");
        // System.out.println("Total Harga dengan diskon : Rp. " +
        // String.format("%,.2f", calculateTotalPrice()));
    }

}
