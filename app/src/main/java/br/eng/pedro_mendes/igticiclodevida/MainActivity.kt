package br.eng.pedro_mendes.igticiclodevida

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logLifeCycle("onCreate")

        addListeners()
    }

    override fun onStart() {
        super.onStart()
        logLifeCycle("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifeCycle("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifeCycle("onPause")
    }

    override fun onRestart() {
        super.onRestart()
        logLifeCycle("onRestart")
    }

    override fun onStop() {
        super.onStop()
        logLifeCycle("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifeCycle("onDestroy")
    }


    private fun logLifeCycle(lifeCycleName: String) {
        Log.i("IGTI_Log", "MainActivity::$lifeCycleName")
    }

    private fun addListeners() {
        findViewById<Button>(R.id.button_first).setOnClickListener {
            onPressFirstButton()
        }
    }

    private fun onPressFirstButton() {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}