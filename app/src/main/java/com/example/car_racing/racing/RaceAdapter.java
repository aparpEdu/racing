package com.example.car_racing.racing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_racing.R;

import java.util.List;

public class RaceAdapter extends RecyclerView.Adapter<RaceViewHolder> {
    private Context context;
    private final List<Race> races;

    public RaceAdapter(List<Race> races) {
        this.races = races;
    }

    @NonNull
    @Override
    public RaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View raceView = inflater.inflate(R.layout.racer, parent, false);
        return new RaceViewHolder(raceView);
    }

    @Override
    public void onBindViewHolder(@NonNull RaceViewHolder holder, int position) {
        Race race = races.get(position);
        holder.setConfirmed(race.isConfirmed());
        holder.setCarMake(race.getCarMake());
        holder.setPilotName(race.getCarMake());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, RacerInfoActivity.class);
            intent.putExtra("race", race);
            intent.putExtra("pos", position);
            context.startActivity(intent);
        });

        holder.itemView.setOnLongClickListener(view -> {
            races.remove(position);
            notifyItemRemoved(position);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return races.size();
    }
}
