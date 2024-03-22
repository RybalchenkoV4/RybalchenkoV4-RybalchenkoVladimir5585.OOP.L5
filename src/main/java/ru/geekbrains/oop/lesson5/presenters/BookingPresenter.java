package ru.geekbrains.oop.lesson5.presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Model model;
    private View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    private void updateChangeReservationTableView(int reservationNo){
        view.showChangeReservationTableResult(reservationNo);
    }
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateChangeReservationTableView(reservationNo);
        }catch(Exception e){
            updateChangeReservationTableView(-1);
        }
    }
}
