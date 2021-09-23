package com.example.plansthandbook

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.plansthandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.plant1
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4
    )
;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()

    }

    private fun initButtons() = with(binding) {
        bNext.setOnClickListener {
            indexImage++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imagePl.setImageResource(imageId)

            Log.d("MyLog", "Index: $indexImage")
        }
        bDone.setOnClickListener {
            val plant = Plant(imageId , tvTitle.text.toString(), tvDescription.text.toString())
            val editIntent = Intent().apply{
                putExtra("plant", plant)
             }
            setResult(RESULT_OK, editIntent)
            finish()
        }

    }


}