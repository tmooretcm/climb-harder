package amc.g11.climbharder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import amc.g11.climbharder.R
import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.core.content.ContextCompat
import java.util.jar.Manifest
import android.app.Activity.*
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import java.io.File
import java.time.Instant


/**
 * A simple [Fragment] subclass.
 * Use the [fragmentLogSend.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentLogSend : Fragment() {

    private var viewModel: SendViewModel? = null

    private lateinit var editSendGradeView: EditText
    private var sendViewModel: SendViewModel? = null
    public val CAMERA_REQUEST : Int = 999;
    public var photoNum: Int = 0
    var photoFileName = "send.jpg"
    var photoFile : File? = null
    val appDirName = "ClimbHarder"
    lateinit var retrievedImg : Bitmap
    private lateinit var cameraResultLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cameraResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
                if(result.resultCode == RESULT_OK){
                    retrievedImg = BitmapFactory.decodeFile(photoFile!!.absolutePath)
                }
                else Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()

        }

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
        val cameraButton = view.findViewById<Button>(R.id.button_log_send_image)
        cameraButton.setOnClickListener{ openCamera(view) }
        editSendGradeView = view.findViewById(R.id.edit_text_log_send)
        val logButton = view.findViewById<Button>(R.id.button_log_send_2)
        logButton.setOnClickListener {
//            val replyIntent = Intent()
            if(TextUtils.isEmpty(editSendGradeView.text)) {
                // handle error
                Toast.makeText(context, "Please enter a grade.", Toast.LENGTH_SHORT).show()
            }

            if (photoFile == null) {
                Toast.makeText(context, "Please attach an image to the send.", Toast.LENGTH_SHORT).show()
            }
            if (!TextUtils.isEmpty(editSendGradeView.text) && photoFile != null) {
                // need to edit filepath
                val send =
                    Send(id_counter++,
                        LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                        editSendGradeView.text.toString(),
                        photoFile!!.absolutePath)
                println("File path: " + photoFile!!.absolutePath)
                viewModel?.insert(send)
                Toast.makeText(context, "Added your log!", Toast.LENGTH_SHORT).show()

                activity?.supportFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.frameLayout, fragmentLog())
                    commit()
                }
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

    private fun openCamera(view: View){
        val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = getPhotoURI(photoFileName + DateTimeFormatter.ISO_INSTANT.format(Instant.now()))
        Log.d("d", photoFile!!.absolutePath)
        if(photoFile != null){
            val provider : Uri = FileProvider.getUriForFile(requireContext(), BuildConfig.APPLICATION_ID + ".provider", photoFile!!)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, provider)
            if(intent.resolveActivity(requireContext().packageManager) != null){
                startActivityForResult(intent, CAMERA_REQUEST)
            }
        }


    }

    fun getPhotoURI(fN: String): File{
        val dir = File(activity?.applicationContext?.getExternalFilesDir(Environment.DIRECTORY_PICTURES), appDirName)
        if(!dir.exists() && !dir.mkdirs()){
            Toast.makeText(context, "Failed To Make Directory for Images", Toast.LENGTH_SHORT).show()
        }
        return File(dir.path + File.separator + fN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}