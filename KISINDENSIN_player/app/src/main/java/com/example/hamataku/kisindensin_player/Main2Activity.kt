package com.example.hamataku.kisindensin_player

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView3.text = intent.getIntExtra("GETSUM", -1).toString()
        textView4.text = intent.getIntExtra("CATCH", -1).toString()
    }
}
