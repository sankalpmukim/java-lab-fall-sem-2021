package Q12;

import Q12.Exceptions.TriangleNotPossibleException;

public class Triangle {
    Line l1, l2;

    public boolean pointsEqual(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y1 == y2;
    }

    public Triangle(Line line1, Line line2) throws TriangleNotPossibleException {
        if ((pointsEqual(line1.x1, line1.y1, line2.x1, line2.y1) || pointsEqual(line1.x1, line1.y1, line2.x2, line2.y2)
                || pointsEqual(line1.x2, line1.y2, line2.x1, line2.y1)
                || pointsEqual(line1.x2, line1.y2, line2.x2, line2.y2)) == false) {
            throw new TriangleNotPossibleException("Points not connected");
        }
        l1 = line1;
        l2 = line2;
    }

    String success() {
        return ("Triangle created succesfully");
    }
}
