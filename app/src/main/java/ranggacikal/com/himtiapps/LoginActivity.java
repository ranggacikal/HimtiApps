package ranggacikal.com.himtiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import ranggacikal.com.himtiapps.api.ApiService;
import ranggacikal.com.himtiapps.api.ConfigRetrofit;
import ranggacikal.com.himtiapps.model.ResponseLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView txtRegister;
    EditText edtEmail, edtPassword;
    Button btnLogin;
    Context context;
    ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        apiService = ConfigRetrofit.service;

        edtEmail = findViewById(R.id.edtEmailLogin);
        edtPassword = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        txtRegister = findViewById(R.id.textRegisterLogin);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registAct = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registAct);
            }
        });
    }

    private void Login() {

        final String email = edtEmail.getText().toString();
        final String password = edtPassword.getText().toString();

        if (email.isEmpty()){
            edtEmail.setError("Email Tidak Boleh Kosong");
            edtEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.setError("Masukan Email Yang Valid !!");
            edtEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            edtPassword.setError("Password Tidak Boleh Kosong");
            edtPassword.requestFocus();
            return;
        }

        ConfigRetrofit.service.Login(email, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){
                    int status = response.body().getStatus();
                    String pesan = response.body().getPesan();

                    if (status == 1){
                        Toast.makeText(context, pesan, Toast.LENGTH_LONG).show();
                        edtPassword.setText("");
                        Intent pindahhome = new Intent(context, MainActivity.class);
                        startActivity(pindahhome);
                    }else{
                        Toast.makeText(context, pesan, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

            }
        });
    }
}
