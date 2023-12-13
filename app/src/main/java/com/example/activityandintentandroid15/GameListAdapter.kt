package com.example.activityandintentandroid15

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.activityandintentandroid15.databinding.ItemGameBinding

class GameListAdapter : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {

    private var games = listOf<Game>()

    fun setData(data: List<Game>) {
        games = data
    }

    class GameViewHolder(private val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(game: Game) = with(binding) {
            ivGameCover.setImageResource(game.image)
            tvGameTitle.text = game.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.onBind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }
}