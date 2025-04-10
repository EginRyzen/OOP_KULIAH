package Main.models;

public abstract class User {
    protected String username;
    protected String password;

    protected String name;
    protected String email;
    protected int umur;

    public User(String username, String password, String name, String email, int umur) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.umur = umur;
    }

    public abstract String getRole();

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Getter umum
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getUmur() {
        return umur;
    }

    public String getUsername() {
        return username;
    }
}