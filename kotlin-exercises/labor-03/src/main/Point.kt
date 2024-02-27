package main

data class Point(val x:Double, val y:Double)

fun Point.distanceFromOrigo():Double{
    return Math.sqrt(x*x+y*y);
}
