package lk.gdse.vehicleservice.repository;

import lk.gdse.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehicleServiceDao extends JpaRepository<Vehicle, String> {
    List<Vehicle> findAllByUserId(String userId);
    Vehicle findFirstByOrderByVehicleIdDesc();
}
