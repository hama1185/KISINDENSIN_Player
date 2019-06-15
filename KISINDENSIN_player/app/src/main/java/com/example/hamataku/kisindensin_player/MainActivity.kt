package com.example.hamataku.kisindensin_player

import android.content.DialogInterface
import android.content.Intent
import android.net.sip.SipAudioCall
import android.net.sip.SipSession
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import com.mlkcca.client.DataElement
import com.mlkcca.client.DataStore
import com.mlkcca.client.DataStoreEventListener
import com.mlkcca.client.MilkCocoa

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), DataStoreEventListener {


    val app_id : String = "your_id.mlkcca.com"
    val key : String = "esp32"

    var player_name : String = "player"
    val handler : Handler = Handler()
    var timer : Timer? = null

    var penaltyButton : PenaltyButton? = null


    val time_pattern : LongArray = longArrayOf(3000, 3000, 3000, 3000, 3000, 3000, 3000, 3000, 3000, 3000)
    var decideVib : DecideVib? = null

    var decideWin : DecideWin? = null

    var decision : Int? = null


    var i : Int = 0

    var p1_current : Int? = 0
    var p2_current : Int? = 15

    var count : Int = 0
    var catchCount : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var milkcocoa : MilkCocoa
        var dataStore : DataStore

        milkcocoa = MilkCocoa(app_id)
        dataStore = milkcocoa.dataStore(key)
        dataStore.addDataStoreEventListener(this)
        dataStore.on("send")


        val button1 : Button = findViewById(R.id.button1)
        val button2 : Button = findViewById(R.id.button2)

        val p_button : Button = findViewById(R.id.penalty_button)
        val result_button :Button = findViewById(R.id.resultbutton)

        val listener = View.OnClickListener {
            v: View? ->
            when (v?.id) {
                button1.id -> {
                    player_name = "player1"

                    button1.visibility = View.GONE
                    button2.visibility = View.GONE

                }
                button2.id -> {
                    player_name = "player2"

                    button1.visibility = View.GONE
                    button2.visibility = View.GONE

                }

                p_button.id -> {
                    penaltyButton = PenaltyButton(this, handler, p_button)
                    timer = Timer(true)
                    p_button.visibility = View.INVISIBLE
                    timer?.schedule(penaltyButton, 3000)
                    count += 1
                    decideWin = DecideWin(this, handler, decision, player_name)
                    if(decideWin!!.FLAG()){
                        catchCount += 1
                    }
                    decideWin?.run(catchCount, count)
                }

                result_button.id ->{
                    val intent = Intent(this, Main2Activity::class.java)
                    intent.putExtra("GETSUM",count)
                    intent.putExtra("CATCH", catchCount)
                    startActivity(intent)
                }
            }
        }

        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        p_button.setOnClickListener(listener)
        result_button.setOnClickListener(listener)
    }

    override fun onSended(p0: DataElement?) {

        var pValue = p0?.value
        var key = pValue?.toJSONObject()?.keys()?.next()
        if(key == "player1") p1_current = pValue?.getInt("player1")
        if(key == "player2") p2_current = pValue?.getInt("player2")

        var test : String = "センサーデータ"
        Log.v(test, pValue.toString())
        Log.v(test, key.toString())
        Log.v(test, "player1 : "+ p1_current + " " + "player2 :" + p2_current)

        if(p1_current != null && p2_current != null) {


            var decidePattern: DecidePattern? = DecidePattern()

            var pattern: Int? = decidePattern?.returnpattern(p1_current!!, p2_current!!)//後で変更

            decision = pattern

            if (timer != null) {
                timer?.cancel()
            }

            if (pattern == 0) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 1) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 2) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 4) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 5) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 8) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 9) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 10) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 13) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
            if (pattern == 18) {
                decideVib = DecideVib(this, handler, pattern)

                timer = Timer(true)
                timer?.schedule(decideVib, time_pattern[i])
            }
        }

    }

    override fun onPushed(p0: DataElement?) {}

    override fun onRemoved(p0: DataElement?) {}

    override fun onSetted(p0: DataElement?) {}

}
