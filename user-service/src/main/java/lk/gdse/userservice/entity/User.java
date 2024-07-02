package lk.gdse.userservice.entity;

import jakarta.persistence.*;
import lk.gdse.userservice.ENUM.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private Role role;
}
