package amc.g11.climbharder

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import amc.g11.climbharder.R
import android.widget.EditText
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ScheduleListAdapter : ListAdapter<Schedule, ScheduleListAdapter.ScheduleViewHolder>(ScheduleComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.day, current.time)
    }

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val scheduleItemViewDay: TextView = itemView.findViewById(R.id.schedule_day)
        private val scheduleItemViewTime: TextView = itemView.findViewById(R.id.schedule_time)

        fun bind(day: String?, time: String?) {
            scheduleItemViewDay.text = day
            scheduleItemViewTime.text = time
        }

        companion object {
            fun create(parent: ViewGroup) : ScheduleViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_schedule_item, parent, false)
                return ScheduleViewHolder(view)
            }
        }
    }

    class ScheduleComparator : DiffUtil.ItemCallback<Schedule>() {
        override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem.id == newItem.id
        }
    }
}