package begin.kot.com.droidkot.data

import android.util.Log
import java.net.URL

class Request(val url: String) {

    fun run(){
        val forcastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forcastJsonStr)
    }
}