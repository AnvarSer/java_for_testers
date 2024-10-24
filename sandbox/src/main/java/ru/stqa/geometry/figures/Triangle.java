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

        double minTriangle1, midTriangle1, maxTriangle1;

        if (a <= b && a <= c) {
            minTriangle1 = a;
        } else if (b <= a && b <= c) {
            minTriangle1 = b;
        } else {
            minTriangle1 = c;
        }

        if (a >= b && a >= c) {
            maxTriangle1 = a;
        } else if (b >= a && b >= c) {
            maxTriangle1 = b;
        } else {
            maxTriangle1 = c;
        }

        if ((a != minTriangle1) && (a != maxTriangle1)) {
            midTriangle1 = a;
        } else if ((b != minTriangle1) && (b != maxTriangle1)) {
            midTriangle1 = b;
        } else {
            midTriangle1 = c;
        }

        double minTriangle2, midTriangle2, maxTriangle2;

        if (triangle.a <= triangle.b && triangle.a <= triangle.c) {
            minTriangle2 = triangle.a;
        } else if (triangle.b <= triangle.a && triangle.b <= triangle.c) {
            minTriangle2 = triangle.b;
        } else {
            minTriangle2 = triangle.c;
        }

        if (triangle.a >= triangle.b && triangle.a >= triangle.c) {
            maxTriangle2 = triangle.a;
        } else if (triangle.b >= triangle.a && triangle.b >= triangle.c) {
            maxTriangle2 = triangle.b;
        } else {
            maxTriangle2 = triangle.c;
        }

        if ((triangle.a != minTriangle2) && (triangle.a != maxTriangle2)) {
            midTriangle2 = triangle.a;
        } else if ((triangle.b != minTriangle2) && (triangle.b != maxTriangle2)) {
            midTriangle2 = triangle.b;
        } else {
            midTriangle2 = triangle.c;
        }

        return Double.compare(minTriangle1, minTriangle2) == 0 && Double.compare(midTriangle1, midTriangle2) == 0 && Double.compare(maxTriangle1, maxTriangle2) == 0;
    }

//        return (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.c) == 0)
//                || (Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) == 0)
//                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) == 0)
//                || (Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) == 0)
//                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) == 0)
//                || (Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.a) == 0);
//    }

        @Override
        public int hashCode () {
            return 1;
        }
    }
