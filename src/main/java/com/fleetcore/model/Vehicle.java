package com.fleetcore.model;

import com.fleetcore.exception.FleetCoreException;
import com.fleetcore.util.Validator;

/**
 *
 * @author mlamu
 */
public class Vehicle {

    private int id;
    private String registrationNumber;
    private String make;
    private String model;
    private double capacityKg;
    private LicenceCategory requiredLicence;
    private VehicleStatus status;

    public Vehicle(String registrationNumber, String make, String model, double capacityKg, LicenceCategory requiredLicence, VehicleStatus status) {
        this(0, registrationNumber, make, model, capacityKg, requiredLicence, VehicleStatus.AVAILABLE);
    }

    public Vehicle(int id, String registrationNumber, String make, String model, double capacityKg, LicenceCategory requiredLicence, VehicleStatus status) {
        Validator.requireNotBlank(registrationNumber, "Registration number");
        Validator.requireNotBlank(make, "Make");
        Validator.requireNotBlank(model, "Model");
        Validator.requirePositive(capacityKg, "Capacity");
        Validator.requireNotNull(requiredLicence, "Required licence");
        Validator.requireNotNull(status, "Status");
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.capacityKg = capacityKg;
        this.requiredLicence = requiredLicence;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getCapacityKg() {
        return capacityKg;
    }

    public LicenceCategory getRequiredLicence() {
        return requiredLicence;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegistrationNumber(String registrationNumber) {
        Validator.requireNotBlank(registrationNumber, "Registration number");
        this.registrationNumber = registrationNumber;
    }

    public void setMake(String make) {
        Validator.requireNotBlank(make, "Make");
        this.make = make;
    }

    public void setModel(String model) {
        Validator.requireNotBlank(model, "Model");
        this.model = model;
    }

    public void setCapacityKg(double capacityKg) {
        Validator.requireNotNull(capacityKg, "Capacity");
        this.capacityKg = capacityKg;
    }

    public void setRequiredLicence(LicenceCategory requiredLicence) {
        Validator.requireNotNull(requiredLicence, "Required licence");
        this.requiredLicence = requiredLicence;
    }

    public boolean isAvaiable() {
        return status == VehicleStatus.AVAILABLE;
    }

    public boolean canCarry(double weightKg) {
        return weightKg <= capacityKg;
    }

    public void markOnTrip() {
        if (status != VehicleStatus.AVAILABLE) {
            throw  new FleetCoreException("A vehicle on a trip cannot go to maintenance");
        }
        status = VehicleStatus.ON_TRIP;
    }

    public void markAvailable() {
        status = VehicleStatus.AVAILABLE;
    }

    public void sendToMaintenance() {
        if (status != VehicleStatus.ON_TRIP) {
            status = VehicleStatus.IN_MAINTENANCE;
        }
    }
}
