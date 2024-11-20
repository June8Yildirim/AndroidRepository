package com.cuneyt.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuestionsLayout : AppCompatActivity(), View.OnClickListener {


    private lateinit var questionTxt: TextView
    private lateinit var image: ImageView
    private lateinit var opt1: TextView
    private lateinit var opt2: TextView
    private lateinit var opt3: TextView
    private lateinit var opt4: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var correctAnswer: TextView
    private lateinit var submitBtn: Button
    private var mSelectedOptionPosition: Int = 0
    private var questions: ArrayList<Question>? = null
    private var currentPosition: Int = 1
    private var correctAnswers: Int = 0
    private lateinit var question: Question
    private lateinit var intent: Intent
    private lateinit var username:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.content_questions_layout)

        val nameIntent = getIntent()
        username = nameIntent.getStringExtra("username").toString()

        questionTxt = findViewById(R.id.question)
        image = findViewById(R.id.flagImage)
        opt1 = findViewById(R.id.option1)
        opt2 = findViewById(R.id.option2)
        opt3 = findViewById(R.id.option3)
        opt4 = findViewById(R.id.option4)
        submitBtn = findViewById(R.id.submit_btn)
        progressBar = findViewById(R.id.progressBar)
        correctAnswer = findViewById(R.id.correctAnswer)

        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        submitBtn.setOnClickListener(this)

        setQuestion()

    }

    private fun setQuestion() {

        defaultViewOptionsView()
        questions = Constants.getQuestions()
        question = questions?.get(currentPosition -1)!!
        if (question.id == questions?.size) submitBtn.text = "FINISH"
        else submitBtn.text = "SUBMIT"


        image.setImageResource(question.image)
        questionTxt.text = question.question
        opt1.text = question.opt1
        opt2.text = question.opt2
        opt3.text = question.opt3
        opt4.text = question.opt4
        correctAnswer.text = correctAnswers.toString()
        progressBar.progress = currentPosition
    }

    private fun selectedOptionView(textView: TextView, selectedOpt: Int) {
        defaultViewOptionsView()

        mSelectedOptionPosition = selectedOpt
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this@QuestionsLayout,
            R.drawable.option_border_bg
        )
    }

    private fun defaultViewOptionsView() {
        val options = ArrayList<TextView>()
        opt1.let {
            options.add(0, it)
        }
        opt2.let {
            options.add(1, it)
        }
        opt3.let {
            options.add(2, it)
        }
        opt4.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_border_bg)

        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option1 -> {
                opt1.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.option2 -> {
                opt2.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.option3 -> {
                opt3.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.option4 -> {
                opt4.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.submit_btn -> {
                if (mSelectedOptionPosition == 0) {
                    currentPosition++
                    when {
                        currentPosition <= questions!!.size -> {
                            setQuestion()
                        }

                        else -> {
                            Toast.makeText(
                                this@QuestionsLayout,
                                "${username} have succeed with ${correctAnswers}",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            intent = Intent(this,activityResult::class.java)
                            intent.putExtra("correctAnswers", correctAnswers.toString())
                            intent.putExtra("username", username)
                            startActivity(intent)
                        }
                    }
                } else {
                    question = questions?.get(currentPosition - 1)!!

                    if (question.answer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_border_bg)
                    }

                    answerView(question.answer, R.drawable.correct_border_bg)
                    correctAnswers++
                    if (currentPosition == questions!!.size) submitBtn.text = "FINISH"
                    else submitBtn.text = "MOVE NEXT "

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                opt1.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                opt2.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                opt3.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                opt4.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}