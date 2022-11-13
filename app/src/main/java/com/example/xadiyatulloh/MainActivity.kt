package com.example.xadiyatulloh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.xadiyatulloh.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var cs: ActivityMainBinding
    private val pref by lazy { SharedPrefManager(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cs = ActivityMainBinding.inflate(layoutInflater)
        setContentView(cs.root)

        initViews()
    }

    private fun initViews() {
        saveColor()
        changeColor()
    }

    private fun saveColor() {
        cs.btnEditColor.setOnClickListener {
            val layoutInflater = LayoutInflater.from(this)
            val dialogView = layoutInflater.inflate(R.layout.custom, null)
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setView(dialogView)
            var color = ""
            dialogView.findViewById<View>(R.id.red).setOnClickListener { color = "red" }
            dialogView.findViewById<View>(R.id.Yellow).setOnClickListener { color = "yellow" }
            dialogView.findViewById<View>(R.id.Green).setOnClickListener { color = "green" }
            dialogView.findViewById<View>(R.id.orange)
                .setOnClickListener { color = "orange" }
            dialogView.findViewById<View>(R.id.Blue).setOnClickListener { color = "blue" }
            dialogView.findViewById<View>(R.id.pink)
                .setOnClickListener { color = "blue" }
            dialogView.findViewById<View>(R.id.white)
                .setOnClickListener { color = "white" }
            dialogView.findViewById<View>(R.id.salad).setOnClickListener { color = "salad" }
            dialogView.findViewById<View>(R.id.Brown).setOnClickListener { color = "brown" }
            dialogView.findViewById<View>(R.id.dark)
                .setOnClickListener { color = "brown" }
            dialogView.findViewById<View>(R.id.BrownB).setOnClickListener { color = "purple" }
            dialogView.findViewById<View>(R.id.purple_700)
                .setOnClickListener { color = "purple700" }
            alertDialog.show()
            dialogView.findViewById<MaterialButton>(R.id.btnSetColor).setOnClickListener {
                pref.saveValue("color", color)
                changeColor()
                alertDialog.dismiss()
            }
        }
    }
    private fun changeColor(){
        when(pref.getValue("color")){
            "red" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            "yellow" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
            "green" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            "orange" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))
            "blue" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            "pink" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
            "white" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            "salad" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.salad))
            "brown" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.brown))
            "dark" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.dark))
            "brownB" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.brownB))
            "purple" -> cs.constraint.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_700))
        }
    }
}
