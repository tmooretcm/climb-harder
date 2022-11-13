package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TimePicker
import com.example.climbharder.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentSchedule.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentCreateSchedule : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val submit = view.findViewById(R.id.button_submit_new_schedule)
        val timePicker = view.findViewById<TimePicker>(R.id.timePicker)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_schedule, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val submitScheduleButton = view.findViewById<Button>(R.id.button_submit_new_schedule)
        val timePicker = view.findViewById<TimePicker>(R.id.timePicker)

        submitScheduleButton.setOnClickListener {
            val monday = view.findViewById<CheckBox>(R.id.checkMon)
            val tuesday = view.findViewById<CheckBox>(R.id.checkTue)
            val wednesday = view.findViewById<CheckBox>(R.id.checkWed)
            val thursday = view.findViewById<CheckBox>(R.id.checkThu)
            val friday = view.findViewById<CheckBox>(R.id.checkFri)
            val saturday = view.findViewById<CheckBox>(R.id.checkSat)
            val sunday = view.findViewById<CheckBox>(R.id.checkSun)

            // add data to calendar
            // store the data to be persistent
            // schedule the push notifications



            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameLayout, fragmentSchedule())
                commit()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmentSchedule.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragmentSchedule().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}