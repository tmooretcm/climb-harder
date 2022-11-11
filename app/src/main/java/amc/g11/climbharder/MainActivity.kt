package amc.g11.climbharder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import amc.g11.climbharder.R
import amc.g11.climbharder.databinding.ActivityMainBinding
import android.Manifest
import android.content.ClipData
import android.content.pm.PackageManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel


var id_counter = 0

class MainActivity : AppCompatActivity() {

    private val fragmentLog: fragmentLog = fragmentLog()
    private val fragmentAddWorkout: fragmentAddWorkout = fragmentAddWorkout()
    private val fragmentSchedule: fragmentSchedule = fragmentSchedule()

    private val sendViewModel: SendViewModel by viewModels {
        SendViewModelFactory((application as ClimbHarderApplication).send_repository)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (ContextCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                    android.Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(android.Manifest.permission.CAMERA), 1)
            } else {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(android.Manifest.permission.CAMERA), 1)
            }
        }
        sendViewModel.allSends.observe(this) { sends ->
            sends.let{ sendViewModel.adapter.submitList(it) }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(fragmentHome())

        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.icon_log -> {
                    setCurrentFragment(fragmentLog)
                    true
                }
                R.id.icon_new -> {
                    setCurrentFragment(fragmentAddWorkout)
                    true
                }
                else -> {
                    setCurrentFragment(fragmentSchedule)
                    true
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if ((ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA) ==  PackageManager.PERMISSION_GRANTED)) {
                        Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()

                    }
                }
                else Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
                return
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }

}