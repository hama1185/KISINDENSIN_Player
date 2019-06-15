package com.example.hamataku.kisindensin_player

class DecideCoordinates(current : Int) {
    var coordinate: Int = current
    fun generate_x(): Int {
            when (coordinate) {
                0 -> return 0
                1 -> return 1
                2 -> return 2
                3 -> return 3
                4 -> return 0
                5 -> return 1
                6 -> return 2
                7 -> return 3
                8 -> return 0
                9 -> return 1
                10 -> return 2
                11 -> return 3
                12 -> return 0
                13 -> return 1
                14 -> return 2
                15 -> return 3
                else -> {
                    return 0
                }
            }
    }



    fun generate_y(): Int {
            when (coordinate) {
                0 -> return 3
                1 -> return 3
                2 -> return 3
                3 -> return 3
                4 -> return 2
                5 -> return 2
                6 -> return 2
                7 -> return 2
                8 -> return 1
                9 -> return 1
                10 -> return 1
                11 -> return 1
                12 -> return 0
                13 -> return 0
                14 -> return 0
                15 -> return 0
                else -> {
                    return 0
                }
            }
        }


}
