package com.project.mayday.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.SupportMapFragment
import com.project.googlemap.MainGoogleMapFragment
import com.project.mayday.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (google_map as MainGoogleMapFragment).run {
            onMapAsyncCallback = {
                it?.findFragmentById(R.id.google_map)
            }
        }
    }
}