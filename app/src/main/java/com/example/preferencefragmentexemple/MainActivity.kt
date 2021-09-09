package com.example.preferencefragmentexemple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.preferencefragmentexemple.databinding.ActivityMainBinding
import com.example.preferencefragmentexemple.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        binding.textView.text = prefs.getBoolean("switch", false).toString()
        binding.textView2.text = prefs.getString("editText", "empty")
        binding.textView3.text = prefs.getInt("seekBar", 1).toString()

        super.onResume()
    }
}