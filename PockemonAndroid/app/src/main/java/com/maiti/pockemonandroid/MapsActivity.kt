package com.maiti.pockemonandroid

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.maiti.pockemonandroid.databinding.ActivityMapsBinding
import java.lang.Exception

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        checkPermission()
        LoadPockemons()
    }
    var ACCESS_LOCATION = 123
    fun checkPermission() {
        if(Build.VERSION.SDK_INT >= 23) {
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), ACCESS_LOCATION)
                return;
            }
        }
        GetUserLocation()
    }
    fun GetUserLocation() {
        Toast.makeText(this, "User location access on", Toast.LENGTH_SHORT).show()
        //TODO: will implement later
        var myLocation = MylocationListener()
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f, myLocation)
        var myThread = myThread()
        myThread.start()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            ACCESS_LOCATION -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    GetUserLocation()
                } else {
                    Toast.makeText(this, "We can access to your location", Toast.LENGTH_LONG).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

    }
    var location: Location? = null
    //Get user location
    inner class MylocationListener: LocationListener {
        constructor() {
            location = Location("Start")
            location!!.longitude = 0.0
            location!!.latitude = 0.0
        }
        override fun onLocationChanged(p0: Location) {
            location = p0
        }

    }

    var oldLocation:Location? = null
    inner class myThread:Thread {
        constructor():super() {
            oldLocation = Location("Start")
            oldLocation!!.longitude = 0.0
            oldLocation!!.latitude = 0.0

        }

        override fun run() {
            super.run()
            while (true) {
                try {
                    if(oldLocation!!.distanceTo(location) == 0f) continue
                    oldLocation = location
                    runOnUiThread {
                        mMap.clear()
                        val myLoc = LatLng(location!!.latitude, location!!.longitude)
                        mMap.addMarker(MarkerOptions()
                            .position(myLoc).title("Me")
                            .snippet("Here is my location")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.mario)))
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLoc,14f))

                        // show pockemons
                        for(i in 0..listPockemons.size-1) {
                            val pockemon = listPockemons[i]
                            val pockemonLoc = LatLng(pockemon.location!!.latitude, pockemon.location!!.longitude)
                            if(!pockemon.isCatch!!) {
                                mMap.addMarker(
                                    MarkerOptions()
                                        .position(pockemonLoc).title(pockemon.name!!)
                                        .snippet(pockemon.des!! + ", power: "+ pockemon.power)
                                        .icon(BitmapDescriptorFactory.fromResource(pockemon.image!!))
                                )
                            }
                            if(location!!.distanceTo(pockemon.location)<2) {
                                pockemon.isCatch = true
                                listPockemons[i] = pockemon
                                playerPower += pockemon.power!!
                                Toast.makeText(applicationContext, "You catch new pockemon your new power is $playerPower", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    Thread.sleep(1000)
                }catch (ex: Exception) {}
            }
        }
    }
    var playerPower = 0.0
    var listPockemons = ArrayList<Pockemon>()
    fun LoadPockemons() {
        listPockemons.add(Pockemon(R.drawable.charmander, "Charmander",
            "Charmander living in japan", 55.0, 37.7789994893035,-122.401846647263))
        listPockemons.add(Pockemon(R.drawable.bulbasaur,
            "Bulbasaur", "Bulbasaur living in usa", 90.5, 37.7949568502667,-122.410494089172))
        listPockemons.add(Pockemon(R.drawable.squirtle,
            "Squirtle", "Squirtle living in iraq", 33.5, 37.7816621152613,-122.41225361824))

    }
}