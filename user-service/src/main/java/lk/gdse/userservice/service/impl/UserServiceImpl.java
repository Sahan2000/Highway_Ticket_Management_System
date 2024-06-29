package lk.gdse.userservice.service.impl;

import jakarta.transaction.Transactional;
import lk.gdse.userservice.conversion.ConversionData;
import lk.gdse.userservice.dto.UserDTO;
import lk.gdse.userservice.entity.User;
import lk.gdse.userservice.repository.UserServiceDao;
import lk.gdse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private ConversionData conversionData;
    @Autowired
    private UserServiceDao userServiceDao;
    @Override
    public void saveUser(UserDTO userDTO) {
        userServiceDao.save(conversionData.mapTo(userDTO, User.class));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if(!userServiceDao.existsById(userDTO.getUserId())){
            return;
        }
        userServiceDao.save(conversionData.mapTo(userDTO, User.class));
    }

    @Override
    public UserDTO getUser(String userId) {
        if (!userServiceDao.existsById(userId)) {
            return null;
        }
        return conversionData.mapTo(userServiceDao.findById(userId).get(), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return conversionData.mapTo(userServiceDao.findAll(), UserDTO.class);
    }

    @Override
    public void deleteUser(String userId) {
        userServiceDao.deleteById(userId);
    }
}
