package presentation.landing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lifeteer_aos.databinding.ActivityLandingFragmentHolderBinding

class LandingFragmentHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityLandingFragmentHolderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val viewPagerAdapter = ViewpagerFragmentAdapter(this)
        binding.landingViewpager.adapter = viewPagerAdapter
        binding.dotIndicator.attachTo(binding.landingViewpager)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, LandingActivity::class.java))
            finish()
        }
        //뒤로가기 버튼 입력 시, 랜딩페이지 0번째 페이지로 이동
    }

    private inner class ViewpagerFragmentAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        val fragmentList = listOf<Fragment>(
            FragmentLandingFirst(),
            FragmentLandingSecond(),
            FragmentLandingThird(),
            FragmentLandingFourth()
        )

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }
}