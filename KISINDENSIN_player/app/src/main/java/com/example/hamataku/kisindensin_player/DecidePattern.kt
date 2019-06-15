package com.example.hamataku.kisindensin_player

class DecidePattern() {
    fun returnpattern(p1 : Int, p2 : Int): Int {
        var decideCoordinatesP1: DecideCoordinates = DecideCoordinates(p1)
        var decideCoordinatesP2: DecideCoordinates = DecideCoordinates(p2)

        var p1_x = decideCoordinatesP1.generate_x()
        var p1_y = decideCoordinatesP1.generate_y()
        var p2_x = decideCoordinatesP2.generate_x()
        var p2_y = decideCoordinatesP2.generate_y()


        val x_max: Int = if (p1_x >= p2_x) (p1_x - p2_x) else (p2_x - p1_x)
        val y_max: Int = if (p1_y >= p2_y) (p1_y - p2_y) else (p2_y - p1_y)

        var puttern = x_max * x_max + y_max * y_max

        return puttern
    }
}