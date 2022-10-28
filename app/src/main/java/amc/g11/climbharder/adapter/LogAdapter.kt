package amc.g11.climbharder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.climbharder.R
import com.example.climbharder.data.DataSource

class LogAdapter (
    private val context: Context?
) : RecyclerView.Adapter<LogAdapter.LogCardViewHolder>() {
    private val logList = DataSource.logList

    class LogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val exerciseName: TextView? = view?.findViewById(R.id.exercise_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogCardViewHolder {

        // inflate layout
        val viewLayout = LayoutInflater.from(parent.context).inflate(R.layout.log, parent, false)

        // Pass in the view layout into the view holder.
        return LogCardViewHolder(viewLayout)
    }

    override fun getItemCount(): Int {
        return logList.size
    }

    override fun onBindViewHolder(holder: LogCardViewHolder, position: Int) {
        // Get the data at the current position
        var exerciseData = logList[position]
        // Set the text for the current champ's name
        holder.exerciseName?.text = exerciseData.exerciseName
    }
}