package com.tera.scroll

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.tera.scroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Navigation bar color
        val color = ContextCompat.getColor(this, R.color.navigation)
        enableEdgeToEdge(navigationBarStyle = SystemBarStyle.light(color, color))

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Color of navigation bar buttons
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightNavigationBars = false

        initScroll()
    }

    private fun initScroll() = with(binding) {
        scroll1.setOnScrollListener { x, y ->
            scroll2.scrollTo(x, y)
        }
        scroll2.setOnScrollListener { x, y ->
            scroll1.scrollTo(x, y)
        }
    }


}