package lab2.domain.proxy;

import lab1.domain.models.Vehicle;

/**
 * PROXY PATTERN - Controls access to expensive vehicle inspection operations.
 * Provides caching, lazy initialization, and access control.
 */
public class VehicleInspectionProxy implements VehicleInspection {
    private final Vehicle vehicle;
    private RealVehicleInspection realInspection;
    private String cachedDetailedInspection;
    private long lastInspectionTime;
    private static final long CACHE_VALIDITY_MS = 5000; // 5 seconds cache

    public VehicleInspectionProxy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String performDetailedInspection() {
        // Check if we have a valid cached result
        long currentTime = System.currentTimeMillis();
        if (cachedDetailedInspection != null &&
            (currentTime - lastInspectionTime) < CACHE_VALIDITY_MS) {
            System.out.println("   [Proxy] Returning cached inspection result");
            return cachedDetailedInspection + "\n   (Cached result)";
        }

        // Lazy initialization of real inspection
        if (realInspection == null) {
            System.out.println("   [Proxy] Creating real inspection object (lazy initialization)");
            realInspection = new RealVehicleInspection(vehicle);
        }

        // Perform real inspection and cache the result
        cachedDetailedInspection = realInspection.performDetailedInspection();
        lastInspectionTime = currentTime;
        return cachedDetailedInspection;
    }

    @Override
    public String performQuickCheck() {
        // Quick check doesn't need caching
        if (realInspection == null) {
            realInspection = new RealVehicleInspection(vehicle);
        }
        return realInspection.performQuickCheck();
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Clear the cache (e.g., after maintenance).
     */
    public void invalidateCache() {
        System.out.println("   [Proxy] Cache invalidated");
        cachedDetailedInspection = null;
    }
}


