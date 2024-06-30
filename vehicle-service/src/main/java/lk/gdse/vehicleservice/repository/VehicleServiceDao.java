package lk.gdse.vehicleservice.repository;

import lk.gdse.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleServiceDao extends JpaRepository<Vehicle, String> {
    List<Vehicle> findAllByUserId(String userId);
}
