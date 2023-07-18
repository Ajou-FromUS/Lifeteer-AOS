package presentation.landing

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifeteer_aos.databinding.FragmentLandingFourthBinding

class FragmentLandingFourth : Fragment() {
    private lateinit var binding: FragmentLandingFourthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandingFourthBinding.inflate(inflater, container, false)
        binding.btnStartMindset.setOnClickListener {
            //val intent = Intent(activity, LoginActivity::class.java)
            //startActivity(intent)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}