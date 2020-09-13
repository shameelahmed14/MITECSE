package com.example.mitecse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private EditText Email;
    private EditText Password;
    private EditText Phone;
    private EditText date;
    private Button signup2;
    private String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Email = (EditText) findViewById(R.id.Email);
        Password =(EditText) findViewById(R.id.Password);
        Phone = (EditText) findViewById(R.id.Phone);
        date = (EditText) findViewById(R.id.Date);

        signup2 = (Button) findViewById(R.id.button2);

        signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String em1 = Email.getText().toString();
                final String pw1 = Password.getText().toString();
                final String phone = Phone.getText().toString();
                final String dt = date.getText().toString();

                if (em1 != null) {
                    mAuth.createUserWithEmailAndPassword(em1, pw1).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Main2Activity.this, "Registered Successfully! ", Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(Main2Activity.this, "Unsuccessfull", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
            }
        });
//                                User user = new User(
//                                        em1,
//                                        pw1,
//                                        phone,
//                                        dt
//                                );
//                            uid =mAuth.getCurrentUser().getUid().toString();
//                            FirebaseDatabase.getInstance().getReference("Users")
//                                    .child(uid)
//                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//
//                                    if (task.isSuccessful()) {
//                                        //code for email verification
//                                        mAuth.getCurrentUser().sendEmailVerification()
//                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                    @Override
//                                                    public void onComplete(@NonNull Task<Void> task) {
//                                                        if (task.isSuccessful()) {
//                                                            Intent intent = new Intent();
//                                                            Toast.makeText(Main2Activity.this, "Registered Successfully! Please check your email for verification.", Toast.LENGTH_LONG).show();
//                                                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//
////                                                                    //code for passing value
////                                                                    Intent intent = new Intent(getApplicationContext(),BloodTestActivity.class);
////                                                                    intent.putExtra("phone_number", phone);
////                                                                    startActivity(intent);
//
//                                                        } else {
//                                                            Toast.makeText(Main2Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                                                        }
//                                                    }
//                                                });
//                                    } else {
//                                        Toast.makeText(Main2Activity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//
//                                    }
//                                }
//                            });
//                            Toast.makeText(Main2Activity.this, "Failed", Toast.LENGTH_SHORT).show();
//                        }
//                            else
//                                Toast.makeText(Main2Activity.this, "Signed in Successful", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//            }
//        });

//
//
//        signup2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String em1 = Email.getText().toString();
//                String pw1 = Password.getText().toString();
//                String phone = Phone.getText().toString();
//                String dt = date.getText().toString();
//                if (em1 != null) {
//                    mAuth.createUserWithEmailAndPassword(em1,pw1).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(!task.isSuccessful())
//                                Toast.makeText(Main2Activity.this, "Failed", Toast.LENGTH_SHORT).show();
//                            else
//                                Toast.makeText(Main2Activity.this, "Signed in Successful", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//
//            });



    }
}
