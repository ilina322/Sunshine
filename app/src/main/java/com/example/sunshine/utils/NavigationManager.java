package com.example.sunshine.utils;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.sunshine.R;
import com.example.sunshine.ui.fragments.DailyWeatherFragment;
import com.example.sunshine.ui.fragments.SearchFragment;
import com.example.sunshine.ui.fragments.WeeklyWeatherFragment;

public class NavigationManager {

    private FragmentManager fragmentManager;
    private static NavigationManager instance;

    public void setFragmentManager(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
    }

    public void openSearchScreen(){
        open(SearchFragment.newInstance());
    }

    public void openWeekWeatherScreen(){
        open(WeeklyWeatherFragment.newInstance());
    }

    public void openDayWeatherScreen(long date){
        Bundle args = new Bundle();
        args.putLong(DailyWeatherFragment.PARAM_DATE, date);
        DailyWeatherFragment fragment = DailyWeatherFragment.newInstance();
        fragment.setArguments(args);
        open(fragment);
    }

    private void open(Fragment fragment){
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragment.toString())
                .commit();
    }

    public static NavigationManager getInstance(){
        if(instance == null){
            instance = new NavigationManager();
        }
        return instance;
    }
}
