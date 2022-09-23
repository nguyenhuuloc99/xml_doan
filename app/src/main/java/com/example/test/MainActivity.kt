package com.example.test

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var image: ImageView = findViewById(R.id.image)
        Picasso.get()
            .load("https://firebasestorage.googleapis.com/v0/b/test-e1d04.appspot.com/o/hot_v_pop.jpg?alt=media&token=db092e33-4c31-48c6-a38c-9ea1349e6ed1")
            .into(image)
        image.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this, R.style.AlerDialog)
        val view =
            LayoutInflater.from(this).inflate(R.layout.dialog, findViewById(R.id.layoutDialog))
        builder.setView(view)

        val alertDialog = builder.create()
        alertDialog.setCanceledOnTouchOutside(true)
        val btnYes: Button = view.findViewById(R.id.btn_yes)
        btnYes.setOnClickListener {
            alertDialog.dismiss()
        }
        if (alertDialog.window != null) {
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        alertDialog.show()
    }

}