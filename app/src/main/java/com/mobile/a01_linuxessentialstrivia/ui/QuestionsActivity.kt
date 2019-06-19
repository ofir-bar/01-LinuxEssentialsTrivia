package com.mobile.a01_linuxessentialstrivia.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.mobile.a01_linuxessentialstrivia.R
import kotlinx.android.synthetic.main.activity_questions.*
import org.jetbrains.anko.toast


class QuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        // Get a reference to RadioButton from the RadioGroup
        activity_questions__question_radio_button_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ group, checkId ->
            val radio: RadioButton = findViewById(checkId)
            toast("On ${radio.text}")
        })

        activity_questions__next_button.setOnClickListener{
            var id: Int = activity_questions__question_radio_button_group.checkedRadioButtonId

            if (id != -1){
            val selectedRadio: RadioButton = findViewById(id)
            toast("On next button click ${selectedRadio.text}")
            }
            else{
                toast(R.string.activity_questions__err_no_question_selected)
            }
        }



    }
}
