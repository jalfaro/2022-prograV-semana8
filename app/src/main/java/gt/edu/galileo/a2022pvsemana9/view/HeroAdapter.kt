package gt.edu.galileo.a2022pvsemana9.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gt.edu.galileo.a2022pvsemana9.databinding.ItemHeroBinding
import gt.edu.galileo.a2022pvsemana9.db.Hero

class HeroAdapter(val list: ArrayList<Hero>): RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {
    class HeroViewHolder(val binding: ItemHeroBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            binding.txtNombre.text = hero.name
            binding.txtEditorial.text = hero.editorial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
       val layoutInflater =LayoutInflater.from(parent.context)
        val binding = ItemHeroBinding.inflate(layoutInflater, parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun updateData(newList: List<Hero>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}