package br.com.leovonrandow.makeup.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.leovonrandow.makeup.R
import br.com.leovonrandow.makeup.models.Makeupartist
import coil.load
import coil.transform.CircleCropTransformation

class ArtistsAdapter (var context: Context, var artists: List<Makeupartist>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_maquiador, parent, false)
        return ArtistHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ArtistHolder).bind(context, artists[position])
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    class ArtistHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(context: Context, artists: Makeupartist) {

            var profile_photo = itemView.findViewById<ImageView>(R.id.avatar)
            profile_photo.load(artists.avatar){transformations(CircleCropTransformation())}

            var name = itemView.findViewById<TextView>(R.id.name)
            name.text = artists.user

            var insta = itemView.findViewById<TextView>(R.id.nameInsta)
            insta.text = artists.insta

            var categorias = itemView.findViewById<TextView>(R.id.categoriasList)
            categorias.text = artists.categorias.joinToString(", ")

            var localidade = itemView.findViewById<TextView>(R.id.lugar)
            localidade.text = artists.local

        }
    }
}