package com.ewbugs.audaciousself_promoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private var contactNameEditText: TextInputEditText? = null
//    private var contactNumberEditText: TextInputEditText? = null
//    private var myDisplayNameEditText: TextInputEditText? = null
//    private var startDateEditText: TextInputEditText? = null
//    private var juniorCheckBox: CheckBox? = null
//    private var immediateStartCheckBox: CheckBox? = null
//    private var jobTitleSpinner: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        contactNameEditText = findViewById(R.id.edit_text_contact_name)
//        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
//        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
//        startDateEditText = findViewById(R.id.edit_text_start_date)
//        juniorCheckBox = findViewById(R.id.check_box_junior)
//        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
//        jobTitleSpinner = findViewById(R.id.spinner_job_title)
//        previewButton: Button = findViewById(R.id.button_preview)
        button_preview.setOnClickListener {
            onPreviewClicked()


        }
    }

    private fun onPreviewClicked(){
        val contactName = edit_text_contact_name.text.toString()
        val contactNumber = edit_text_contact_number.text.toString()
        val myDisplayName = edit_text_my_display_name.text.toString()
        val includeJunior = check_box_junior.isChecked
        val jobTitle = spinner_job_title.selectedItem.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_start_date.text.toString()

        //The regular concatenation is turned into a template like the line below
        //val testString = "Hardcoded values here: $contactName some more values  $contactNumber"

        val testString = "Contact Name:  $contactName, Contact Number: $contactNumber, My Display Name:, $includeJunior, Job Title: $jobTitle, Immediate Start:, $immediateStart"


        Toast.makeText(this, "", Toast.LENGTH_LONG).show()





    }
}