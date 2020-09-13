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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    private Button login;
    private Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        mAuth = FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.email);
        password =(EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.button);
        signup =(Button) findViewById(R.id.signup);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this,value, Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String em = email.getText().toString();
            String pw = password.getText().toString();
            if (em != null){

                mAuth.signInWithEmailAndPassword(em,pw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Signed in Successful", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    });

    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    });
    }
}
