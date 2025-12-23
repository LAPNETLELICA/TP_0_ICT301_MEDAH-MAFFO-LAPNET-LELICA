/**before refactoring**/

package C.solid.lsp;

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getArea() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

public class Mainlsp {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(4); // Attend une aire de 20
        System.out.println("Aire du Rectangle =" + rectangle.getArea());

        Rectangle rectangle1 = new Square();
        rectangle1.setWidth(5);
        rectangle1.setHeight(4); // Attend une aire de 20, mais obtient 16 (4x4)
        System.out.println("Aire du Carre =" + rectangle1.getArea()); // Résultat inattendu
    }
}


/**after refactoring**/


package ict301.solid.lsp;

interface Shape {
    int getArea();
}

class Square implements Shape {
    private int side;
    public Square(int side) { this.side = side; }

    @Override
    public int getArea() {
        return side * side;
    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

public class Mainlsp2 {
    public static void main(String[] args) {
        Shape square = new Square(3);
        Shape rectangle = new Rectangle(3, 4);

        System.out.println("Square Area : " + square.getArea());
        System.out.println("Rectangle Area: " + rectangle.getArea());
    }
}

