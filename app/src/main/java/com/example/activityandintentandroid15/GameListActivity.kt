package com.example.activityandintentandroid15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityandintentandroid15.databinding.ActivityGameListBinding

class GameListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameListBinding
    private val games = mutableListOf<Game>()
    private val gameListAdapter = GameListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillGameList()
        setupRecyclerView()
    }

    private fun fillGameList() {
        games.apply {
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
            add(Game(R.drawable.game_1, "Football Manager"))
        }
    }

    private fun setupRecyclerView() {
        binding.rvGames.adapter = gameListAdapter
        gameListAdapter.setData(games)
    }
}