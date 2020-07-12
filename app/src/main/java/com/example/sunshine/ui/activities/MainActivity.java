package com.example.sunshine.ui.activities;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sunshine.R;
import com.example.sunshine.ui.fragments.SearchFragment;
import com.example.sunshine.ui.fragments.WeeklyWeatherFragment;
import com.example.sunshine.utils.NavigationManager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            NavigationManager.getInstance().setFragmentManager(getSupportFragmentManager());
            NavigationManager.getInstance().openSearchScreen();
        }
    }

}