package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.snackbar.Snackbar

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
        recyclerView?.layoutManager = LinearLayoutManager(view.context)
        recyclerView?.adapter = viewModel?.adapter

        // Tried to make the blank text not show up
//        if (recyclerView?.childCount!! > 0) {
//            view.findViewById<TextView>(R.id.send_log_blank).text = ""
//        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                val send = viewModel?.adapter?.currentList?.get(pos)

                if (send != null) {
                    viewModel?.delete(send)
                    Snackbar.make(view, "Send deleted", Snackbar.LENGTH_LONG).apply {
                        setAction("UNDO") {
                            viewModel?.insert(send)
                        }
                        show()
                    }
                }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(recyclerView)
        }

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