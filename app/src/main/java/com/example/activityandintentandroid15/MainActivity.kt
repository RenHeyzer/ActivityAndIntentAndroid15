package com.example.activityandintentandroid15

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activityandintentandroid15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToGoogle()
        goToYouTube()

        transitionToSecondActivity()
        chooseImageFromGallery()
    }

    private fun goToGoogle() {
        binding.googleContainer.setOnClickListener {
            val googleSearchUrl = "https://www.google.com/search?client=firefox-b-d&q="
            val query = binding.etInput.text.toString().trim()
            // Неявный намерение
            val googleIntent = Intent(Intent.ACTION_VIEW, Uri.parse("$googleSearchUrl$query"))
            startActivity(googleIntent)
        }
    }

    private fun goToYouTube() {
        binding.youtubeContainer.setOnClickListener {
            val youtubeSearchUrl = "https://www.youtube.com/results?search_query="
            val query = binding.etInput.text.toString().trim()
            // Неявное намерение
            val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("$youtubeSearchUrl$query"))
            startActivity(youtubeIntent)
        }
    }

    private fun transitionToSecondActivity() {
        binding.btnTransition.setOnLongClickListener {
            val text = binding.etInput.text.toString().trim()
            // Явное намерение
            Intent(this, SecondActivity::class.java).apply {
                startActivity(this)
            }
            false
        }
    }

    private fun chooseImageFromGallery() {
        binding.ivImage.setOnClickListener {
            // Неявное намерение
            Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
                startActivityForResult(this, CHOOSE_IMAGE_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CHOOSE_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                val image = data.data
                binding.ivImage.setImageURI(image)
            }
        }
    }


    companion object {
        const val TEXT_KEY = "text"
        const val CHOOSE_IMAGE_REQUEST_CODE = 222
    }
}