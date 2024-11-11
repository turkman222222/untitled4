import kotlin.math.sqrt
import kotlin.math.pow

data class Point(val x: Double, val y: Double)

data class Triangle(val a: Point, val b: Point, val c: Point)

data class Circle(val center: Point, val radius: Double)

fun main() {
    // 1. Создаем точки треугольника
    val A = Point(0.0, 0.0)
    val B = Point(4.0, 0.0)
    val C = Point(2.0, 3.0)

    // 2. Создаем треугольник
    val triangle = Triangle(A, B, C)

    val circumscribedCircle = calculateCircumscribedCircle(triangle)

    // 4. Выводим результат
    println("Центр описанной окружности: (${circumscribedCircle.center.x}, ${circumscribedCircle.center.y})")
    println("Радиус описанной окружности: ${circumscribedCircle.radius}")
}


fun calculateCircumscribedCircle(triangle: Triangle): Circle {

    val a = calculateDistance(triangle.b, triangle.c)
    val b = calculateDistance(triangle.a, triangle.c)
    val c = calculateDistance(triangle.a, triangle.b)


    val s = (a + b + c) / 2
    val area = sqrt(s * (s - a) * (s - b) * (s - c))

    // 3. Вычисляем радиус описанной окружности
    val radius = (a * b * c) / (4 * area)


    val x = ((triangle.a.x * a * a) + (triangle.b.x * b * b) + (triangle.c.x * c * c)) / (2 * area)
    val y = ((triangle.a.y * a * a) + (triangle.b.y * b * b) + (triangle.c.y * c * c)) / (2 * area)

    // 5. Создаем окружность
    return Circle(Point(x, y), radius)
}


fun calculateDistance(point1: Point, point2: Point): Double {
    return sqrt((point2.x - point1.x).pow(2) + (point2.y - point1.y).pow(2))
}