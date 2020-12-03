package com.example.simmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.simmobile.fragments.DxFragment
import com.example.simmobile.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_teste.*

class TesteActivity : AppCompatActivity() {

    private val dx = DxFragment();
    private val home = HomeFragment();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)
        replaceFrament(home)


        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.main -> replaceFrament(dx);
                R.id.calendar -> replaceFrament(home)

            }
            true
        }
    }

    private fun replaceFrament(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frg_container, fragment)
            transaction.commit()
        }
    }


}