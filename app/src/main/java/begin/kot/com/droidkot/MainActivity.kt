package begin.kot.com.droidkot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val text = findViewById<TextView>(R.id.toast)
        toast.text="Hello Kotlin Make it easy for me"
        

    }
    
    //fun display()=Toast.makeText(applicationContext,"message",Toast.LENGTH_SHORT).show()
}
