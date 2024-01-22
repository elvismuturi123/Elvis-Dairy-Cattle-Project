package com.example.dairyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Login extends AppCompatActivity {

//    EditText editTextEmailL, editTextPasswordL;
//
//    String User_EMAIL, User_PASSWORD, login;
//
//    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        editTextEmailL = findViewById(R.id.emailLL);
//        editTextPasswordL = findViewById(R.id.passwordLL);

        Button login = findViewById(R.id.btn_Login);



        login.setOnClickListener(v -> {

            Toolbox.showToast(Login.this, "Signed in successfully!");
            Toolbox.navigateTo(Login.this,Home.class);
//            String email, password;
//
//            email = editTextEmailL.getText().toString().trim();
//            password = editTextPasswordL.getText().toString().trim();
//
//            User_EMAIL= email;
//            User_PASSWORD =password;
//
//
//            if(!email.isEmpty() && !password.isEmpty()){
//                validator();
//            }else {
//                Toolbox.showToast(Login.this, "No empty fields allowed");
//            }

        });

//    }

//    private void validator(){
//
//        if(Patterns.EMAIL_ADDRESS.matcher(User_EMAIL).matches()){
//            if(User_PASSWORD.length()<6){
//                Toolbox.showToast(Login.this, "The password is too short.");
//            }else {
//               loginUser();
//            }
//        }else {
//            Toolbox.showToast(Login.this, "The email is invalid.");
//        }
//
//    }
//
//    private void loginUser(){
//        firebaseAuth =FirebaseAuth.getInstance();
//        firebaseAuth.signInWithEmailAndPassword(User_EMAIL,User_PASSWORD)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        // user sign in successfull
//                        if(task.isSuccessful()){
//                            Toolbox.showToast(Login.this, "Signed in successfully!");
//                            Toolbox.navigateTo(Login.this,Home.class);
//                        }else {
//                            Toolbox.showToast(Login.this, task.getException().getLocalizedMessage());
//                        }
//                    }
//                });
//
    }
}
