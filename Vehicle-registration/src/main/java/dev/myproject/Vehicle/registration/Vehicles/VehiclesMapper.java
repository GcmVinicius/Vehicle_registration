package dev.myproject.Vehicle.registration.Vehicles;

import org.springframework.stereotype.Component;

@Component
public class VehiclesMapper {

    public VehiclesModel map(VehicleDTO dto) {
        if (dto == null) {
            return null;
        }

        VehiclesModel model = new VehiclesModel();

        model.setId(dto.getId());

        model.setType(dto.getType());

        model.setType(dto.getType());
        model.setBrand(dto.getBrand());
        model.setModel(dto.getModel());
        model.setPrice(dto.getPrice());
        model.setYear(dto.getYear());
        model.setImgUrl(dto.getImgUrl());

        return model;
    }


    public VehicleDTO map(VehiclesModel model) {
        if (model == null) {
            return null;
        }

        VehicleDTO dto = new VehicleDTO();

        dto.setId(model.getId());
        dto.setType(model.getType());
        dto.setBrand(model.getBrand());
        dto.setModel(model.getModel());
        dto.setPrice(model.getPrice());
        dto.setYear(model.getYear());
        dto.setImgUrl(model.getImgUrl());

        return dto;
    }

}
