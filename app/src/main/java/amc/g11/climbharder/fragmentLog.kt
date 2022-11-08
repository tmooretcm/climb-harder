package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import amc.g11.climbharder.R
import androidx.fragment.app.activityViewModels

/**
 * A simple [Fragment] subclass.
 * Use the [fragmentLog.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentLog : Fragment() {

    private var viewModel: SendViewModel? = null

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
        val view = inflater.inflate(R.layout.fragment_recyclerview_send_log, container, false)
        val recyclerView: RecyclerView? = view.findViewById<View>(R.id.recyclerview_send_log) as RecyclerView
//        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(view.context)
        recyclerView?.adapter = viewModel?.adapter
        return view
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