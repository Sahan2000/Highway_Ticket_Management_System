package lk.gdse.vehicleservice.service.impl;

import jakarta.transaction.Transactional;
import lk.gdse.vehicleservice.conversion.ConversionData;
import lk.gdse.vehicleservice.dto.VehicleDTO;
import lk.gdse.vehicleservice.entity.Vehicle;
import lk.gdse.vehicleservice.repository.VehicleServiceDao;
import lk.gdse.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final ConversionData conversionData;
    @Autowired
    private VehicleServiceDao vehicleServiceDao;
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleServiceDao.save(conversionData.mapTo(vehicleDTO, Vehicle.class));
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleServiceDao.existsById(vehicleDTO.getVehicleId())) {
            return;
        }
        vehicleServiceDao.save(conversionData.mapTo(vehicleDTO, Vehicle.class));
    }

    @Override
    public VehicleDTO getVehicle(String vehicleId) {
        return conversionData.mapTo(vehicleServiceDao.findById(vehicleId).get(), VehicleDTO.class);
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        vehicleServiceDao.deleteById(vehicleId);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return conversionData.mapTo(vehicleServiceDao.findAll(), VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getVehicleByUserId(String userId) {
        List<VehicleDTO> vehicleDTOs = new ArrayList<>();
        List<Vehicle> vehicles = vehicleServiceDao.findAllByUserId(userId);
        for (Vehicle vehicle : vehicles) {
            vehicleDTOs.add(conversionData.mapTo(vehicle, VehicleDTO.class));
        }
        return vehicleDTOs;
    }

    @Override
    public boolean isVehicleExists(String vehicleId) {
        return vehicleServiceDao.existsById(vehicleId);
    }
}
