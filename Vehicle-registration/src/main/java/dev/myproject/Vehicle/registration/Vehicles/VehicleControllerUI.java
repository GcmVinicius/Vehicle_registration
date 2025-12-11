package dev.myproject.Vehicle.registration.Vehicles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/vehicle/ui")
public class VehicleControllerUI {

    private final VehicleService vehicleService;

    public VehicleControllerUI(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/list")
    public String listVehicles(Model model){
        List<VehicleDTO> vehicles = vehicleService.listVehicles();
        model.addAttribute("vehicles", vehicles);
        return "listVehicles";
    }

    @GetMapping("/delet/{id}")
    public String deletVehiclesById(@PathVariable Long id){
        vehicleService.deletVehicle(id);
        return "redirect:/vehicle/ui/list";
    }

    @GetMapping("/list/{id}")
    public String listbyId(@PathVariable Long id, Model model){
        VehicleDTO vehicles = vehicleService.listById(id);
        if (vehicles !=null) {
            model.addAttribute("vehicles", vehicles);
            return "vehiclesDetails";
        } else {
            model.addAttribute("mesage", "Not found");
            return "listVehicles";
        }
    }

    @GetMapping("/add")
    public String formsAdd(Model model){
    model.addAttribute("vehicles", new VehicleDTO());
    return "addVehicle";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute VehicleDTO vehicle, RedirectAttributes redirectAttributes){
    vehicleService.addVehicle(vehicle);
    redirectAttributes.addFlashAttribute("message", "Sucefull registration");
    return "redirect:/vehicle/ui/list";
    }
}
