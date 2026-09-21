
package com.fleetcore.util;

import com.fleetcore.exception.FleetCoreException;
import java.math.BigDecimal;

/**
 *
 * @author mlamu
 */
public class Validator {

    private Validator() {
        
    }
    
    public static void requireNotBlank(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new FleetCoreException(field + " cannot be blank");
        }
    }
    
    public static void requireNotNull(Object value, String field) {
        if (value == null) {
            throw new FleetCoreException(field + " is required");
        }
    }
    
    public static void requirePositive(double value, String field) {
        if (value <= 0) {
            throw new FleetCoreException(field + " must be greater than 0");
        }
    }
    
    public static void requirePositive(BigDecimal value, String field) {
        requireNotNull(value, field);
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new FleetCoreException(field + " must be greater than 0");
        }
    }
}
