package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import amc.g11.climbharder.R


/**
 * A simple [Fragment] subclass.
 * Use the [fragmentAddWorkout.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentAddWorkout : Fragment() {
    private lateinit var logSendButton: Button
    private lateinit var logHangButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_workout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logSendButton = view.findViewById(R.id.button_log_send)
        logHangButton = view.findViewById(R.id.button_log_hang)
        logSendButton.setOnClickListener{logSend()}
        logHangButton.setOnClickListener {logHang()}

    }

    private fun logHang() {
        val fragment = fragmentLogHang()
        parentFragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)?.commit()
    }

    private fun logSend() {
        val fragment = fragmentLogSend()
        parentFragmentManager?.beginTransaction()?.replace(R.id.frameLayout, fragment)?.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            fragmentAddWorkout().apply {
                arguments = Bundle().apply {
                }
            }
    }
}