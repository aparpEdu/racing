package com.example.car_racing.racing;



import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_racing.R;

public class RaceViewHolder extends RecyclerView.ViewHolder {
    private final TextView pilotName;
    private final TextView carMake;
    private final TextView confirmed;
    public RaceViewHolder(@NonNull View itemView) {
        super(itemView);
        pilotName = itemView.findViewById(R.id.pilotView);
        carMake = itemView.findViewById(R.id.carMakeView);
        confirmed = itemView.findViewById(R.id.confirmedView);
    }

    public void setPilotName(String pilotName) {
        this.pilotName.setText(pilotName);
    }

    public void setCarMake(String carMake) {
        this.carMake.setText(carMake);
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed.setText(String.valueOf(confirmed));
    }
}
