package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TimePicker
import amc.g11.climbharder.R
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit
import android.app.NotificationManager
import androidx.core.app.NotificationManagerCompat

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
    private var viewModel: ScheduleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val thisViewModel: ScheduleViewModel by activityViewModels()
        viewModel = thisViewModel
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_schedule, container, false)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val submitScheduleButton = view.findViewById<Button>(R.id.button_submit_new_schedule)

        submitScheduleButton.setOnClickListener {
            val timePicker = view.findViewById<TimePicker>(R.id.timePicker)
            val monday = view.findViewById<CheckBox>(R.id.checkMon)
            val tuesday = view.findViewById<CheckBox>(R.id.checkTue)
            val wednesday = view.findViewById<CheckBox>(R.id.checkWed)
            val thursday = view.findViewById<CheckBox>(R.id.checkThu)
            val friday = view.findViewById<CheckBox>(R.id.checkFri)
            val saturday = view.findViewById<CheckBox>(R.id.checkSat)
            val sunday = view.findViewById<CheckBox>(R.id.checkSun)

            var day: String = "default"
            if (monday.isChecked) {
                day = "Monday"
            } else if (tuesday.isChecked) {
                day = "Tuesday"
            } else if (wednesday.isChecked) {
                day = "Wednesday"
            } else if (thursday.isChecked) {
                day = "Thursday"
            } else if (friday.isChecked) {
                day = "Friday"
            } else if (saturday.isChecked) {
                day = "Saturday"
            } else if (sunday.isChecked){
                day = "Sunday"
            }
            val time = timePicker.hour.toString() + ":" + timePicker.minute.toString();

            println(day)

            val schedule = Schedule(id_counter++, day, time)

            viewModel?.insert(schedule)

            // schedule the push notifications
            var delay: Long

            val notifManagerCompat = NotificationManagerCompat.from(requireContext())
            val enabled = notifManagerCompat.areNotificationsEnabled();
            Log.d("none", "notifs enabled : $enabled")

            createWorkRequest(5)

            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameLayout, fragmentSchedule())
                commit()
            }
        }
    }

    private fun createWorkRequest(delay: Long){
        val request = OneTimeWorkRequestBuilder<ScheduleReminderWorker>()
            .setInitialDelay(delay, TimeUnit.SECONDS)
            .addTag("work event")
            .build()

        WorkManager.getInstance(requireContext()).enqueue(request)

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