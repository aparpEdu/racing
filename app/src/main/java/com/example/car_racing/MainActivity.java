package com.example.car_racing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.car_racing.racing.FragmentListener;
import com.example.car_racing.racing.Race;
import com.example.car_racing.racing.RaceAdapter;
import com.example.car_racing.racing.RaceAddDialogFragment;
import com.example.car_racing.racing.RaceSource;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    List<Race> racing;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Race race = getIntent().getParcelableExtra("racing");
        racing = RaceSource.getRace();

        recyclerView = findViewById(R.id.recycler);
        RaceAdapter adapter = new RaceAdapter(racing);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (race != null) {
            racing.set(getIntent().getIntExtra("position", 0), race);
            recyclerView.getAdapter().notifyItemChanged(getIntent().getIntExtra("position", 0));
        }
        findViewById(R.id.add).setOnClickListener(view -> {
            RaceAddDialogFragment fragment = RaceAddDialogFragment.newInstance();
            fragment.setListener(this);
            fragment.show(getSupportFragmentManager(), "RaceAddDialogFragment");
        });
    }

    @Override
    public void addNewRace(Race race) {
        int pos = racing.size();
        racing.add(race);
        recyclerView.getAdapter().notifyItemInserted(pos);
    }
}