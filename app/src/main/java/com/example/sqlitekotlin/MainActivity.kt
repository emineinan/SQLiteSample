package com.example.sqlitekotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sqlitekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val context=this
        var db=DBHelper(context)
        binding.buttonInsert.setOnClickListener {
            var etName=binding.editTextPersonName.text.toString()
            var etAge=binding.editTextPersonAge.text.toString()
            if(etName.isNotEmpty()&&etAge.isNotEmpty()){
                var user=User(etName,etAge.toInt())
                db.insertData(user)
            }else{
                Toast.makeText(applicationContext,"Please fill blank fields",Toast.LENGTH_LONG).show()
            }
        }
    }



}