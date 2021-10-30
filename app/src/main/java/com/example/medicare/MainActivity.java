package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.medicare.Fragments.ConnectFragment;
import com.example.medicare.Fragments.HomeFragment;
import com.example.medicare.Fragments.ProfileFragment;
import com.example.medicare.Fragments.RequirementFragment;

import com.example.medicare.databinding.ActivityMainBinding;
import com.iammert.library.readablebottombar.ReadableBottomBar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content, new HomeFragment());
        transaction.commit();

        binding.readableBottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (i){
                    case 0:
                        transaction.replace(R.id.content, new HomeFragment());
                        break;
                    case 1:
                        transaction.replace(R.id.content, new ConnectFragment());
                        break;

                    case 2:
                        transaction.replace(R.id.content, new RequirementFragment());
                        break;

                    case 3:
                        transaction.replace(R.id.content, new ProfileFragment());
                        break;
                }
                transaction.commit();



            }
        });
    }
}