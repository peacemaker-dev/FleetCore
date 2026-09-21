package com.fleetcore.model;

import com.fleetcore.exception.FleetCoreException;
import com.fleetcore.util.Validator;

/**
 *
 * @author mlamu
 */
public class Driver extends Person {

    private String licenceNumber;
    private LicenceCategory licenceCategory;
    private DriverStatus status;

    public Driver(String licenceNumber, LicenceCategory licenceCategory, String name, String phone, String email) {
        this(licenceNumber, licenceCategory, DriverStatus.AVAILABLE, 0, name, phone, email);
    }

    public Driver(String licenceNumber, LicenceCategory licenceCategory, DriverStatus status, int id, String name, String phone, String email) {
        super(id, name, phone, email);
        Validator.requireNotBlank(licenceNumber, "Licence number");
        Validator.requireNotNull(licenceCategory, "Licence category");
        Validator.requireNotNull(status, "Status");
        this.licenceNumber = licenceNumber;
        this.licenceCategory = licenceCategory;
        this.status = status;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public LicenceCategory getLicenceCategory() {
        return licenceCategory;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setLicenceNumber(String licenceNumber) {
        Validator.requireNotBlank(licenceNumber, "Licence number");
        this.licenceNumber = licenceNumber;
    }

    public void setLicenceCategory(LicenceCategory licenceCategory) {
        Validator.requireNotNull(licenceCategory, "Licence category");
        this.licenceCategory = licenceCategory;
    }

    public boolean isAvaiable() {
        return status == DriverStatus.AVAILABLE;
    }

    public boolean canDrive(Vehicle vehicle) {
        return licenceCategory.compareTo(vehicle.getRequiredLicence()) >= 0;
    }

    public void markOnTrip() {
        if (status != DriverStatus.AVAILABLE) {
            throw new FleetCoreException("Only an available driver can go on a trip");
        }
        status = DriverStatus.ON_TRIP;
    }

    public void markAvailable() {
        status = DriverStatus.AVAILABLE;
    }

    public void markOffDuty() {
        status = DriverStatus.OFF_DUTY;
    }

    @Override
    protected String getSpecificDetails() {
        String details;
        details = "Name: " + getName()
                + " | Email: " + getEmail()
                + " | Phone: " + getPhone()
                + " | Licence: " + getLicenceNumber() + "(" + licenceCategory + ")";
        return details;
    }
}
