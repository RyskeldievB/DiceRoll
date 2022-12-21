package com.geektech.diceroll.main.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.geektech.diceroll.databinding.FragmentMainBinding
import com.geektech.diceroll.main.view.MainView

class MainFragment : Fragment(), MainView {
    private lateinit var binding: FragmentMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainPresenter()
        presenter.attachView(this)

        initClicker()
    }

    private fun initClicker() {
        binding.btnRoll.setOnClickListener() {
            presenter.generateNumbers()
            presenter.showSum()
            presenter.setPictures()

        }
    }

    override fun showToast(sum: Int) {
        Toast.makeText(requireContext(), sum.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun setPictures(pictures: Array<String>) {
        Glide.with(this).load(pictures[0]).into(binding.ivRoll1)
        Glide.with(this).load(pictures[1]).into(binding.ivRoll2)
    }
}