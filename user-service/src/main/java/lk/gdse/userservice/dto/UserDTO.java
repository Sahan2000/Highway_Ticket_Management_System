package lk.gdse.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lk.gdse.userservice.ENUM.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    @Null(message = "Id generate by  program")
    private String userId;
    @NotNull(message = "Name cannot be null")
    private String userName;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
    @NotBlank(message = "User role name cannot be blank")
    private Role role;
}
