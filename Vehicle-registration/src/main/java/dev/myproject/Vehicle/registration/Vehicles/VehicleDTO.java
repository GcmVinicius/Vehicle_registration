package dev.myproject.Vehicle.registration.Vehicles;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long id;

    private String type;

    private String brand;

    private String model;

    private int price;

    private int year;


}
