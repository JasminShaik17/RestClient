package cubex.mahesh.restclient

import cubex.mahesh.restclient.PNRStatusPOJO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RailwayAPI {

    @GET("v2/pnr-status/pnr/{pnrno}/apikey/3w7kegzbz0/")
    fun getPNRStatus(@Path("pnrno")  s:String ) : Call<PNRStatusPOJO>

}