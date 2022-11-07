package amc.g11.climbharder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.climbharder.R
import com.example.climbharder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(fragmentHome())

        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId){
                R.id.icon_log -> {
                    setCurrentFragment(fragmentLog())
                    true
                }
                R.id.icon_new -> {
                    setCurrentFragment(fragmentAddWorkout())
                    true
                }
                else -> {
                    setCurrentFragment(fragmentSchedule())
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