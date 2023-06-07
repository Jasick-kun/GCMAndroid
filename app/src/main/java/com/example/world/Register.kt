package com.example.world

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val fullname = findViewById<EditText>(R.id.fullname)
        val email = findViewById<EditText>(R.id.email)
        val phone = findViewById<EditText>(R.id.phone)
        val password = findViewById<EditText>(R.id.password)
        val conPassword = findViewById<EditText>(R.id.conPassword)

        val registerBtn = findViewById<Button>(R.id.registerBtn)
        val loginNowBtn = findViewById<TextView>(R.id.loginNow)


        registerBtn.setOnClickListener {
            val fullnameTxt = fullname.text.toString()
            val emailTxt = email.text.toString()
            val phoneTxt = phone.text.toString()
            val passwordTxt = password.text.toString()
            val conPasswordTxt = conPassword.text.toString()
            if (fullnameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty()) {
                Toast.makeText(this@Register, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (passwordTxt != conPasswordTxt) {
                Toast.makeText(this@Register, "Passwords are not matching", Toast.LENGTH_SHORT)
                    .show()
            } else {
            }


            //                //check if all the fields before sending to firebase
            //                if(fullnameTxt.isEmpty()||emailTxt.isEmpty()||phoneTxt.isEmpty()||passwordTxt.isEmpty()){
            //                    Toast.makeText(Register.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
            //                }
            //                //check if passwords are matching with each other
            //                else if(!passwordTxt.equals(conPasswordTxt)){
            //                    Toast.makeText(Register.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
            //                }
            //                else {
            //
            //
            //                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            //                        @Override
            //                        public void onDataChange(@NonNull DataSnapshot snapshot) {
            //                            //check if phone is not registered before
            //                            if(snapshot.hasChild(phoneTxt)){
            //                                Toast.makeText(Register.this,"Phone is already registered",Toast.LENGTH_SHORT).show();
            //                            }
            //                            else{
            //
            //
            //                                //Sending data to firebase realtime
            //                                //we are using phone number as unique identity of every user
            //                                //so all other details of users comes under phone number
            //                                databaseReference.child("users").child(phoneTxt).child("fullname").setValue(fullnameTxt);
            //                                databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
            //                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);
            //
            //
            //                                Toast.makeText(Register.this,"User registered successfully",Toast.LENGTH_SHORT).show();
            //                                finish();
            //
            //                            }
            //                        }
            //
            //                        @Override
            //                        public void onCancelled(@NonNull DatabaseError error) {
            //
            //                        }
            //                    });
            //
            //                }
        }
        loginNowBtn.setOnClickListener { finish() }
    }
}
