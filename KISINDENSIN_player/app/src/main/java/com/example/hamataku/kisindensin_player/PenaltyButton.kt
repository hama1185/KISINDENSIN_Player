package com.example.hamataku.kisindensin_player

import android.content.Context
import android.os.Handler
import android.view.View
import android.widget.Button
import java.util.*

class PenaltyButton(context: Context, handler: Handler, button : Button) : TimerTask() {
    val mContext = context
    val mHandler : Handler = handler
    var mbutton = button

    override fun run(){
        mHandler.post(
                Runnable {
                    mbutton.visibility = View.VISIBLE
                }
        )}
}