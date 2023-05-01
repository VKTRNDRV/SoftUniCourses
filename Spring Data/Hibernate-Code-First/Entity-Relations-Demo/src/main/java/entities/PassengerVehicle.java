package entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract class PassengerVehicle extends Vehicle {

    @Basic
    protected int seats;

    protected PassengerVehicle(){}

    public PassengerVehicle(String type) {
        super(type);
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
