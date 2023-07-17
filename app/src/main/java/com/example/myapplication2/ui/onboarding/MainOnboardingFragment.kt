package com.example.myapplication2.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication2.R
import com.example.myapplication2.databinding.FragmentOnboardingMainBinding
import com.example.myapplication2.ui.RecyclerViewFragment


class MainOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //подключаем прокрутке адаптер и передаем ему фрагмент
        binding.pager.adapter = OnboardingAdapter(this)
        //передаем circleIndicator - ViewPager2
        binding.circleIndicator.setViewPager(binding.pager)
        // skip нажатие кнопки
        binding.skipText.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment, RecyclerViewFragment())
                .addToBackStack("").commit()
        }


    }
}