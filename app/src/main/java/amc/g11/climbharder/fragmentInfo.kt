package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import amc.g11.climbharder.R
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentInfo : Fragment() {

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
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val backButton = view.findViewById<Button>(R.id.fragment_info_back_button)
        backButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameLayout, fragmentLogSend())
                commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            fragmentHome().apply {
                arguments = Bundle().apply {
                }
            }
    }
}