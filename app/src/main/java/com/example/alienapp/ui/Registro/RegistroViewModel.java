package com.example.alienapp.ui.Registro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistroViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    public RegistroViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }
    public LiveData<String> getText() {
        return mText;
    }

}
