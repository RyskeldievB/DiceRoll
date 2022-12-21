package com.geektech.diceroll.main.model

import android.util.Log
import kotlin.random.Random


class MainModel {
    var firstNum = 0
    var secondNum = 0
    val pictures = arrayOf("", "")

    fun generateNum() {
        firstNum = Random.nextInt(6) + 1
        secondNum = Random.nextInt(6) + 1
        Log.e(
            "aga",
            "first $firstNum   second $secondNum     sum in model " + (firstNum + secondNum)
        )
    }

    fun loadImg(): Array<String> {
        val numbers = arrayOf(firstNum, secondNum)
        for (num in numbers.indices) {
            when (numbers[num]) {
                1 -> pictures[num] = ("https://img.icons8.com/windows/344/dice-one.png")
                2 -> pictures[num] = ("https://img.icons8.com/windows/344/dice-two.png")
                3 -> pictures[num] = ("https://img.icons8.com/windows/344/dice-three.png")
                4 -> pictures[num] = ("https://img.icons8.com/windows/344/dice-four.png")
                5 -> pictures[num] = ("https://img.icons8.com/windows/344/dice-five.png")
                6 -> pictures[num] = ("https://img.icons8.com/windows/344/dice-six.png")
            }
        }
        return pictures
    }
}