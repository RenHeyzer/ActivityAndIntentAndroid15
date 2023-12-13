package com.example.activityandintentandroid15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.activityandintentandroid15.databinding.ActivitySecondBinding
import com.google.android.material.button.MaterialButton

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            val savedCount = savedInstanceState.getInt(COUNT_KEY)
            count = savedCount
        }

        binding.tvCounter.text = count.toString()

        setupCounter()
    }

    private fun setupCounter() = with(binding) {
        btnIncrement.setOnClickListener {
            tvCounter.text = (++count).toString()
        }

        btnDecrement.setOnClickListener {
            tvCounter.text = (--count).toString()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putInt(COUNT_KEY, count)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        const val COUNT_KEY = "count"
    }
}