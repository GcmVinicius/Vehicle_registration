package dev.myproject.Vehicle.registration.Vehicles;

public enum SegmentEnum {
    SPORT("Sport"),
    SUV("SUV"),
    COMFORT("Comfort"),
    LUXURY("Luxury"),
    FAMILY("Family"),
    EXECUTIVE("Executivo");

    private final String description;

    SegmentEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
