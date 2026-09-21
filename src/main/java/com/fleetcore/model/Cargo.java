
package com.fleetcore.model;

import com.fleetcore.util.Validator;

/**
 *
 * @author mlamu
 */
public class Cargo {
    private int id;
    private String description;
    private double weightKg;

    public Cargo(String description, double weightKg) {
        this(0, description, weightKg);
    } 
    
    public Cargo(int id, String description, double weightKg) {
        Validator.requireNotBlank(description, "Description");
        Validator.requirePositive(weightKg, "Weight");
        this.id = id;
        this.description = description;
        this.weightKg = weightKg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        Validator.requireNotBlank(description, "Description");
        this.description = description;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        Validator.requirePositive(weightKg, "Weight");
        this.weightKg = weightKg;
    }
}
