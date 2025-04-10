package Main.models;

public class Owner extends User {
    private String alamat;

    public Owner(String username, String password, String name, String email, int umur, String alamat) {
        super(username, password, name, email, umur);
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    @Override
    public String getRole() {
        return "Owner";
    }
}
