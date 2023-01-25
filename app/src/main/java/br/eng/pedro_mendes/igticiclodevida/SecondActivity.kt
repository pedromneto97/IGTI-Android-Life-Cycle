package br.eng.pedro_mendes.igticiclodevida

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        backButton = findViewById(R.id.button_back)
        logLifeCycle("onCreate")

        checkSavedInstanceToRestoreState(savedInstanceState)

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
        Log.i("IGTI_Log", "SecondActivity::$lifeCycleName")
    }

    private fun addListeners() {
        setUpBackButton()
        setUpVisibilityButton()
    }

    private fun setUpBackButton() {
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun setUpVisibilityButton() {
        findViewById<Button>(R.id.button_visibility).setOnClickListener {
            setBackButtonVisible()
        }
    }

    private fun setBackButtonVisible() {
        backButton.visibility = View.VISIBLE
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(
            TAG_BACK_BUTTON_VISIBILITY, backButton.visibility == View.VISIBLE
        )
    }

    private fun checkSavedInstanceToRestoreState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(TAG_BACK_BUTTON_VISIBILITY)) {
                setBackButtonVisible()
            }
        }
    }

    companion object {
        private const val TAG_BACK_BUTTON_VISIBILITY = "isBackButtonVisible"
    }
}