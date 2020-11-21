package com.example.reto2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reto2.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.UUID;

import model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titleTV;
    private TextView usernameTV;
    private EditText usernameET;
    private Button loginBtn;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        usernameTV = findViewById(R.id.usernameTV);
        usernameET = findViewById(R.id.usernameET);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(this);

        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loginBtn:

                String username = usernameET.getText().toString();
                User user = new User(UUID.randomUUID().toString(), username);

                //Saber si el usuario ya estaba registrado
                CollectionReference usersRef = db.collection("users");
                Query query = usersRef.whereEqualTo("username", username);
                query.get().addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {

                                if (task.getResult().size() > 0) {
                                    for(QueryDocumentSnapshot document : task.getResult()){
                                        User dbUser = document.toObject(User.class);
                                        goToMyPokemonActivity(dbUser);
                                        break;
                                    }
                                } else {
                                    db.collection("users").document(user.getId()).set(user);
                                    goToMyPokemonActivity(user);
                                }
                            }
                        }
                );


                break;
        }
    }

    public void goToMyPokemonActivity(User user) {
        Intent i = new Intent(this, MyPokemonActivity.class);
        i.putExtra("myUser", user);
        startActivity(i);
    }
}