package com.fleetcore;

import com.fleetcore.exception.FleetCoreException;
import com.fleetcore.model.*;
import java.math.BigDecimal;

public class FleetCore {

    public static void main(String[] args) {
        Customer customer = new Customer("Test Co", "12 Main Rd, Pretoria",
                "Sipho", "0821234567", "sipho@example.com");
        Vehicle truck = new Vehicle("CA123456", "Isuzu", "FTR", 9000, LicenceCategory.C1, VehicleStatus.AVAILABLE);
        Driver driver = new Driver("LIC001", LicenceCategory.EC,
                "Thabo", "0831234567", "thabo@example.com");
        Cargo cargo = new Cargo("Steel pipes", 5000);
        FreightOrder order = new FreightOrder(customer, "Pretoria", "Durban",
                cargo, new BigDecimal("15000.00"));

        System.out.println(driver.canDrive(truck));                  // true
        System.out.println(truck.canCarry(cargo.getWeightKg()));     // true

        order.assign(driver, truck);
        order.dispatch();
        order.markDelivered();
        System.out.println(order.getStatus());                       // DELIVERED

        try {
            order.dispatch();                                        // must be blocked
        } catch (FleetCoreException e) {
            System.out.println("Blocked: " + e.getMessage());
        }
        System.out.println(customer.getDescription());
    }
}