package com.example.hamataku.kisindensin_player

import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.View
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.mlkcca.client.MilkCocoa
import com.nifcloud.mbaas.core.DoneCallback
import com.nifcloud.mbaas.core.NCMB
import com.nifcloud.mbaas.core.NCMBException
import com.nifcloud.mbaas.core.NCMBObject
import org.json.JSONObject

class DecideWin(context: Context, handler : Handler, puttern : Int?, player_name : String) {
    val mContext = context
    val mHandler: Handler = handler
    var mputtern = puttern
    var mplayer_name = player_name

    val appkey: String = "743f43fe6900287199691df86b432fe72e2e1789ea345b6d6833dd179e3e6c8b"
    val clientkey: String = "d70d333d1bb740297e8d50db26c54ea452014a70cb11e9e980deb345241f3e8a"
    var flag : Boolean = false

    //NCMB.initialize(this.applicationContext, appkey, clientkey)
    var ncmbObject = NCMBObject("KishinDenshin")

    fun run(catchCount : Int, count : Int){
        mHandler.post(
                Runnable {
                    if (mputtern == 0){
                        flag = true

                        NCMB.initialize(mContext, appkey, clientkey)

                        if(mplayer_name == "player1"){
                            try
                            {
                                //ncmbObject.put("win", mplayer_name)
                                ncmbObject.put(mplayer_name + "sum", count)
                                ncmbObject.put(mplayer_name + "get", catchCount)
                            }catch (e : NCMBException)
                            {
                                e.printStackTrace()
                            }
                        }
                        if(mplayer_name == "player2"){
                            //ncmbObject.put("win", mplayer_name)
                            ncmbObject.put(mplayer_name + "sum", count)
                            ncmbObject.put(mplayer_name + "get", catchCount)
                        }

                        ncmbObject.saveInBackground(DoneCallback{
                            fun done(e : NCMBException){
                                if(e != null){
                                    Log.v("失敗", "failed")
                                }else{
                                    Log.v("成功", "success")
                                }
                            }
                        }
                        )
                    }
                }
        )}

    fun FLAG(): Boolean {
        flag = mputtern == 0
        return flag
    }
}