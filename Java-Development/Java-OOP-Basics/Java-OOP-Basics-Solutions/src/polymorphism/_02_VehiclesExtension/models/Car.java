package polymorphism._02_VehiclesExtension.models;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        String result = null;
        double fuelNeed = distance * (this.getFuelConsumption() + AIR_CONDITIONER_CONSUMPTION);
        if (fuelNeed <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeed);
            result = String.format("Car travelled %s km", new DecimalFormat("0.########").format(distance));
        } else {
            result = "Car needs refueling";
        }

        return result;
    }

    @Override
    public void refuel(double liters) {
        double fuel = this.getFuelQuantity() + liters;
        if (fuel > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.setFuelQuantity(fuel);
    }
}
