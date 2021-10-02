package com.example.nasaspaceapp2021.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.text.TextUtils
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.gamepedia.ui.api.ServiceBuilder
import com.example.nasaspaceapp2021.R
import com.example.nasaspaceapp2021.Repository.QuestionRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import android.view.animation.TranslateAnimation




class GameActivity : AppCompatActivity() {
    private lateinit var live1 : ImageView
    private lateinit var live2 : ImageView
    private lateinit var live3 : ImageView
    private lateinit var live4 : ImageView
    private lateinit var question : TextView
    private lateinit var option1 : Button
    private lateinit var option2 : Button
    private lateinit var option3 : Button
    private lateinit var option4 : Button
    private lateinit var tvCorrectAnswer : TextView
    private lateinit var questionBackground : ImageView
    private var imageUrl: String? = null
    var img = ""
    var i = 0

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        live1 = findViewById(R.id.life1)
        live2 = findViewById(R.id.life2)
        live3 = findViewById(R.id.life3)
        question = findViewById(R.id.tvQuestion)
        option1 = findViewById(R.id.btnOption1)
        option2 = findViewById(R.id.btnOption2)
        option3 = findViewById(R.id.btnOption3)
        option4 = findViewById(R.id.btnOption4)
        tvCorrectAnswer = findViewById(R.id.tvCorrectAnswer)
        questionBackground = findViewById(R.id.questionBackground)
        dataRetrieve(0)




        option1.setOnClickListener {
            if(option1.text.toString() == tvCorrectAnswer.text.toString()) {
                option1.setBackgroundColor(R.color.green)
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout),"Correct Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                snackbar.show()
                dataRetrieve(1)
            }
            else{
                var session = false
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout), "Incorrect Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                snackbar.show()

                val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibratorService.vibrate(500)
                checkAnswer()

                checkLives()
            }
        }
        option2.setOnClickListener {
            if(option2.text.toString() == tvCorrectAnswer.text.toString()) {
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout),"Correct Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                snackbar.show()
                dataRetrieve(1)
            }
            else{
                var session = false
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout), "Incorrect Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                snackbar.show()

                val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibratorService.vibrate(500)
                checkAnswer()

                checkLives()
            }
        }
        option3.setOnClickListener {
            if(option3.text.toString() == tvCorrectAnswer.text.toString()) {
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout),"Correct Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                snackbar.show()
                dataRetrieve(1)
            }
            else{
                var session = false
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout), "Incorrect Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                snackbar.show()

                val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibratorService.vibrate(500)
                checkAnswer()

                checkLives()
            }
        }
        option4.setOnClickListener {
            if(option4.text.toString() == tvCorrectAnswer.text.toString()) {
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout),"Correct Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                snackbar.show()
                dataRetrieve(1)
            }
            else{
                var session = false
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout), "Incorrect Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                snackbar.show()

                val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibratorService.vibrate(500)

                checkAnswer()
                checkLives()
            }
        }
    }

    private fun checkAnswer(){
        var trans = TranslateAnimation(0F, 250F, 0F, 100F)
        trans.setDuration(500)
        var session = false
        if(live1.visibility.equals(View.VISIBLE) && session == false){
            live1.startAnimation(trans)
            live1.visibility = View.GONE
            session = true
        }
        if(live2.visibility.equals(View.VISIBLE) && session == false){
            live2.startAnimation(trans)
            live2.visibility = View.GONE
            session = true
        }
        if(live3.visibility.equals(View.VISIBLE) && session == false){
            live3.startAnimation(trans)
            live3.visibility = View.GONE
            session = true
        }
    }

    private fun dataRetrieve(j : Int){
        i = i+ j
        CoroutineScope(Dispatchers.IO).launch {
            val repository = QuestionRepository()
            val response = repository.loadQuestion()
            if (response.success == true) {
                println("###########")
                println(response.toString())

                var listItems = response.data!!
                img = listItems[i].image.toString()

                runOnUiThread( {
                    option1.setText(listItems[i].option1)
                    option2.setText(listItems[i].option2)
                    option3.setText(listItems[i].option3)
                    option4.setText(listItems[i].option4)
                    question.setText(listItems[i].question)
                    tvCorrectAnswer.setText(listItems[i].correctAnswer)
                }
                )


                var image = ServiceBuilder.loadImage() + img
                image = image.replace("\\", "/")

                println(image)
                runOnUiThread {
                    if (!image.equals("")) {
                        Glide.with(this@GameActivity)
                            .load(image)
                            .fitCenter()
                            .into(questionBackground)
                    }
                }
            }
        }
    }

    private fun checkLives() : Int{

        var liveRemaining : Int = 0
        if(live1.visibility.equals(View.VISIBLE))
        {
            liveRemaining = liveRemaining + 1
        }
        if(live2.visibility.equals(View.VISIBLE))
        {
            liveRemaining = liveRemaining + 1
        }
        if(live3.visibility.equals(View.VISIBLE))
        {
            liveRemaining  = liveRemaining + 1
        }
        println("###")
        println(liveRemaining.toString())
        if(liveRemaining == 0){
            val snackbar = Snackbar
                .make(findViewById(R.id.questionLayout), "Game Over", Snackbar.LENGTH_LONG)
            var snackbarView : View = snackbar.view
            snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            snackbar.show()
        }
        return liveRemaining
    }
}