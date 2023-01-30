package com.fakhril.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityData: Button = findViewById(R.id.btn_move_activity_Data)
        btnMoveActivityData.setOnClickListener(this)

        val btnMoveActivityObject: Button = findViewById(R.id.btn_move_activity_Object)
        btnMoveActivityObject.setOnClickListener(this)

        val btnMoveActivityApp: Button = findViewById(R.id.btn_move_activity_App)
        btnMoveActivityApp.setOnClickListener(this)

        val btnMoveActivityResult: Button = findViewById(R.id.btn_move_activity_Result)
        btnMoveActivityResult.setOnClickListener(this)

        tvResult= findViewById(R.id.result_tv)

        if (intent.extras != null){
            val hasil = intent.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0)
            val text = "Hasil : $hasil"
            tvResult.setText(text)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent (this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_Data -> {
                val moveIntentData = Intent (this@MainActivity, MoveActivityData::class.java)

                moveIntentData.putExtra(MoveActivityData.EXTRA_NAME, "Fa")
                moveIntentData.putExtra(MoveActivityData.EXTRA_AGE, 5)

                startActivity(moveIntentData)
            }

            R.id.btn_move_activity_App -> {
                val phoneNumber = "082254040098"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_activity_Object -> {
                val person = Person("Fakhril", "@gmail", "Banyuwangi")
                val moveWihtObjectActivity = Intent(this@MainActivity, MoveActivityObject::class.java)
                moveWihtObjectActivity.putExtra(MoveActivityObject.EXTRA_PERSON, person)
                startActivity(moveWihtObjectActivity)
            }

            R.id.btn_move_activity_Result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResult::class.java)
                startActivity(moveForResultIntent)
            }

        }
    }
}