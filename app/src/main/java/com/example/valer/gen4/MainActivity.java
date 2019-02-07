package com.example.valer.gen4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment squareNameFragment = new SquareNameFragment();
        this.setDefaultFragment(squareNameFragment);
    }

    private void setDefaultFragment(Fragment defaultFragment) {
        addFragment(defaultFragment);
    }

    public void replaceFragment(Fragment destFragment){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, destFragment);
        fragmentTransaction.commit();
    }

    public void addFragment(Fragment fragment){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_main, fragment);
        fragmentTransaction.commit();
    }
}
