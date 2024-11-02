package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle(
        double a,
        double b,
        double c) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;

//        return (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.c) == 0)
//                || (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) == 0)
//                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) == 0)
//                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) == 0)
//                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) == 0)
//                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.a) == 0);
//    }

        return (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0) ||
                (Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.a) == 0) ||
                (Double.compare(this.a, triangle.c) == 0 && Double.compare(this.b, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0) ||
                (Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.a) == 0 && Double.compare(this.c, triangle.c) == 0) ||
                (Double.compare(this.a, triangle.c) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.a) == 0) ||
                (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.b) == 0);
    }

    @Override
        public int hashCode () {
            return 1;
        }
    }
