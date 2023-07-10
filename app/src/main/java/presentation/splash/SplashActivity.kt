package presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import com.example.lifeteer_aos.R
import com.example.lifeteer_aos.databinding.ActivitySplashBinding
import presentation.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            loadAnim(tvTimeToMindset, R.anim.splash_fadein)
            loadAnim(tvMindset, R.anim.splash_fadein)
            loadAnim(ivMindsetBi, R.anim.splash_moveup)
        }
        moveNext()
    }

    private fun moveNext(){
        handler.postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }, (2000).toLong())
    }
    private fun loadAnim(view: View, animationResId: Int){
        val animation = AnimationUtils.loadAnimation(this, animationResId)
        view.startAnimation(animation)
    }
}