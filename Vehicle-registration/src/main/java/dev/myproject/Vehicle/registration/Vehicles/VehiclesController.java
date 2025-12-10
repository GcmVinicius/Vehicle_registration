package dev.myproject.Vehicle.registration.Vehicles;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    private final VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/ola")
    public String olaa(){
    return "Testando a porta de entrada";
}


    @PostMapping("/add")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDTO vehicle){
        VehicleDTO vehicleNew = vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Vehicle add suceffuly");


    }




    @GetMapping("/list")
    public ResponseEntity<List<VehicleDTO>> listVehicles(){
        List<VehicleDTO> vehicles = vehicleService.listVehicles();
        return  ResponseEntity.ok(vehicles);
    }








    @GetMapping("/list/{id}")
    public ResponseEntity<?> listByID(@PathVariable Long id){
        VehicleDTO vehicleID = vehicleService.listById(id);

        if (vehicleID != null){
            return ResponseEntity.ok(vehicleID);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Vehicle witch this Id was not found in ours database");

        }
    }





    @PutMapping("/alter/{id}")
    public ResponseEntity<?> alterById(@PathVariable Long id, @RequestBody VehicleDTO vehicleUpdate){
    VehicleDTO vehicle = vehicleService.alterVehicle(id, vehicleUpdate);

    if (vehicle != null){
        return ResponseEntity.ok(vehicle);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Vehicle not found");
        }
    }







    @DeleteMapping("/delet/{id}")
    public ResponseEntity<String> deletById(@PathVariable Long id){
    if (vehicleService.listById(id) != null){
    vehicleService.deletVehicle(id);
    return  ResponseEntity.ok("Sucefull deleted");
    } else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Vehicle not found");
    }

    }


}


