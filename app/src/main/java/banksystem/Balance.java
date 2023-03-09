package banksystem;

public class Balance {
    private String username;
    private int userbalance;

    private static final int[][] userInfo = {
        {10000},
        {5000}
    };

    public Balance(Login login) {
        getInfo(login);
    }

    private void getInfo(Login login) {
        this.username = login.getUsername();
        for (int i = 0; i < userInfo.length; i++) {
            if (i == 0 && username.equals("Deneme1")) {
                this.userbalance = userInfo[i][0];
            } else if (i == 1 && username.equals("Deneme2")) {
                this.userbalance = userInfo[i][0];
            }
        }
    }

    public int getUserbalance() {
        return userbalance;
    }
}