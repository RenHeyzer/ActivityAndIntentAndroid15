package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityandintentandroid15.R

class FragmentMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val firstFragment = FirstFragment()

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, firstFragment)
            .commit()
    }
}