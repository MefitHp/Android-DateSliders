package com.example.mefithp.u2menupicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    private static TextView tvCumple;
    private static Button btnAceptar, btnFecha;
    private static DatePickerDialog.OnDateSetListener dateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnAceptar = findViewById(R.id.btnAceptar);
        btnFecha = findViewById(R.id.btnFecha);
        tvCumple = findViewById(R.id.tvCumple);

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Main2Activity.this , android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateListener,
                        year, month, day);
                dialog.show();
            }
        });

        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                      String date = month + " / " + day + " / " + year;
                      tvCumple.setText(date);
            }
        };

        final Intent back = new Intent(this, MainActivity.class);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(back);
            }
        });
    }
    }
