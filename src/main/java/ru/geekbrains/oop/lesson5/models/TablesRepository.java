package ru.geekbrains.oop.lesson5.models;

import ru.geekbrains.oop.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class TablesRepository implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        boolean reservationDeleted = false;
        for(Table table : tables){
            if(table.deleteReservation(oldReservation)){
                reservationDeleted = true;
                if(table.getNo() == tableNo){
                    return  reservationTable(reservationDate, tableNo, name);
                }
            }
        }
        if(!reservationDeleted) {
            throw new RuntimeException("Некорректный номер бронирования");
        }else{
            return reservationTable(reservationDate, tableNo, name);
        }
    }




}
