package com.example.simmobile

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.contains
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.simmobile.fragments.explainDx.PartFour
import com.example.simmobile.fragments.explainDx.PartOne
import com.example.simmobile.fragments.explainDx.PartThree
import com.example.simmobile.fragments.explainDx.PartTwo
import kotlinx.android.synthetic.main.activity_explain_dx.*
import kotlinx.android.synthetic.main.fragment_part_one.*

class ExplainDx : AppCompatActivity() {

    private val firstExplanation = PartOne()
    private val SecondExplanation = PartTwo()
    private val ThirdExplanation = PartThree()
    private val FourthExplanation = PartFour()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explain_dx)
        replaceFragment(firstExplanation, R.id.fragmentBody)
        replaceFragment(SecondExplanation, R.id.fragmentBody2)
        replaceFragment(ThirdExplanation, R.id.fragmentBody3)
        replaceFragment(FourthExplanation, R.id.fragmentBody4)

        buttonNext.setOnClickListener {
            if (fragmentBody3.visibility == View.VISIBLE){
                fragmentBody3.visibility = View.GONE
                fragmentBody4.visibility = View.VISIBLE
            }
            if (fragmentBody2.visibility == View.VISIBLE){
                fragmentBody2.visibility = View.GONE
                fragmentBody3.visibility = View.VISIBLE
            }
            if (fragmentBody.visibility == View.VISIBLE){
            fragmentBody.visibility = View.GONE
            fragmentBody2.visibility = View.VISIBLE
        }

        }

        buttonBack.setOnClickListener {
            if (fragmentBody2.visibility == View.VISIBLE){
                fragmentBody2.visibility = View.GONE
                fragmentBody.visibility = View.VISIBLE
            }
            if (fragmentBody3.visibility == View.VISIBLE){
                fragmentBody3.visibility = View.GONE
                fragmentBody2.visibility = View.VISIBLE
            }
            if (fragmentBody4.visibility == View.VISIBLE){
                fragmentBody4.visibility = View.GONE
                fragmentBody3.visibility = View.VISIBLE
            }

        }



    }

    private fun replaceFragment(fragment: Fragment,  id:Int){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(id, fragment).commit()
        }
    }

    fun close(view: View) {
        val close = Intent(this, QuatroDX::class.java)
        startActivity(close);
    }


}

