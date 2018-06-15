package cubex.mahesh.restclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var et1:EditText? = null
    var lview:ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1 = findViewById(R.id.et1)
        lview = findViewById(R.id.lview)
    }
    fun getPnrStatus(v:View){


    }
}
