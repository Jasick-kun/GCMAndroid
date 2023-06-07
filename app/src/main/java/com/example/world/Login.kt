package com.example.world

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging

//DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-bf64e-default-rtdb.firebaseio.com/");

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FirebaseMessaging.getInstance().subscribeToTopic("Hello")
            .addOnCompleteListener { task ->
                var msg = "Done"
                if (!task.isSuccessful) {
                    msg = "Failed"
                }
            }

        val phone = findViewById<EditText>(R.id.phone)
        val password = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val registerNowBtn = findViewById<TextView>(R.id.registerNowBtn)

        loginBtn.setOnClickListener {
            val phoneTxt = phone.text.toString()
            val passwordTxt = password.text.toString()
            if (phoneTxt.isEmpty() || passwordTxt.isEmpty()) {
                Toast.makeText(
                    this@Login,
                    "Please enter your mobile or password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
            }
        }


//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String phoneTxt = phone.getText().toString();
//                final String passwordTxt = password.getText().toString();
//
//                if(phoneTxt.isEmpty() || passwordTxt.isEmpty()){
//                    Toast.makeText(Login.this,"Please enter your mobile or password",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//
//                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            //check if mobile/phone is exist in firebase database
//                            if(snapshot.hasChild(phoneTxt)){
//                                //mobile is exist in database
//                                //now get password of user from firebase database and match it with user entered password
//                                final String getPassword = snapshot.child(phoneTxt).child("password").getValue(String.class);
//                                if(getPassword.equals(passwordTxt)){
//                                    Toast.makeText(Login.this,"Successfully loged in ",Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(Login.this,MainActivity.class));
//                                    finish();
//                                }
//                                else{
//                                    Toast.makeText(Login.this,"Wrong Password",Toast.LENGTH_SHORT).show();
//                                }
//
//                            }
//                            else {
//                                Toast.makeText(Login.this,"Wrong Mobile number",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                }
//            }
//        });


//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String phoneTxt = phone.getText().toString();
//                final String passwordTxt = password.getText().toString();
//
//                if(phoneTxt.isEmpty() || passwordTxt.isEmpty()){
//                    Toast.makeText(Login.this,"Please enter your mobile or password",Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//
//                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            //check if mobile/phone is exist in firebase database
//                            if(snapshot.hasChild(phoneTxt)){
//                                //mobile is exist in database
//                                //now get password of user from firebase database and match it with user entered password
//                                final String getPassword = snapshot.child(phoneTxt).child("password").getValue(String.class);
//                                if(getPassword.equals(passwordTxt)){
//                                    Toast.makeText(Login.this,"Successfully loged in ",Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(Login.this,MainActivity.class));
//                                    finish();
//                                }
//                                else{
//                                    Toast.makeText(Login.this,"Wrong Password",Toast.LENGTH_SHORT).show();
//                                }
//
//                            }
//                            else {
//                                Toast.makeText(Login.this,"Wrong Mobile number",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                }
//            }
//        });
        registerNowBtn.setOnClickListener { // Open register act
            startActivity(Intent(this@Login, Register::class.java))
        }
    }
}