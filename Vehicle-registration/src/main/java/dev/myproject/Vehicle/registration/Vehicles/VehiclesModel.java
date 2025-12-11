package dev.myproject.Vehicle.registration.Vehicles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "Vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehiclesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;

    @Column(name = "vehicle_type")
    private String type;

    @Column (name = "Brand")
    private String brand;

    @Column (name = "Model")
    private String model;

    @Column (name = "Price")
    private int price;

    @Column (name = "vehicle_year")
    private int year;



}
