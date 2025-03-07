package Main;

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

    protected void setHarga(double harga) {
        if (harga >= 0.0) {
            this.harga = harga;
        } else {
            System.out.println("\nInvalid set harga karena harga dibawah Rp. 0\n");
        }
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getQuatity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Invalid set Quantity");
        }
    }

    public double getDicountRate() {
        return discountRate;
    }

    protected void setDiscountRate(double discountRate) {
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

    public void display() {
        System.out.println("Informasi Minuman : ");
        System.out.println("Name: " + name);
        System.out.println("Harga Rp. : " + String.format("%,.2f", getHarga()));
        System.out.println("Category: " + category);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount Rate: " + (getDicountRate() * 100) + "%");
        // System.out.println("Total Harga dengan diskon : Rp. " +
        // String.format("%,.2f", calculateTotalPrice()));
    }

}
