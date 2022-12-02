
package com.hm.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addf=findViewById<Button>(R.id.bt_add)
        addf.setOnClickListener {
            val frag=oneFragment()
            supportFragmentManager.beginTransaction().add(R.id.container,frag,"One").commit()
        }
        val removef=findViewById<Button>(R.id.bt_remove)
        removef.setOnClickListener {
            val maincontainer=supportFragmentManager.findFragmentById(R.id.container)
            maincontainer?.let {
                supportFragmentManager.beginTransaction().remove(maincontainer).commit()
            }
        }
        val replacef=findViewById<Button>(R.id.bt_replace)
        replacef.setOnClickListener {
            val frag=BlankFragment()
            replacef.setOnClickListener {
                with(supportFragmentManager.beginTransaction()){
                    replace(R.id.container,frag)
                    addToBackStack(null)
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    commit()
                }
            }
        }
    }
}