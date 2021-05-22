package br.com.leovonrandow.makeup.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.leovonrandow.makeup.R
import br.com.leovonrandow.makeup.models.ListMakeupartist
import br.com.leovonrandow.makeup.models.Makeupartist
import br.com.leovonrandow.makeup.services.RetrofitInitializer
import br.com.leovonrandow.makeup.ui.adapters.ArtistsAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getArtist()
    }

    fun getArtist() {

        var s = RetrofitInitializer().serviceArtists()
        var call = s.getMakeupArtists()
        call.enqueue(object : retrofit2.Callback<List<Makeupartist>>{
            override fun onResponse(call: Call<List<Makeupartist>>, response: Response<List<Makeupartist>>) {

                if (response.code() == 200) {

                    response.body()?.let {
                        show(it)
                    }

                }
            }

            override fun onFailure(call: Call<List<Makeupartist>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })

    }

    fun show(artists: List<Makeupartist>) {

        var list = findViewById<RecyclerView>(R.id.reciclerViewMaquiadores)
        list.adapter = ArtistsAdapter(this, artists)

        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        /*var snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(list)*/

    }
}