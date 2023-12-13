package com.example.car_racing.racing;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.car_racing.R;

import java.time.LocalDate;


public class RaceAddDialogFragment extends DialogFragment {
    private FragmentListener listener;


    public RaceAddDialogFragment() {
    }


    public static RaceAddDialogFragment newInstance() {
        RaceAddDialogFragment fragment = new RaceAddDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText pilot = view.findViewById(R.id.editTextPilotName);
        EditText carMake = view.findViewById(R.id.editTextCarMake);
        EditText navigator = view.findViewById(R.id.editTextNavigatorName);
        EditText team = view.findViewById(R.id.editTextTeamName);



        view.findViewById(R.id.add2).setOnClickListener(v -> {
            String pilotText = pilot.getText().toString();
            String carMakeText = carMake.getText().toString();
            String navigatorText =  navigator.getText().toString();
            String teamText = team.getText().toString();
            if(pilotText.isEmpty()){
                pilot.setError("Pls pilot");
            } else {
                pilot.setError(null);
            }

            if(carMakeText.isEmpty()) {
                carMake.setError("pls car");
            } else {
                carMake.setError(null);
            }

            if(navigatorText.isEmpty()) {
                navigator.setError("pls navigator");
            } else {
                navigator.setError(null);
            }

            if (teamText.isEmpty()) {
                team.setError("pls team");
            } else {
                team.setError(null);
            }
            if (pilot.getError() == null && carMake.getError() == null && navigator.getError() == null && team.getError() == null) {
                Race race = new Race(pilotText, navigatorText, teamText, carMakeText, LocalDate.now(), false );
                listener.addNewRace(race);
                dismiss();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_race_add_dialog, container, false);
    }

    public void setListener(FragmentListener listener) {
        this.listener = listener;
    }
}