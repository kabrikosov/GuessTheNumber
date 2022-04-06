package com.bignerdanch.android.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdanch.android.guessthenumber.databinding.ActivityGuessTheNumberBinding;

import java.util.concurrent.atomic.AtomicInteger;

public class GuessTheNumber extends AppCompatActivity {
    private ActivityGuessTheNumberBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        binding = ActivityGuessTheNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView start = binding.startValue;
        start.setText(intent.getStringExtra("start"));

        TextView end = binding.endValue;
        end.setText(intent.getStringExtra("end"));

        TextView chosen = binding.chosenValue;

        Button bigger = binding.biggerButton;
        Button smaller = binding.smallerButton;
        Button equ = binding.equalsButton;
        TextView counter = binding.counter;
        AtomicInteger ct = new AtomicInteger();
        AtomicInteger a = new AtomicInteger(Integer.parseInt(start.getText().toString()));
        AtomicInteger b = new AtomicInteger(Integer.parseInt(end.getText().toString()));
        AtomicInteger ch = new AtomicInteger(a.get() + (b.get() - a.get()) / 2);
        chosen.setText(Integer.toString(ch.get()));

        bigger.setOnClickListener(view -> {
            ct.getAndIncrement();
            counter.setText(Integer.toString(ct.get()));
            a.set(ch.get() + 1);
            ch.set(a.get() + (b.get() - a.get()) / 2);
            binding.chosenValue.setText(Integer.toString(ch.get()));
        });

        smaller.setOnClickListener(view -> {
            ct.getAndIncrement();
            counter.setText(Integer.toString(ct.get()));
            b.set(ch.get());
            ch.set(a.get() + (b.get() - a.get()) / 2);
            binding.chosenValue.setText(Integer.toString(ch.get()));
        });

        equ.setOnClickListener(view ->
            startActivity(new Intent(this, MainActivity.class)));
    }
}