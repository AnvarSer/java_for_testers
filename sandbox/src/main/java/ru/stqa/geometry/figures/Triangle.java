package ru.stqa.geometry.figures;

public record Triangle (
        double a,
        double b,
        double c)
{

    public Triangle {
        if (a < 0 || b < 0 || c < 0 || a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("Not possible to create a triangle with such sides. Also all triangle sides should be non-negative.");
        }
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
