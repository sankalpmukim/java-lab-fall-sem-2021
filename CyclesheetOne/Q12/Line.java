package Q12;

public class Line {
    int x1, y1, x2, y2;

    public Line(int X1, int Y1, int X2, int Y2) throws NumberFormatException {
        x1 = X1;
        y1 = Y1;
        x2 = X2;
        y2 = Y2;
        if (x1 == x2 && y1 == y2) {
            throw new NumberFormatException("Both points are same");
        }
    }

}
