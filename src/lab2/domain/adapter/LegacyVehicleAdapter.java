package lab2.domain.adapter;

import lab1.domain.models.Vehicle;

/**
 * ADAPTER PATTERN - Adapts LegacyVehicleData to work with our Vehicle interface.
 * Allows integration of third-party vehicle data systems.
 */
public class LegacyVehicleAdapter implements Vehicle {
    private final LegacyVehicleData legacyData;

    public LegacyVehicleAdapter(LegacyVehicleData legacyData) {
        this.legacyData = legacyData;
    }

    @Override
    public String getDescription() {
        // Adapt the legacy format to our Vehicle interface format
        return String.format("Legacy Vehicle: %s %s (%d), Color: %s",
                legacyData.getVehicleMake(),
                legacyData.getVehicleType(),
                legacyData.getProductionYear(),
                legacyData.getPaintColor());
    }

    // Additional method to access the adapted legacy data
    public LegacyVehicleData getLegacyData() {
        return legacyData;
    }
}
