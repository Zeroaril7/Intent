package com.fakhril.intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityObject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        if (intent != null){
        val tvObject : TextView = findViewById(R.id.tvObject)

        val human : Person? = intent.getParcelableExtra(EXTRA_PERSON)
        val name : String? = human?.name
        val email : String? = human?.email
        val city : String? = human?.city
        val text = "Name : $name, Email : $email, City : $city"
        tvObject.setText(text)
        }
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}