package com.example.alienapp.Model;

public class Login {
    public String alien_correo;
    public String alien_contrasenia;

    public String getAlien_correo() {
        return alien_correo;
    }

    public void setAlien_correo(String alien_correo) {
        this.alien_correo = alien_correo;
    }

    public String getAlien_contrasenia() {
        return alien_contrasenia;
    }

    public void setAlien_contrasenia(String alien_contrasenia) {
        this.alien_contrasenia = alien_contrasenia;
    }

    public Login(String alien_correo, String alien_contrasenia) {
        this.alien_correo = alien_correo;
        this.alien_contrasenia = alien_contrasenia;
    }
}
