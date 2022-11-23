package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import android.widget.*
import androidx.core.app.NotificationManagerCompat
import java.util.*

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
            val ll1 = view.findViewById<LinearLayout>(R.id.day_options_1)
            val ll2 = view.findViewById<LinearLayout>(R.id.day_options_2)
            val monday = view.findViewById<CheckBox>(R.id.checkMon)
            val tuesday = view.findViewById<CheckBox>(R.id.checkTue)
            val wednesday = view.findViewById<CheckBox>(R.id.checkWed)
            val thursday = view.findViewById<CheckBox>(R.id.checkThu)
            val friday = view.findViewById<CheckBox>(R.id.checkFri)
            val saturday = view.findViewById<CheckBox>(R.id.checkSat)
            val sunday = view.findViewById<CheckBox>(R.id.checkSun)

            var day: String = ""
            val hour = timePicker.hour
            val min = timePicker.minute
            val time = hour.toString() + ":" + min.toString();

            if (monday.isChecked) {
                day += "M "
                createNotification(2, hour, min)
            }
            if (tuesday.isChecked) {
                day += "T "
                createNotification(3, hour, min)
            }
            if (wednesday.isChecked) {
                day += "W "
                createNotification(4, hour, min)
            }
            if (thursday.isChecked) {
                day += "H "
                createNotification(5, hour, min)
            }
            if (friday.isChecked) {
                day += "F "
                createNotification(6, hour, min)
            }
            if (saturday.isChecked) {
                day += "S "
                createNotification(7, hour, min)
            }
            if (sunday.isChecked) {
                day += "U "
                createNotification(1, hour, min)
            }

            val schedule = Schedule(id_counter++, day, time)
            viewModel?.insert(schedule)

            Toast.makeText(context, "New schedule added!", Toast.LENGTH_SHORT).show()

            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameLayout, fragmentSchedule())
                commit()
            }
        }
    }

    private fun createNotification(dayNum: Int, hour: Int, min: Int) {
        val currentDate = Calendar.getInstance()
        val dueDate = Calendar.getInstance()
        dueDate.set(Calendar.DAY_OF_WEEK, dayNum)
        dueDate.set(Calendar.HOUR_OF_DAY, hour)
        dueDate.set(Calendar.MINUTE, min)
        dueDate.set(Calendar.SECOND, 0)

        if (dueDate.before(currentDate)) {
            dueDate.add(Calendar.WEEK_OF_YEAR, 1)
        }
        val timeDiff = dueDate.timeInMillis - currentDate.timeInMillis

        val notifManagerCompat = NotificationManagerCompat.from(requireContext())
        val enabled = notifManagerCompat.areNotificationsEnabled();
        Log.d("none", "notifs enabled : $enabled")

        createWorkRequest(timeDiff)
    }

    private fun createWorkRequest(delay: Long){
        val request = OneTimeWorkRequestBuilder<ScheduleReminderWorker>()
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
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