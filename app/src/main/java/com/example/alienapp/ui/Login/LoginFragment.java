package com.example.alienapp.ui.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.alienapp.Interface.ApiAlien;
import com.example.alienapp.Model.Login;
import com.example.alienapp.databinding.FragmentLoginBinding;
import com.example.alienapp.ui.Recuperar_contrasenia.resetFragment;
import com.google.android.material.textfield.TextInputLayout;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LoginViewModel homeViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final Button btnLogin = binding.btnlogin;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            final TextView alien_correo = binding.txtuser;
            final TextView alien_contrasenia = binding.txtpassword;
            final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            @Override
            public void onClick(View v) {
                String correo = alien_correo.getText().toString().trim();
                String contrasenia = alien_contrasenia.getText().toString().trim();

                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(loggingInterceptor);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api-alien.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                ApiAlien login = retrofit.create(ApiAlien.class);
                Call<Login> call = login.logAlien(correo, contrasenia);
                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        if (response.isSuccessful() && response.body() != null){
                            Toast.makeText(getContext(), "Correcto", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getContext(), "No user", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {

                    }
                });
            }
        });




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}