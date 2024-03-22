package ru.geekbrains.oop.lesson5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {

    private static int counter;
    private int no;

    private Collection<Reservation> reservations = new ArrayList<>();

    public int getNo() {
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public boolean deleteReservation(int noReservation){
        for(Reservation reservation : getReservations()){
            if(reservation.getId() == noReservation){
                reservations.remove(reservation);
                return true;
            }
        }
        return false;
    }
    public Table(){
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}
