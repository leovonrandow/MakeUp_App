package br.com.leovonrandow.makeup.services

import br.com.leovonrandow.makeup.models.ListMakeupartist
import br.com.leovonrandow.makeup.models.Makeupartist
import retrofit2.Call
import retrofit2.http.GET

interface ServiceMakeupArtists {

    @GET("0f7e12a4-3c8e-4b55-972c-7f0ed1172b19")
    fun getMakeupArtists() : Call<List<Makeupartist>>
}