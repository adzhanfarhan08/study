package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText);
        sayHelloButton = findViewById(R.id.sayHelloButton);
        sayHelloTextView = findViewById(R.id.sayHelloTextView);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.hello_world)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.helloWorld)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val nameEditText: EditText = findViewById(R.id.nameEditText);
//        val sayHelloButton: Button = findViewById(R.id.sayHelloButton);
//        val sayHelloTextView: TextView = findViewById(R.id.sayHelloTextView);

        initComponents();

//        sayHelloTextView.text = "Hi"
        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener {

            Log.d("HAN", "This is debug log")
            Log.i("HAN", "This is info log")
            Log.w("HAN", "This is warning log")
            Log.e("HAN", "This is error log")

            Log.i("ValueResources", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResources", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResources", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("ValueResources", resources.getColor(R.color.background, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            val name = nameEditText.text.toString();
//            sayHelloTextView.text = "Hi $name!!"
//            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)
            sayHelloTextView.text = "Hello {name}"

            resources.getStringArray(R.array.names).forEach {
                Log.i("HAN", it)
            }
        }
    }
}