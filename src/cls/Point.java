package cls;

/*
    点 对象示例
 */
public class Point {
    int x;       // x坐标
    int y;       // y坐标

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // 计算两点之间的距离
    // 利用a^2 + b^2 = c^2
    public double calcDistance(Point point){
        return Math.sqrt(Math.pow((getX() - point.getX()),2) + Math.pow((getY() - point.getY()),2));
    }

    public static void main(String[] args){
        Point point = new Point(0,3);

        double distance = point.calcDistance(new Point(4,0));
        System.out.println(distance);
    }
}
