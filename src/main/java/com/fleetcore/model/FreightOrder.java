
package com.fleetcore.model;

import com.fleetcore.exception.FleetCoreException;
import com.fleetcore.util.Validator;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author mlamu
 */
public class FreightOrder {
    private int id;
    private Customer customer;
    private String pickupAddress;
    private String destinationAddress;
    
    private Cargo cargo;
    private OrderStatus status;
    private BigDecimal amount;
    private LocalDate createdDate;
    
    private Driver driver = null;
    private Vehicle vehicle = null;
    private String failureReason = null;

    public FreightOrder(Customer customer, String pickupAddress, String destinationAddress, Cargo cargo, BigDecimal amount) {
        this(0, customer, pickupAddress, destinationAddress, cargo, 
                OrderStatus.PENDING, amount, LocalDate.now(), null, null, null);
    }

    public FreightOrder(int id, Customer customer, String pickupAddress, String destinationAddress, Cargo cargo, 
            OrderStatus status, BigDecimal amount, LocalDate createdDate, Driver driver, Vehicle vehicle, String failureReason) {
        Validator.requireNotNull(customer, "Customer");
        Validator.requireNotBlank(pickupAddress, "Pickup address");
        Validator.requireNotBlank(destinationAddress, "Destination address");
        Validator.requireNotNull(cargo, "Cargo");
        Validator.requireNotNull(status, "Status");
        Validator.requirePositive(amount, "Amount");
        Validator.requireNotNull(createdDate, "Created date");
        this.id = id;
        this.customer = customer;
        this.pickupAddress = pickupAddress;
        this.destinationAddress = destinationAddress;
        this.cargo = cargo;
        this.status = status;
        this.amount = amount;
        this.createdDate = createdDate;
        this.driver = driver;
        this.vehicle = vehicle;
        this.failureReason = failureReason;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Driver getDriver() {
        return driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void assign(Driver driver, Vehicle vehicle) {
        Validator.requireNotNull(driver, "Driver");
        Validator.requireNotNull(vehicle, "Vehicle");
        this.driver = driver;
        this.vehicle = vehicle;
        status = OrderStatus.ASSIGNED;
    }
    
    public void dispatch() {
        requireStatus(OrderStatus.ASSIGNED, "dispatch");
        status = OrderStatus.DISPATCHED;
    }
    
    public void markDelivered() {
        requireStatus(OrderStatus.DISPATCHED, " mark as delivered");
        status = OrderStatus.DELIVERED;
    }
    
    public void markDelayed() {
        requireStatus(OrderStatus.DISPATCHED, " mark as delayed");
        status = OrderStatus.DELAYED;
    }
    
    public void markFailed(String reason) {
        Validator.requireNotBlank(reason, "Failure reason");
        if (status != OrderStatus.DISPATCHED && status != OrderStatus.DELAYED) {
            throw new FleetCoreException("Only a dispatched or delayed order can fail");
        }
        status = OrderStatus.FAILED;
        failureReason = reason;
    }
    
    public void reschedule() {
        requireStatus(OrderStatus.DELAYED, "reschedule");
        status = OrderStatus.ASSIGNED;
    }
    
    private void requireStatus(OrderStatus expected, String action) {
        if (status != expected) {
            throw new FleetCoreException("Cannot " + action + " an order that is " + status + " (must be " + expected + ")");
        }
    }
}
