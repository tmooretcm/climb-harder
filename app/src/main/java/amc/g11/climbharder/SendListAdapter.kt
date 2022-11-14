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
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SendListAdapter : ListAdapter<Send, SendListAdapter.SendViewHolder>(SendsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SendViewHolder {
        return SendViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SendViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.grade)
    }

    class SendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sendItemViewDate: TextView = itemView.findViewById(R.id.send_date)
        private val sendItemViewGrade: TextView = itemView.findViewById(R.id.send_grade)
        private val sendItemViewImage: ImageView = itemView.findViewById(R.id.send_img)

        fun bind(grade: String?, fileName: String?) {
            sendItemViewDate.text = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            sendItemViewGrade.text = grade
            val photoURI = getPhotoURI(fileName);
            val retrievedImg = BitmapFactory.decodeFile(photoURI!!.absolutePath)
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