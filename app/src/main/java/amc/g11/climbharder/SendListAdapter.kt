package amc.g11.climbharder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.graphics.BitmapFactory
import android.widget.ImageView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SendListAdapter : ListAdapter<Send, SendListAdapter.SendViewHolder>(SendsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SendViewHolder {
        return SendViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SendViewHolder, position: Int) {
        val current = getItem(position)
        val isExpanded = position == mExpandedPosition
        holder.bind(current.grade, current.image)
        holder.itemView.findViewById<ImageView>(R.id.send_img).visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.itemView.isActivated = isExpanded
        holder.itemView.setOnClickListener(View.OnClickListener {
            mExpandedPosition = if (isExpanded) -1 else position
            notifyItemChanged(position)
        })
    }

    class SendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sendItemViewDate: TextView = itemView.findViewById(R.id.send_date)
        private val sendItemViewGrade: TextView = itemView.findViewById(R.id.send_grade)
        private val sendItemViewImage: ImageView = itemView.findViewById(R.id.send_img)

        fun bind(grade: String?, fileName: String?) {
            sendItemViewDate.text = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
            sendItemViewGrade.text = grade
            println("Filename in bind: $fileName")
            val retrievedImg = BitmapFactory.decodeFile(fileName)
            sendItemViewImage.setImageBitmap(retrievedImg)
        }

        companion object {
            fun create(parent: ViewGroup) : SendViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_send_item, parent, false)
                return SendViewHolder(view)
            }
        }
    }


    class SendsComparator : DiffUtil.ItemCallback<Send>() {
        override fun areItemsTheSame(oldItem: Send, newItem: Send): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Send, newItem: Send): Boolean {
            return oldItem.id == newItem.id
        }
    }
}