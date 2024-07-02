package lk.gdse.userservice.repository;

import lk.gdse.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceDao extends JpaRepository<User,String> {
    User findUserByEmail(String userName);
    User findFirstByOrderByUserIdDesc();
}
