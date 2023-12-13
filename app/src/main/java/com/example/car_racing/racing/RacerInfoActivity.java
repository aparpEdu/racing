package com.example.car_racing.racing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.car_racing.MainActivity;
import com.example.car_racing.R;

import java.time.LocalDate;

public class RacerInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racer_info);
        TextView pilot = findViewById(R.id.pilotView2);
        TextView navigator = findViewById(R.id.navigatorView);
        TextView team = findViewById(R.id.teamView);
        TextView carMake = findViewById(R.id.carMakeView2);
        TextView date = findViewById(R.id.dateView);
        EditText confirmation = findViewById(R.id.confirmationEdit);
        Race race =  getIntent().getParcelableExtra("race");
        if (race != null) {
            pilot.setText(race.getPilotName());
            navigator.setText(race.getNavigatorName());
            team.setText(race.getTeamName());
            carMake.setText(race.getCarMake());
            date.setText(race.getRequestDate());
            confirmation.setText(String.valueOf(race.isConfirmed()));
            findViewById(R.id.actionBtn).setOnClickListener(view -> finish());
            findViewById(R.id.actionBtn).setOnLongClickListener(view -> {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String confirmationText = confirmation.getText().toString();
                if (confirmationText.equalsIgnoreCase("true") || confirmationText.equalsIgnoreCase("false")){
                    race.setConfirmed(Boolean.parseBoolean(confirmation.getText().toString()));
                    intent.putExtra("racing", race);
                    intent.putExtra("position", getIntent().getIntExtra("pos", 0));
                    confirmation.setError(null);
                    startActivity(intent);
                } else {
                    confirmation.setError("Can be only true or false");
                }

                return false;
            });
        }

    }
}