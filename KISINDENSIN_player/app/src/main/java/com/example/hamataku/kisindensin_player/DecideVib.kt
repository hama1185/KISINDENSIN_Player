package com.example.hamataku.kisindensin_player

import android.content.Context
import android.os.Handler
import android.os.Vibrator
import java.util.*

class DecideVib (context: Context, handler: Handler, puttern : Int): TimerTask() {
    val mContext = context
    var i : Int = puttern
    val mHandler : Handler = handler
    override fun run()
    {
        mHandler.post {
            var vibrator: Vibrator = mContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            var vib_puttern: LongArray? = longArrayOf(0, 1, 19)
            when(i){
                18 -> vib_puttern = longArrayOf(0, 50, 2500)
                13 -> vib_puttern = longArrayOf(0, 50, 2000)
                10 -> vib_puttern = longArrayOf(0, 50, 1500)
                9 -> vib_puttern = longArrayOf(0, 50, 1250)
                8 -> vib_puttern = longArrayOf(0, 50, 1000)
                5 -> vib_puttern = longArrayOf(0, 50, 750)
                4 -> vib_puttern = longArrayOf(0, 50, 500)
                2 -> vib_puttern = longArrayOf(0, 50, 400)
                1 -> vib_puttern = longArrayOf(0, 50, 300)
                0 -> vib_puttern = longArrayOf(0, 50, 150)
            }

            vibrator.vibrate(vib_puttern, 0)//本当なら0

        }
    }
}