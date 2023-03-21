package com.ewbugs.audaciousself_promoapp

//import android.widget.Toast

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ewbugs.audaciousself_promoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //setContentView(R.layout.activity_main) <-Before Binding was introduced
        binding.buttonPreview.setOnClickListener {
            onPreviewClicked()
        }
        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")//{", "}
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spinnerJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewClicked(){


        val message = Message(
            binding.editTextContactName.text.toString(),
            binding.editTextContactNumber.text.toString(),
            binding.editTextMyDisplayName.text.toString(),
            binding.checkBoxJunior.isChecked,
            binding.spinnerJobTitle.selectedItem?.toString(),
            binding.checkBoxImmediateStart.isChecked,
            binding.editTextStartDate.text.toString()
        )

        //this-from, PreviewActivity-to
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)//in kt you don't need the word 'new'
        previewActivityIntent.putExtra("Message", message)//'putExtra' method cannot handle this type of object. You need to use ': Serializable'

        startActivity(previewActivityIntent)


//        *** TEST ***

//        val contactName = binding.editTextContactName.text.toString()
//        val contactNumber = binding.editTextContactNumber.text.toString()
//        val myDisplayName = binding.editTextMyDisplayName.text.toString()
//        val includeJunior = binding.checkBoxJunior.isChecked
//        val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()
//        val immediateStart = binding.checkBoxImmediateStart.isChecked
//        val startDate = binding.editTextStartDate.text.toString()

//        previewActivityIntent.putExtra("Contact Name", contactName)
//        previewActivityIntent.putExtra("Contact Number", contactNumber)
//        previewActivityIntent.putExtra("My Display Name", myDisplayName)
//        previewActivityIntent.putExtra("Include Junior", includeJunior)
//        previewActivityIntent.putExtra("Job Title", jobTitle)
//        previewActivityIntent.putExtra("Immediate Start", immediateStart)
//        previewActivityIntent.putExtra("Start Date", startDate)

//        val testString = "$contactName, $contactNumber, $myDisplayName, $includeJunior, $jobTitle, $immediateStart, $startDate"
//        Toast.makeText(this@MainActivity, testString, Toast.LENGTH_LONG).show()
    }
}



