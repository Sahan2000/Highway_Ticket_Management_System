package lk.gdse.vehicleservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    @Null(message = "Id generate by  program")
    private String vehicleId;
    @NotNull(message = "licence plate cannot be a null")
    private String licencePlate;
    @NotNull(message = "model cannot be a null")
    private String model;
    @NotNull(message = "brand cannot be a null")
    private String brand;
    @NotNull(message = "userId cannot be a null")
    private String userId;
}
