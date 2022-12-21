package com.geektech.diceroll.main.presenter

import com.geektech.diceroll.main.model.MainModel
import com.geektech.diceroll.main.view.MainView

class MainPresenter {
    private val model = MainModel()
    private lateinit var view: MainView

    fun generateNumbers() {
        model.generateNum()
    }

    fun showSum() {
        view.showToast(model.firstNum + model.secondNum)
    }

    fun setPictures(){
        model.loadImg()
        view.setPictures(model.pictures)
    }

    fun attachView(view: MainView) {
        this.view = view
    }
}