package Main.models;

public class Client extends User {
    public Client(String username, String password, String name, String email, int umur) {
        super(username, password, name, email, umur);
    }

    @Override
    public String getRole() {
        return "Client";
    }
}
