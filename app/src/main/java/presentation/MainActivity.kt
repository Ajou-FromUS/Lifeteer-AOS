package presentation

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.lifeteer_aos.R
import com.example.lifeteer_aos.databinding.ActivityMainBinding
import presentation.diary.FragmentDiary
import presentation.mindSet.FragmentMindset
import presentation.myPage.FragmentMyPage
import presentation.record.FragmentRecorded

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(FragmentMindset())
        setLinearLayout(R.drawable.mindset_bi, "")

        binding.bnvMain.setOnItemSelectedListener { MenuItem ->
            when (MenuItem.itemId) {
                R.id.mindset -> {
                    replaceFragment(FragmentMindset())
                    setLinearLayout(0, "마음짓기")
                }
                R.id.diary -> {
                    replaceFragment(FragmentDiary())
                    setLinearLayout(0, "일기")
                }
                R.id.recorded -> {
                    replaceFragment(FragmentRecorded())
                    setLinearLayout(0, "음성유언 시뮬레이션")
                }
                R.id.mypage -> {
                    replaceFragment(FragmentMyPage())
                    setLinearLayout(0, "마이페이지")
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        Log.d("MainActivity", "${fragment}")
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.main_frameLayout, fragment)
                commit()
            }
    }
    private fun setLinearLayout(imageResId: Int?, text: String?) {
        val linearLayout = binding.fragMainLinear
        val fontResId = R.font.pretendard_regular
        val typeface = ResourcesCompat.getFont(this, fontResId)
        val textColor = getColor(R.color.mindset_main_black)
        linearLayout.removeAllViews()

        if(imageResId != null){
            val imageView = ImageView(this)
            imageView.setImageResource(imageResId)
            imageView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            linearLayout.addView(imageView)
        }
        if(!text.isNullOrEmpty()){
            val textView = TextView(this)
            textView.text = text
            textView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
            textView.setTextColor(textColor)
            textView.setTypeface(typeface,Typeface.NORMAL)
            linearLayout.addView(textView)
        }
    }
}