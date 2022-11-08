package amc.g11.climbharder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import amc.g11.climbharder.R
import amc.g11.climbharder.databinding.ActivityMainBinding
import androidx.activity.viewModels
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

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }

}