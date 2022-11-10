package com.foysal.practice.quizApp

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionList = Constants.getQuestions()
        //Log.i("Questions Size", "${questionsList.size}")
        setQuestion()
        var tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        var tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        var tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        var tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        var tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        var tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        var tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        var tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tvOptionOne, selectedOptionNumber = 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tvOptionTwo, selectedOptionNumber = 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tvOptionThree, selectedOptionNumber = 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tvOptionFour, selectedOptionNumber = 4)
            }
        }
    }
    private fun setQuestion(){
        val questions = mQuestionList!!.get(mCurrentPosition-1)

        defaultOptionView()
        var progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        var tvProgress = findViewById<TextView>(R.id.tv_progress)
        var tvQuestion = findViewById<TextView>(R.id.tv_question)
        var ivImage = findViewById<ImageView>(R.id.iv_image)

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + "" + progressBar.max

        tvQuestion.text = questions.question
        ivImage.setImageResource(questions.image)
        var tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        var tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        var tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        var tvOptionFour = findViewById<TextView>(R.id.tv_option_four)

        tvOptionOne.text = questions.optionOne
        tvOptionTwo.text = questions.optionTwo
        tvOptionThree.text = questions.optionThree
        tvOptionFour.text = questions.optionFour
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNumber:Int ){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(
            Color.parseColor("#68534D")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionActivity, R.drawable.selected_option_border_bg
        )
    }
    private fun defaultOptionView(){
        var tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        var tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        var tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        var tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#8F8073"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionActivity, R.drawable.default_option_border_bg
            )
        }

    }



}