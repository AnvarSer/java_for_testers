package ru.stqa.geometry.figures;

public class Triangle {
    public static void printTriangleArea(double a, double b, double c) {
        var text = String.format("Периметр треугольника со сторонами %f и %f и %f = %f", a, b, c, printTrianglePerimeter(a, b, c));
        System.out.println(text);

        var text2 = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", a, b, c, triangleArea(a, b, c));
        System.out.println(text2);

    }

    public static double printTrianglePerimeter(double a, double b, double c) {
        return (a + b + c);
    }

    public static double triangleArea(double a, double b, double c) {
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));

    }


}
