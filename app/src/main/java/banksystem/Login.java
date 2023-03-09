package banksystem;

public class Login {
    private String username;

    private static final String[][] users = {
        {"Deneme1", "deneme123"},
        {"Deneme2", "merhaba123"}
    };

    public Login(String username, String password) {
        setUser(username, password);
    }

    public boolean checkCredentials(String username, String password) {
        for (String[] u : users) {
            if (u[0].equals(username) && u[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    private void setUser(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty");
        }

        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
