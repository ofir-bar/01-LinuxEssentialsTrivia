package com.mobile.a01_linuxessentialstrivia.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.mobile.a01_linuxessentialstrivia.R
import com.mobile.a01_linuxessentialstrivia.data.QuestionsBank
import kotlinx.android.synthetic.main.activity_questions.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class QuestionsActivity : AppCompatActivity() {
    var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        populateViewsWithData()
        updateQuestionsProgress()
        attachListenerOnNextButton()

        // Get a reference to RadioButton from the RadioGroup
        activity_questions__question_radio_button_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ group, checkId ->
            val radio: RadioButton = findViewById(checkId)
            toast("On ${radio.text}")
        })


    }

    private fun populateViewsWithData(){

        when {
            currentQuestionIndex < QuestionsBank.getInstance().size -> {
                val currentQuestion = QuestionsBank.getInstanceAt(currentQuestionIndex)
                activity_questions__question_title.text = currentQuestion.title
                activity_questions__question_radio_button_1.text = currentQuestion.answers[0]
                activity_questions__question_radio_button_2.text = currentQuestion.answers[1]
                activity_questions__question_radio_button_3.text = currentQuestion.answers[2]
                activity_questions__question_radio_button_4.text = currentQuestion.answers[3]
            }
            currentQuestionIndex == QuestionsBank.getInstance().size -> startActivity<FinishActivity>()
            else -> {
                toast("Error")
                finish()
            }
        }
    }

    private fun attachListenerOnNextButton(){
        activity_questions__next_button.setOnClickListener{
            currentQuestionIndex++

            val selectedQuestionId: Int = activity_questions__question_radio_button_group.checkedRadioButtonId

            if (selectedQuestionId != -1){
                // CheckSolution()

                clearQuestionsSelection()
                populateViewsWithData()
                updateQuestionsProgress()
            }
            else{
                toast(R.string.activity_questions__err_no_question_selected)
            }
        }
    }

    private fun clearQuestionsSelection(){
        activity_questions__question_radio_button_1.isChecked = false
        activity_questions__question_radio_button_2.isChecked = false
        activity_questions__question_radio_button_3.isChecked = false
        activity_questions__question_radio_button_4.isChecked = false
    }

    @SuppressLint("SetTextI18n")
    private fun updateQuestionsProgress(){
        activity_questions__progress_bar.text = "${currentQuestionIndex+1}/${QuestionsBank.getInstance().size}"
    }

}
