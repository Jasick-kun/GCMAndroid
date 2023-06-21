package com.example.world

import android.content.ContentValues
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColor
import com.example.world.models.Message
import com.example.world.viewmodels.CoroutinesErrorHandler
import com.example.world.viewmodels.MessageViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val messageViewModel: MessageViewModel by viewModels();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val messages=arrayOf(messageViewModel.all( object: CoroutinesErrorHandler {
            override fun onError(message: String) {

            }
        }))



        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//            "Virat Kohli", "Rohit Sharma", "Steve Smith",
//            "Kane Williamson", "Ross Taylor"
//        )

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.Notification)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messages)
        mListView.adapter = arrayAdapter;

        mListView.setOnItemClickListener{parent,view,position,id->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                view.setBackgroundColor(Color.GRAY)
            }
        }


        //val tk = findViewById<TextView>(R.id.token);


        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(
                        ContentValues.TAG,
                        "Fetching FCM registration token failed",
                        task.exception
                    )
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token = task.result

                // Log and toast
                //Toast.makeText(this@MainActivity, token, Toast.LENGTH_SHORT).show()
                //tk.text = token
            })

    }
}