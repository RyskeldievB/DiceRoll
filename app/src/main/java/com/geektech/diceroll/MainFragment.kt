package com.geektech.diceroll

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.geektech.diceroll.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var randomNum: Random

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRoll.setOnClickListener() {
            var firstNum = generateNum()
            var secondNum = generateNum()

            Glide.with(this).load(loadImg(firstNum)).into(binding.ivRoll1)
            Glide.with(this).load(loadImg(secondNum)).into(binding.ivRoll2)

            Toast.makeText(
                requireContext(), (firstNum + secondNum).toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateNum(): Int {
        randomNum = Random
        return randomNum.nextInt(6) + 1
    }

    private fun loadImg(num: Int): String? {
        when (num) {
            1 -> return "https://img.icons8.com/windows/344/dice-one.png"
            2 -> return "https://img.icons8.com/windows/344/dice-two.png"
            3 -> return "https://img.icons8.com/windows/344/dice-three.png"
            4 -> return "https://img.icons8.com/windows/344/dice-four.png"
            5 -> return "https://img.icons8.com/windows/344/dice-five.png"
            6 -> return "https://img.icons8.com/windows/344/dice-six.png"
        }
        return null
    }
}