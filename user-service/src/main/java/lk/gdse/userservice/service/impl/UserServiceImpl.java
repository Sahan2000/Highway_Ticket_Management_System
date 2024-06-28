package lk.gdse.userservice.service.impl;

import jakarta.transaction.Transactional;
import lk.gdse.userservice.conversion.ConversionData;
import lk.gdse.userservice.dto.UserDTO;
import lk.gdse.userservice.entity.User;
import lk.gdse.userservice.repository.UserServiceDao;
import lk.gdse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private ConversionData conversionData;
    @Autowired
    private UserServiceDao userServiceDao;
    @Override
    public void saveUser(UserDTO userDTO) {
        User user = conversionData.mapTo(userDTO, User.class);
        userServiceDao.save(user);
    }
}
