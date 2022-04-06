package com.bignerdanch.android.guessthenumber;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.bignerdanch.android.guessthenumber.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.bignerdanch.android.guessthenumber.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.a.setMinValue(0);
        binding.a.setMaxValue(1000);

        binding.b.setMinValue(0);
        binding.b.setMaxValue(1000);
        binding.b.setValue(100);

        binding.startButton.setOnClickListener(v -> {
            int start = binding.a.getValue();
            int end = binding.b.getValue();
            if (end - start > 0){
                Intent intent = new Intent(this, GuessTheNumber.class);
                intent.putExtra("start", Integer.toString(start));
                intent.putExtra("end", Integer.toString(end));
                startActivity(intent);
            }
        });

    }
}