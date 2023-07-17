package com.example.myapplication2.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication2.R
import com.example.myapplication2.databinding.ItemOnbordingBinding


class OnbordingItemFragment : Fragment() {
    private lateinit var binding: ItemOnbordingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemOnbordingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val step = arguments?.getInt("position") ?: 1
        when (step) {
            0 -> {
                binding.imageText.setText(R.string.onboarding_description_1)
                binding.imageView.setImageResource(R.drawable.message_icon)
            }

            1 -> {
                binding.imageText.setText(R.string.onboarding_description_2)
                binding.imageView.setImageResource(R.drawable.profile_icon)
            }

            2 -> {
                binding.imageText.setText(R.string.onboarding_description_3)
                binding.imageView.setImageResource(R.drawable.smartphone)
            }
        }
    }
}