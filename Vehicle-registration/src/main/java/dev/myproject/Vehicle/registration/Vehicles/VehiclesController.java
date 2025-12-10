package dev.myproject.Vehicle.registration.Vehicles;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

@GetMapping("/ola")
    public String olaa(){
    return "Testando a porta de entrada";
}

/*
    @PostMapping("/add")

    @GetMapping("/list")

    @GetMapping("/list/{id}")

    @PutMapping("/alter/{id}")

    @DeleteMapping("/delet/{id}")
*/

}


