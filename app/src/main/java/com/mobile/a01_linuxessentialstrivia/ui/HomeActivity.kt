package com.mobile.a01_linuxessentialstrivia.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mobile.a01_linuxessentialstrivia.R
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        activity_home__start_button.setOnClickListener{
            startActivity<QuestionsActivity>()

        }
    }
}
