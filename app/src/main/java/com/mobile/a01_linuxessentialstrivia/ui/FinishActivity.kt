package com.mobile.a01_linuxessentialstrivia.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mobile.a01_linuxessentialstrivia.R
import kotlinx.android.synthetic.main.activity_finish.*
import org.jetbrains.anko.startActivity

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        activity_finish__start_over.setOnClickListener{
            startActivity<HomeActivity>()
            finish()
        }
    }
}
