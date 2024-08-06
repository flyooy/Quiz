public class User {
    private String userName;
    private int score;

    public User(String userName) {
        this.userName = userName;
        this.score = 0;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        this.score += 1;
    }


}
