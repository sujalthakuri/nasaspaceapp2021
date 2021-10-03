package com.example.nasaspaceapp2021.ui

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.graphics.Color.red
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Vibrator
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.webkit.MimeTypeMap
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
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.nasaspaceapp2021.MainActivity


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
    private lateinit var tvHint : TextView
    private lateinit var tvInformation : TextView
    private lateinit var imgYoutube : ImageView
    private lateinit var imgNasa : ImageView
    private lateinit var imgAstronaut : ImageView
    private lateinit var videoBackground : VideoView
    private var imageUrl: String? = null
    var img = ""
    var i = 0
    var youtubeLink : String? = ""
    var nasaLink : String? = ""
    var information : String? = ""

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
        tvHint = findViewById(R.id.tvHint)
        imgAstronaut = findViewById(R.id.imgAstronaut)

//        videoBackground = findViewById(R.id.videoBackground)
//        videoBackground.setVideoPath("android.resource://" + packageName  + "/" + R.raw.earthview);
//        videoBackground.start()

        dataRetrieve(0)




        option1.setOnClickListener {
            if(option1.text.toString() == tvCorrectAnswer.text.toString()) {
                val snackbar = Snackbar
                    .make(findViewById(R.id.questionLayout),"Correct Answer", Snackbar.LENGTH_LONG)
                var snackbarView : View = snackbar.view
                snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                snackbar.show()
                initiateAnimation()
                val handler = Handler()
                handler.postDelayed(Runnable {
                    imgAstronaut.visibility = View.GONE
                    dataRetrieve(1)

                }, 2000)
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
                val handler = Handler()
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
                initiateAnimation()
                val handler = Handler()
                handler.postDelayed(Runnable {
                    imgAstronaut.visibility = View.GONE
                    dataRetrieve(1)

                }, 2000)
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
                initiateAnimation()
                val handler = Handler()
                handler.postDelayed(Runnable {
                    imgAstronaut.visibility = View.GONE
                    dataRetrieve(1)

                }, 2000)
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
                initiateAnimation()
                val handler = Handler()
                handler.postDelayed(Runnable {
                    imgAstronaut.visibility = View.GONE
                    dataRetrieve(1)

                }, 2000)
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

        tvHint.setOnClickListener{
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_hint, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Did You Know?")

            tvInformation= mDialogView.findViewById(R.id.tvInformation)
            imgYoutube = mDialogView.findViewById(R.id.imgYoutube)
            imgNasa = mDialogView.findViewById(R.id.imgNasa)
            tvInformation.setText(information)

            imgYoutube.setOnClickListener{
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(youtubeLink)
                startActivity(i)
            }

            imgNasa.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(nasaLink)
                startActivity(i)
            }


            val mAlertDialog = mBuilder.show()
            mAlertDialog
        }
    }

    private fun initiateAnimation(): Boolean{
        val handler = Handler()
        handler.postDelayed(Runnable {
            imgAstronaut.visibility = View.GONE
        }, 2000)
        var trans = TranslateAnimation(0F, 250F, 0F, 100F)
        trans.setDuration(2000)
        imgAstronaut.visibility = View.VISIBLE
        imgAstronaut.startAnimation(trans)

        return true
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
                var listSize = response.data.size
                println("### ListItems" + i + " " + listSize)
                if(i == listSize) {
                    //Write code here to display the Victory Screen
                    var intent = Intent(this@GameActivity, MainActivity::class.java)
                    startActivity(intent)
                }else{

                    img = listItems[i].image.toString()
                    information = listItems[i].information.toString()
                    youtubeLink = listItems[i].youtubeLink.toString()
                    nasaLink = listItems[i].nasaLink.toString()

                    runOnUiThread({
                        option1.setText(listItems[i].option1)
                        option2.setText(listItems[i].option2)
                        option3.setText(listItems[i].option3)
                        option4.setText(listItems[i].option4)
                        question.setText(listItems[i].question)
                        tvCorrectAnswer.setText(listItems[i].correctAnswer)
                    }
                    )
                }


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