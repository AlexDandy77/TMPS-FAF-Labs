package lab2.domain.adapter;

/**
 * Third-party legacy vehicle data system with incompatible interface.
 * Simulates an external API that we need to integrate.
 */
public class LegacyVehicleData {
    private final String vehicleMake;
    private final String vehicleType;
    private final int productionYear;
    private final String paintColor;

    public LegacyVehicleData(String vehicleMake, String vehicleType, int productionYear, String paintColor) {
        this.vehicleMake = vehicleMake;
        this.vehicleType = vehicleType;
        this.productionYear = productionYear;
        this.paintColor = paintColor;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getPaintColor() {
        return paintColor;
    }

    public String getLegacyInfo() {
        return String.format("%s %s (%d) - %s", vehicleMake, vehicleType, productionYear, paintColor);
    }
}

