package Q14;

public class Female {
    public int numDish1;
    public int numDish2;
    public int numDish3;
    public int numDish4;

    public Female(int dish1, int dish2, int dish3, int dish4) {
        this.numDish1 = dish1;
        this.numDish2 = dish2;
        this.numDish3 = dish3;
        this.numDish4 = dish4;
    }

    public int total() {
        return (numDish1 * 50) + (numDish2 * 75) + (numDish3 * 100) + (numDish4 * 150);
    }
}
