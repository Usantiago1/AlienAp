package com.example.alienapp.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Desarrolladores\n Ulises, Raul, Carlos, Jesus");

    }

    public LiveData<String> getText() {
        return mText;
    }
}