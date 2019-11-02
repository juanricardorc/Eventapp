package com.jualig.eventapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.jualig.eventapp.R;
import com.jualig.eventapp.account.CreateAccountActivity;
import com.jualig.eventapp.home.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private TextView versionAppTextView;
    private TextView titleLogInTextView;
    private MaterialButton logInMaterialButton;
    private TextInputEditText emailTextInputEditText;
    private TextInputEditText passwordTextInputEditText;
    private TextView dontHaveAccountTextView;
    private TextView signUpTextView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        finds();
        events();
    }

    private void finds() {

        versionAppTextView = findViewById(R.id.version_app_text_view);
        //versionAppTextView.setTypeface(Utilities.sansBold(this));

        titleLogInTextView = findViewById(R.id.title_log_in_text_view);
        //titleLogInTextView.setTypeface(Utilities.sansBlack(this));

        logInMaterialButton = findViewById(R.id.log_in_material_button);
        //createAccountMaterialButton = findViewById(R.id.create_account_material_button);
        //createAccountMaterialButton.setTypeface(Utilities.sansLight(this));

        emailTextInputEditText = findViewById(R.id.email_text_input_edit_text);
        //emailTextInputEditText.setTypeface(Utilities.sansLight(this));

        passwordTextInputEditText = findViewById(R.id.password_text_input_edit_text);
        //passwordTextInputEditText.setTypeface(Utilities.sansLight(this));

        dontHaveAccountTextView = findViewById(R.id.dont_have_account);
        //dontHaveAccountTextView.setTypeface(Utilities.sansLight(this));

        signUpTextView = findViewById(R.id.sign_up_text_view);
        //signUpTextView.setTypeface(Utilities.sansBold(this));

        progressDialog = new ProgressDialog(this);
    }

    private void events() {
        logInMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogIn();
            }
        });
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validateLogIn() {
        String email = emailTextInputEditText.getText().toString();
        String password = passwordTextInputEditText.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su correo electronico", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!emailIsValid(email)) {
            Toast.makeText(this, "Por favor ingrese un correo electronico valido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese su password", Toast.LENGTH_SHORT).show();
            return;
        }
        logIn(email, password);
    }

    public boolean emailIsValid(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private void logIn(String email, String password) {

        showLoading();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                hideLoading();
                goToHome();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1500);
    }

    private void goToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    private void showLoading() {
        progressDialog.setTitle("Iniciando Sesión");
        progressDialog.setMessage("Por favor espere...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void hideLoading() {
        progressDialog.dismiss();
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void goHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
