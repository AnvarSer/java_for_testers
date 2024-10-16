package ru.stqa.geometry.figures;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void printTriangleArea(Triangle triangle) {
        String text = String.format("Периметр треугольника со сторонами %f и %f и %f = %f", triangle.a, triangle.b, triangle.c, triangle.trianglePerimeter());
        System.out.println(text);

        String text2 = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", triangle.a, triangle.b, triangle.c, triangle.triangleArea());
        System.out.println(text2);

    }

    public double trianglePerimeter() {
        return (a + b + c);
    }

    public double triangleArea() {
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}
