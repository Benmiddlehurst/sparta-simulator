package com.sparta.model;

import com.sparta.configuration.Settings;
import java.util.ArrayList;

public class Centre {
    private int centreId;
    private final int capacity;

    public Centre () {
        this.capacity = Settings.CENTER_CAPACITY.getValue();
    }
    private static ArrayList<Trainee> trainees = new ArrayList<>();
    public static ArrayList<Trainee> getTraineesList(){
        return trainees;
    }

    public int getNumberOfTrainees() {
        int traineeInProgress=0;
        for (Trainee trainee : trainees) {
            traineeInProgress=trainee.getCount();
        }
        return traineeInProgress;
    }

    public boolean isFull() {
        if (getCapacityCount()>0) {
            return false;
        }
        return true;
    }

    private int getCapacityCount () {
        int currentCapacity=0;
        currentCapacity = capacity - trainees.size();
        return currentCapacity;
    }

    public void addTrainee(Trainee trainee)  {
        trainees.add(trainee);
    }

    public int getCentreId() {
        return centreId;
    }
}
