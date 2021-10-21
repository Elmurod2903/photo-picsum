package uz.elmurod.photospicsum.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import dagger.hilt.android.AndroidEntryPoint
import uz.elmurod.photospicsum.ui.MainActivity
import uz.elmurod.photospicsum.databinding.ActivitySplashBinding


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animationView.postDelayed({
            finish()
                startActivity(Intent(this, MainActivity::class.java))
        }, 3000)

    }
}