package lk.gdse.vehicleservice.controller;

import lk.gdse.vehicleservice.dto.VehicleDTO;
import lk.gdse.vehicleservice.service.UserServiceClient;
import lk.gdse.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController {
    @Autowired
    private UserServiceClient userServiceClient;
    @Autowired
    private VehicleService vehicleService;
    @GetMapping("/health")
    public String health(){
        return "Vehicle Service is healthy";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO vehicleDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (!userServiceClient.isExitsUser(vehicleDTO.getUserId())) {
            return ResponseEntity.badRequest().body("User not found");
        }
        vehicleService.saveVehicle(vehicleDTO);
        return ResponseEntity.ok("Vehicle saved successfully");
    }

    @PutMapping()
    public ResponseEntity<?> updateVehicle(@RequestBody VehicleDTO vehicleDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        vehicleService.updateVehicle(vehicleDTO);
        return ResponseEntity.ok("Vehicle updated successfully");
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<?> getVehicle(@PathVariable ("vehicleId") String vehicleId){
        return ResponseEntity.ok(vehicleService.getVehicle(vehicleId));
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(@PathVariable ("vehicleId") String vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getVehiclesByUserId(@PathVariable ("userId") String userId){
        return ResponseEntity.ok(vehicleService.getVehicleByUserId(userId));
    }
}
