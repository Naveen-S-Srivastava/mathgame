package com.worldodev.mathgame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale
import kotlin.random.Random

class Multiplication : AppCompatActivity() {
    lateinit var textscore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView
    lateinit var textQuestion : TextView
    lateinit var textanswer : TextView
    lateinit var buttonok : Button
    lateinit var buttonnext : Button
    var correctAnswer = 0
    var userScore = 0
    var userlife = 3
    lateinit var timer : CountDownTimer
    private val startTimerinMilis : Long = 60000
    var timeleftinMilis : Long =startTimerinMilis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textscore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime  = findViewById(R.id.textViewtime)
        textQuestion = findViewById(R.id.textViewQuestion)
        textanswer = findViewById(R.id.editTextAnswer)
        buttonok = findViewById(R.id.buttonok)
        buttonnext = findViewById(R.id.buttonnext)
        gameContinue()

        buttonok.setOnClickListener {
            val input = textanswer.text.toString()
            if(input == ""){
                Toast.makeText(applicationContext,"Please Write your Answer" ,Toast.LENGTH_LONG).show()
            }
            else{
                pausetimer()

                val useranswer = input.toInt()
                if (useranswer==correctAnswer){
                    userScore = userScore + 10
                    textQuestion.text = "Congratulations,your answer is correct"
                    textscore.text = userScore.toString()

                }
                else{
                    userlife--
                    textQuestion.text = "Try Again"
                    textLife.text = userlife.toString()
                    if(userlife == 0){
                        Toast.makeText(applicationContext,"Game Over",Toast.LENGTH_LONG).show()
                        val intent = Intent(this@Multiplication,ResultActivity::class.java)
                        intent.putExtra("Score",userScore)
                        startActivity(intent)
                        finish()

                    }

                }

            }

        }

        buttonnext.setOnClickListener {
            pausetimer()
            resertimer()

            gameContinue()
            textanswer.setText("")
            if(userlife == 0){
                Toast.makeText(applicationContext,"Game Over",Toast.LENGTH_LONG).show()
                val intent = Intent(this@Multiplication,ResultActivity::class.java)
                intent.putExtra("Score",userScore)
                startActivity(intent)
                finish()

            }
            else{
                gameContinue()
            }


        }
    }
    fun gameContinue(){
        val number1 = Random.nextInt(0,100)
        val number2 = Random.nextInt(0,100)
        if(number1<number2){
            gameContinue()
        }
        else{
            textQuestion.text = "$number1 X $number2 ="
            correctAnswer = number1 * number2}
        startTimer()

    }
    fun startTimer(){
        timer=object :CountDownTimer(timeleftinMilis,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeleftinMilis = millisUntilFinished
                updateText()


            }

            override fun onFinish() {
                pausetimer()
                resertimer()
                updateText()
                userlife--
                textLife.text = userlife.toString()
                textQuestion.text = "Sorry time got Over"

            }

        }.start()


    }
    fun updateText(){
        val remainingTime :Int =(timeleftinMilis/1000).toInt()
        textTime.text  =String.format(Locale.getDefault(),"%02d",remainingTime)

    }
    fun pausetimer(){
        timer.cancel()
    }
    fun resertimer(){
        timeleftinMilis = startTimerinMilis
        updateText()
    }
}