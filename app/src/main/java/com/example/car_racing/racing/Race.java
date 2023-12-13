package com.example.car_racing.racing;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.LocalDate;

public class Race implements Parcelable {
    private final String pilotName;
    private final String navigatorName;
    private final String teamName;
    private final String carMake;
    private final String requestDate;
    private boolean confirmed;


    public Race(String pilotName, String navigatorName, String teamName, String carMake, LocalDate requestDate, boolean confirmed) {
        this.pilotName = pilotName;
        this.navigatorName = navigatorName;
        this.teamName = teamName;
        this.carMake = carMake;
        this.requestDate = requestDate.toString();
        this.confirmed = confirmed;
    }

    protected Race(Parcel in) {
        pilotName = in.readString();
        navigatorName = in.readString();
        teamName = in.readString();
        carMake = in.readString();
        requestDate = in.readString();
        confirmed = in.readByte() != 0;
    }

    public static final Creator<Race> CREATOR = new Creator<Race>() {
        @Override
        public Race createFromParcel(Parcel in) {
            return new Race(in);
        }

        @Override
        public Race[] newArray(int size) {
            return new Race[size];
        }
    };

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getPilotName() {
        return pilotName;
    }

    public String getNavigatorName() {
        return navigatorName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(pilotName);
        parcel.writeString(navigatorName);
        parcel.writeString(teamName);
        parcel.writeString(carMake);
        parcel.writeString(requestDate);
        parcel.writeByte((byte) (confirmed ? 1 : 0));
    }
}
