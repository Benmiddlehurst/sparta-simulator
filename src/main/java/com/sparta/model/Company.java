package com.sparta.model;

import com.sparta.utility.Randomizer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Company {

    private ArrayList<Centre> centres;
    private LinkedList<Trainee> waitingList;

    public Company() {
        this.centres = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public ArrayList<Centre> getCentres() {
        return centres;
    }

    public LinkedList<Trainee> getWaitingList() {
        return waitingList;
    }

    public void openCentre() {
        Centre centre = new Centre();
        centres.add(centre);
    }

    public void assignTrainees() {
        ArrayList<Centre> availableCentres = centresAvailable(centres);
        while (availableCentres.size() != 0 && waitingList.size() != 0) {
            int firstTraineeToBeAdded = 0;
            Trainee trainee = waitingList.get(firstTraineeToBeAdded);
            int temp = Randomizer.generateRandomInt(0, availableCentres.size()-1);
            Centre currentCentre = availableCentres.get(temp);
            if (!currentCentre.isFull()) {
                addTraineeToCentre(trainee, currentCentre);
                removeTraineeFromWaitingList(trainee);
            } else {
                availableCentres.remove(currentCentre);
            }
        }
    }

    private ArrayList<Centre> centresAvailable(ArrayList<Centre> centres) {
        ArrayList<Centre> centresAvailable = new ArrayList<>();
        for (Centre centre : centres) {
            if (!centre.isFull()) {
                centresAvailable.add(centre);
            }
        }
        return centresAvailable;
    }

    private void addTraineeToCentre(Trainee trainee, Centre currentCentre) {
        currentCentre.addTrainee(trainee);
    }
    private void removeTraineeFromWaitingList(Trainee trainee) {
        waitingList.remove(trainee);
    }
}