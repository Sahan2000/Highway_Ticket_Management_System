package lk.gdse.vehicleservice.service;

import lk.gdse.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    void updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getVehicle(String vehicleId);
    void deleteVehicle(String vehicleId);
    List<VehicleDTO> getAllVehicles();
    List<VehicleDTO> getVehicleByUserId(String userId);
}
