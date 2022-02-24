package com.example.memes_life

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadImageFromApi();
    }

    fun loadImageFromApi() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            {
                val url = it.getString("url")
                val image: ImageView = findViewById(R.id.my_image_view)

                Glide.with(this).load(url).into(image)
            },
            {


            }

        )
        queue.add(jsonObjectRequest)


    }





        fun nextMeme(view: View) {

            loadImageFromApi()
        }

    fun shareMeme(view: View) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"check kro")
        val chooser = Intent.createChooser(intent, "share kro")
         startActivity(chooser)

    }


}
