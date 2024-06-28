package lk.gdse.userservice.repository;

import lk.gdse.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceDao extends JpaRepository<User,String> {
}
