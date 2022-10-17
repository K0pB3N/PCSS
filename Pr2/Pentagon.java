package Pr2;

public class Pentagon {

    private Point p3;
    private Point p1;
    private Point p2;
    private Point p4;
    private Point p5;

    public Pentagon(Point p1, Point p2, Point p3, Point p4, Point p5) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
    }

    public double getArea() {
        return Math.abs((p1.getX() - p5.getX()) * (p2.getY() - p1.getY()) - (p1.getX() - p2.getX()) * (p5.getY() - p1.getY())) / 2;
        
    }

}
