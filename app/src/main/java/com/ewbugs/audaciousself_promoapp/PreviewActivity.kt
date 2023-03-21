package com.ewbugs.audaciousself_promoapp

//import androidx.annotation.RequiresApi
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ewbugs.audaciousself_promoapp.databinding.ActivityPreviewBinding


class PreviewActivity : AppCompatActivity() {

    //'lateinit' a promise that we will assign it before we call it.
    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    private lateinit var binding: ActivityPreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message

        //Called a 'raw string feature' anything that is put between the three quotes on each side will be interpreted literally
        //Instead of: "Hello\n\nThis is my next paragraph"
        messagePreviewText = """ 
                
                Hi ${message.contactName},
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best regards.
                
            """.trimIndent()

        binding.textViewMessage.text = messagePreviewText
    }

    private fun setupButton() {

        binding.buttonSendMessage.setOnClickListener {

            //SEND_TO INTENT
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
                //putExtra(Intent.EXTRA_STREAM, messagePreviewText)
            }
            startActivity(intent)
        }
    }
}


//putExtra(Intent.EXTRA_STREAM, attachment)<-Included in Android Common Intents
//val intent2 = Intent(Intent.ACTION_SENDTO)
//intent2.data
//intent2.putExtra()

//    *** DUE TO 'DEPRECATED' METHOD ***
//    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
//        helperMethodNewVersion()
//    } else helperMethodOldVersion()
//
//    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
//    private fun helperMethodNewVersion() {
//        val message = intent.getSerializableExtra("Message", Message::class.java)
//    }
//    private fun helperMethodOldVersion() {
//        val message = intent.getSerializableExtra("Message") as Message
//    }
//DEPRECATED VERSION TIRAMISU 13
//        val message = intent.getSerializableExtra("Message") as Message
//        binding.buttonPreview.setOnClickListener {
//            onPreviewClicked()

//        ***For Testing without Message.kt File***
//        val contactName = intent.getStringExtra("Contact Name")
//        val contactNumber = intent.getStringExtra("Contact Number")
//        val myDisplayName = intent.getStringExtra("My Display Name")
//        val includeJunior = intent.getBooleanExtra("Include Junior", false)
//        val jobTitle = intent.getStringExtra("Job Title")
//        val immediateStart = intent.getBooleanExtra("Immediate Start", false)
//        val startDate = intent.getStringExtra("Start Date")
//
//        val testString =
//            "Contact Name: $contactName, Contact Number: $contactNumber, My Display Name: $myDisplayName, Include Junior: $includeJunior, Start: immediateStart $immediateStart, Start Date: $startDate"
//        binding.textViewMessage.text = testString

//        binding.textViewMessage.text = "We are manually setting some text in our TextView just so we can see something!"

//    private fun onPreviewClicked() {
//        val contactName = intent.getStringExtra("Contact Name")
//        val contactNumber = intent.getStringExtra("Contact Number")
//        val myDisplayName = intent.getStringExtra("My Display Name")
//        val includeJunior = intent.getBooleanExtra("Include Junior", false)
//        //val jobTitle = intent.getStringExtra("Job Title")
//        val immediateStart = intent.getBooleanExtra("Immediate Start", false)
//        val startDate = intent.getStringExtra("Start Date")
//
//        val testString =
//            "Contact Name: $contactName, Contact Number: $contactNumber, My Display Name: $myDisplayName, Include Junior: $includeJunior, Start: immediateStart $immediateStart, Start Date: $startDate"
//        binding.textViewMessage.text = testString
//
//        //binding.textViewMessage.text = "We are manually setting some text in our TextView just so we cancan see something!"
//    }
//}




