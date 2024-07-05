package com.saeed.flashlightapp

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

        private lateinit var cameraM : CameraManager
        private lateinit var powerBtn: ImageButton
        var isFlash = false

        @RequiresApi(Build.VERSION_CODES.M)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            powerBtn = findViewById(R.id.power)
            cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            powerBtn.setOnClickListener { flashLightOnRoOff(it) }
        }
        @RequiresApi(Build.VERSION_CODES.M)
        private fun flashLightOnRoOff(v: View?) {
            if (!isFlash){
                val cameraListId = cameraM.cameraIdList[0]
                cameraM.setTorchMode(cameraListId,true)
                isFlash = true
                powerBtn.setImageResource(R.drawable.poweonicon)
                textMassge("Flash Light is On",this)
            }
            else{
                val cameraListId = cameraM.cameraIdList[0]
                cameraM.setTorchMode(cameraListId,false)
                isFlash = false
                powerBtn.setImageResource(R.drawable.powerofficon)
                textMassge("Flash Light is Off",this)
            }

        }

        private fun textMassge(s: String, c:Context) {
            Toast.makeText(c,s,Toast.LENGTH_SHORT).show()

        }



    }
