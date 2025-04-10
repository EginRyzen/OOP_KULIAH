package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Main.models.Client;
import Main.models.Owner;
import Main.models.Product;
import Main.models.User;
import Main.controllers.RoleController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new Owner("admin", "123", "Egin", "egin@mail.com", 25, "Jl. Kenanga No.10"));
        userList.add(new Client("user1", "abc", "Rina", "rina@mail.com", 20));
        userList.add(new Client("user2", "xyz", "Budi", "budi@mail.com", 22));

        RoleController roleController = new RoleController();
        User loggedInUser = roleController.loginUser(scanner, userList);

        System.out.println("Login berhasil sebagai " + loggedInUser.getRole());
        System.out.println("Selamat datang, " + loggedInUser.getName());

        if (loggedInUser instanceof Owner) {
            Owner owner = (Owner) loggedInUser;
            System.out.println("Alamat Anda: " + owner.getAlamat());
        }

        System.out.println("✅ Login berhasil sebagai " + loggedInUser.getRole() + ": " + loggedInUser.getUsername());

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Coca Cola", 5000, "Minuman", 2, 0));
        productList.add(new Product("Nasi Goreng", 5000, "Makanan", 2, 0.2));
        productList.add(new Product("Tahu", 1000, "Gorengan", 4, 0));

        if (loggedInUser instanceof Owner) {
            RoleController.tampilkanMenuOwner(loggedInUser, productList, scanner);
        } else if (loggedInUser instanceof Client) {
            RoleController.tampilkanMenuClient(loggedInUser, productList, scanner);
        }

        scanner.close();
    }
}
