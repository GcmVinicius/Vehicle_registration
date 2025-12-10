package dev.myproject.Vehicle.registration.Vehicles;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehiclesMapper vehiclesMapper;

    public VehicleService(VehicleRepository vehicleRepository, VehiclesMapper vehiclesMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehiclesMapper = vehiclesMapper;
    }

    //List all vehicles
    public List<VehicleDTO> listVehicles(){
        List<VehiclesModel> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehiclesMapper::map)
                .collect(Collectors.toList());
    }

    //List by ID
    public VehicleDTO listById(Long id){
        Optional<VehiclesModel> vehicleById = vehicleRepository.findById(id);
        return vehicleById.map(vehiclesMapper::map).orElse(null);
    }
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO){
    VehiclesModel vehicle = vehiclesMapper.map(vehicleDTO);
    vehicle = vehicleRepository.save(vehicle);
    return vehiclesMapper.map(vehicle);

    }

    public void deletVehicle(Long id){
    vehicleRepository.deleteById(id);
    }

    public VehicleDTO alterVehicle(Long id, VehicleDTO vehicleDTO){
    Optional<VehiclesModel> existingVehicle = vehicleRepository.findById(id);
    if (existingVehicle.isPresent()){
    VehiclesModel vehicleNew = vehiclesMapper.map(vehicleDTO);
    vehicleNew.setId(id);
    VehiclesModel vehicleSave =vehicleRepository.save(vehicleNew);
    return vehiclesMapper.map(vehicleSave);
    }
    return null;
    }


}
