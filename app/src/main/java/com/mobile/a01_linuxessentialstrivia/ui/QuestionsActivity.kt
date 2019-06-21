package com.mobile.a01_linuxessentialstrivia.ui

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
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

        bindViewsWithData() // Initial binding views with data from the QuestionBank Database
        activity_questions__next_button.setOnClickListener{
            onAnswerSubmit()
        }

    }


    private fun onAnswerSubmit(){
        val selectedAnswerViewId: Int = activity_questions__answers_radio_button_group.checkedRadioButtonId

        when {
            selectedAnswerViewId != -1 && currentQuestionIndex < QuestionsBank.getInstance().size -> {

                if(isAnswerCorrect(selectedAnswerViewId)){
                    currentQuestionIndex++

                    // Make sure we don't load a Question index that is outside the scope
                    if(currentQuestionIndex == QuestionsBank.getInstance().size){
                        startActivity<FinishActivity>()
                        finish()
                    }
                    else{
                        clearQuestionsSelection()
                        bindViewsWithData()
                    }
                }

            }

            else -> toast(R.string.activity_questions__err_no_answer_selected)
        }
    }
    private fun isAnswerCorrect(selectedAnswerViewId: Int): Boolean{
        val selectedAnswer: RadioButton = findViewById(selectedAnswerViewId)
        val selectedAnswerIndex: Int = activity_questions__answers_radio_button_group.indexOfChild(selectedAnswer)

        // selectedAnswerIndex is the answer RadioButton index. we can compare it to the correct answer index from the Database
        when {
            selectedAnswerIndex == QuestionsBank.getInstanceAt(currentQuestionIndex).correctAnswerIndex -> {
                Log.e("currentQuestionIndex==>", currentQuestionIndex.toString())
                Log.e("correctAnswerIndex==>", QuestionsBank.getInstanceAt(currentQuestionIndex).correctAnswerIndex.toString())
                toast("Correct!")

                return true
            }
            selectedAnswerIndex != QuestionsBank.getInstanceAt(currentQuestionIndex).correctAnswerIndex -> {
                Log.e("currentQuestionIndex==>", currentQuestionIndex.toString())
                Log.e("correctAnswerIndex==>", QuestionsBank.getInstanceAt(currentQuestionIndex).correctAnswerIndex.toString())
                toast("Wrong!")
                return false
            }
            else -> {
                toast("Something got fucked up..")
                return false
            }
        }


    }
    private fun clearQuestionsSelection(){
        activity_questions__answer_radio_button_1.isChecked = false
        activity_questions__answer_radio_button_2.isChecked = false
        activity_questions__answer_radio_button_3.isChecked = false
        activity_questions__answer_radio_button_4.isChecked = false
    }

    private fun bindViewsWithData(){
        val currentQuestion = QuestionsBank.getInstanceAt(currentQuestionIndex)
        activity_questions__question_title.text = currentQuestion.title
        activity_questions__answer_radio_button_1.text = currentQuestion.answers[0]
        activity_questions__answer_radio_button_2.text = currentQuestion.answers[1]
        activity_questions__answer_radio_button_3.text = currentQuestion.answers[2]
        activity_questions__answer_radio_button_4.text = currentQuestion.answers[3]

        @SuppressLint("SetTextI18n")
        activity_questions__progress_bar.text = "${currentQuestionIndex+1}/${QuestionsBank.getInstance().size}"

    }

}
