package ranggacikal.com.himtiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ranggacikal.com.himtiapps.api.ApiService;
import ranggacikal.com.himtiapps.api.ConfigRetrofit;
import ranggacikal.com.himtiapps.model.ResponseRegister;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Context context;
    ApiService apiServiceRegister;
    EditText edtUsername, edtNim, edtEmail, edtPassword, edtConfirmPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponents();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Register() {

        final String username = edtUsername.getText().toString();
        final int nim = Integer.parseInt(edtNim.getText().toString());
        final String email = edtEmail.getText().toString();
        final String password = edtPassword.getText().toString();
        final String confirmPassword = edtConfirmPassword.getText().toString();

        if (username.isEmpty()){
            edtUsername.setError("Username Tidak Boeh Kosong");
            edtUsername.requestFocus();
            return;
        }

        if (String.valueOf(nim).isEmpty()){
            edtNim.setError("NIM Tidak Boleh Kosong");
            edtNim.requestFocus();
            return;
        }

        if (email.isEmpty()){
            edtEmail.setError("Email Tidak Boleh Kosong");
            edtEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.setError("Harap Masukan Email Yang Valid");
            edtEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            edtPassword.setError("Password Tidak Boleh Kosong");
            edtPassword.requestFocus();
            return;
        }

        if (confirmPassword.isEmpty()){
            edtConfirmPassword.setError("Confirm Pasword Tidak Boleh Kosong");
            edtConfirmPassword.requestFocus();
            return;
        }

        if (!confirmPassword.equals(password)){
            edtConfirmPassword.setError("Password Tidak Sama / Password Not Match");
            edtConfirmPassword.requestFocus();
            return;
        }

        ConfigRetrofit.service.Register(username, String.valueOf(nim), email, password).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()){
                    boolean sukses = response.body().isSukses();
                    String pesan = response.body().getPesan();

                    if (sukses == true){
                        Toast.makeText(context, pesan+" Silahkan Login", Toast.LENGTH_SHORT).show();
                        Intent pindahLogin = new Intent(context, LoginActivity.class);
                        startActivity(pindahLogin);

                    }else{
                        Toast.makeText(context,  pesan, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(context, "REGISTER ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(context, "NETWORK ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComponents() {

        context = this;
        apiServiceRegister = ConfigRetrofit.service;
        edtUsername = findViewById(R.id.edtUsernameRegister);
        edtNim = findViewById(R.id.edtNimRegister);
        edtEmail = findViewById(R.id.edtEmailRegister);
        edtPassword = findViewById(R.id.edtPasswordRegister);
        edtConfirmPassword = findViewById(R.id.edtConfirmPasswordRegister);
        btnRegister = findViewById(R.id.buttonRegister);
    }
}
