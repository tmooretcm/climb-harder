package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import amc.g11.climbharder.R
import android.app.Activity
import android.content.Intent
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentLogSend.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentLogSend : Fragment() {

    private var viewModel: SendViewModel? = null

    private lateinit var editSendGradeView: EditText
    private var sendViewModel: SendViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val thisViewModel: SendViewModel by activityViewModels()
        viewModel = thisViewModel
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_send, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editSendGradeView = view.findViewById(R.id.edit_text_log_send)
        val logButton = view.findViewById<Button>(R.id.button_log_send_2)
        logButton.setOnClickListener {
//            val replyIntent = Intent()
            if(TextUtils.isEmpty(editSendGradeView.text)) {
                // handle error
            } else {
                // need to edit filepath
                val send =
                    Send(id_counter++,
                        LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        editSendGradeView.text.toString(),
                        "/")
                viewModel?.insert(send)

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            fragmentLog().apply {
                arguments = Bundle().apply {
                }
            }
    }
}