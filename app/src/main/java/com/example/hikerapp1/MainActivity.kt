package com.example.hikerapp1

import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : ComponentActivity() {
    private val hikingTrails = listOf(
        HikingTrail("Turkey Run Trail 1", "moderate/rugged", 2.2, 413.0, "1.4 hours" ),
        HikingTrail(" Turkey Run Trail 2", "rugged", 2.9, 357.0, "1.12 hours"),
        HikingTrail("Turkey Run Trail 3", "very rugged", 1.9, 354.0, "3 hours"),
        HikingTrail("Turkey Run Trail 4", "Moderate/rugged", 2.0, 500.0, "3 hours"),
        HikingTrail("Turkey Run Trail 5", "Moderate", 0.7, 500.0, "3 hours"),
        HikingTrail("Turkey Run Trail 6", "Moderate/rugged", 0.5, 500.0, "3 hours"),
        HikingTrail("Turkey Run Trail 7", "Moderate", 0.7, 500.0, "3 hours"),
        HikingTrail("Turkey Run Trail 8", "Moderate", 1.5, 500.0, "3 hours"),
        HikingTrail("Turkey Run Trail 9", "very rugged", 1.0, 500.0, "3 hours"),
        HikingTrail("Turkey Run Trail 10", "Moderate", 1.4, 500.0, "3 hours"),
        HikingTrail("Turkey Run Trail 11", "easy", 0.5, 500.0, "3 hours"),

    )
    private lateinit var locationManager: LocationManager

    companion object {
        private const val PERMISSION_REQUEST_CODE = 123
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkLocationPermission()) {
            // Initialize LocationManager
            locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

            // Set up RecyclerView
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
            val adapter = HikingTrailAdapter(hikingTrails)
            recyclerView.adapter = adapter

            //Request location updates

        }
    }

    private fun checkLocationPermission(): Boolean {
        val permission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // Request the permission.
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_CODE
            )
        }

        return true

        val recyclerView: RecyclerView? = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager

        // Initialize and set the adapter
        val adapter = HikingTrailAdapter(hikingTrails)
        recyclerView?.adapter = adapter
        }
    }

