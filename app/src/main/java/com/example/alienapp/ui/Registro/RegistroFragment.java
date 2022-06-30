package com.example.alienapp.ui.Registro;

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
import com.example.alienapp.Model.Alien;
import com.example.alienapp.databinding.FragmentLoginBinding;
import com.example.alienapp.databinding.FragmentRegistroBinding;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroFragment extends Fragment {
    private FragmentRegistroBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegistroViewModel registroViewModel =
                new ViewModelProvider(this).get(RegistroViewModel.class);
        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final Button button = binding.Registro;
        button.setOnClickListener(new View.OnClickListener() {
            final TextView ap = binding.ApellidoPaterno;
            final TextView am = binding.ApellidoMaterno;
            final TextView nombre = binding.Nombre;
            final TextView correo = binding.Correo;
            final TextView contrasenia = binding.Password;
            final TextView nac = binding.Fechadenacimiento;
            final TextView status = binding.Estatussocial;
            final TextView usuario = binding.usuario;
            //final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            @Override
            public void onClick(View v) {
                String alien_usuario = usuario.getText().toString().trim();
                String alien_nombre = nombre.getText().toString().trim();
                String alien_ap = ap.getText().toString().trim();
                String alien_am = am.getText().toString().trim();
                String alien_correo = correo.getText().toString().trim();
                String alien_contrasenia = contrasenia.getText().toString().trim();
                String alien_nac = nac.getText().toString().trim();
                String alien_status = status.getText().toString().trim();

                //loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
               // httpClient.addInterceptor(loggingInterceptor);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api-alien.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                       // .client(httpClient.build())
                        .build();
                ApiAlien apiAlien = retrofit.create(ApiAlien.class);
                Call<Alien> call = apiAlien.addAlien(alien_usuario, alien_nombre, alien_ap, alien_am, alien_correo, alien_contrasenia, alien_nac, alien_status);
                call.enqueue(new Callback<Alien>() {
                    @Override
                    public void onResponse(Call<Alien> call, Response<Alien> response) {
                        if (response.isSuccessful() && response.body() != null){
                            Toast.makeText(getContext(), "REGISTRADO", Toast.LENGTH_SHORT).show();
                        }else {
                             Toast.makeText(getContext(), "NO REGISTRADO", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Alien> call, Throwable t) {

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
