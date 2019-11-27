package com.example.daysawayproject

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_puzzle_testing.*
import kotlin.math.cos
import kotlin.math.sin

class PuzzleTestingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzle_testing)

        renderPeople(5)
    }

    fun renderPeople(count: Int) {

        val angleUnit: Float = 6.28319f / count
        val radius: Float = 300f

        for (x in 1..count) {

            val angle = angleUnit * x
            val x = radius/2 * cos(angle)
            val y = radius/2 * sin(angle)
            val xOffset = radius + x
            val yOffset = radius + y

            println(angle)
            println(x)
            println(y)

            val person1 = ImageView(this)
            person1.setImageResource(R.drawable.bulbasaur)

            var id = 100 + x.toInt()
            person1.setId(id)

            myLayout.addView(person1)

            person1.layoutParams.height = 100
            person1.layoutParams.width = 100

            val constraintSet = ConstraintSet()
            constraintSet.clone(myLayout)
            constraintSet.connect(person1.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, xOffset.toInt())
            constraintSet.connect(person1.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, yOffset.toInt())
            constraintSet.applyTo(myLayout)
            person1.bringToFront()

        }

    }
}
