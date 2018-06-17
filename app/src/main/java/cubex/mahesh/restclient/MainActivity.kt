package cubex.mahesh.restclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        var r = Retrofit.Builder().
     addConverterFactory(GsonConverterFactory.create()).
     baseUrl("https://api.railwayapi.com/").
                build()

     var api = r.create(RailwayAPI::class.java)

     var call:Call<PNRStatusPOJO> =
                                    api.getPNRStatus(et1?.text.toString())

     call.enqueue(object : retrofit2.Callback<PNRStatusPOJO> {
         override fun onFailure(call: Call<PNRStatusPOJO>?, t: Throwable?) {

             Toast.makeText(this@MainActivity,
                     "Exception is Raised",
                     Toast.LENGTH_LONG).show()



         }
        override fun onResponse(call: Call<PNRStatusPOJO>?, response: Response<PNRStatusPOJO>?) {

         var pnr_status =    response?.body()

            var list = mutableListOf<String>()
            list.add("Pnr No : "+pnr_status?.pnr)
            list.add("Train No : "+pnr_status?.train?.number)
            list.add("Train Name : "+pnr_status?.train?.name)
            list.add("From Station  : "+pnr_status?.fromStation?.name)
            list.add("To Station  : "+pnr_status?.toStation?.name)
            list.add("Total Psgrs  : "+pnr_status?.totalPassengers)
            var list_psgrs= pnr_status?.passengers
            for( psgr in list_psgrs!!)
            {
                list.add("Psgr No  : "+psgr.no)
                list.add("Psgr Status  : "+psgr.currentStatus)
            }
            var my_adapter = ArrayAdapter<String>(this@MainActivity,
                        android.R.layout.simple_list_item_single_choice,
                        list)
            lview?.adapter = my_adapter

        }
     })


    }
}
