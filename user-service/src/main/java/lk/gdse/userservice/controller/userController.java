package lk.gdse.userservice.controller;

import lk.gdse.userservice.dto.UserDTO;
import lk.gdse.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class userController {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(userController.class);
    @GetMapping("/health")
    public String health(){
        return "user service is running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        userService.saveUser(userDTO);
        return ResponseEntity.ok("user saved successfully");
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        userService.updateUser(userDTO);
        return ResponseEntity.ok("user updated successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable ("userId") String userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable ("userId") String userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("user deleted successfully");
    }

    @GetMapping("/userExists/{userId}")
    public ResponseEntity<?> isUserExists(@PathVariable String userId) {
        logger.info("Checking user existence with ID: {}", userId);
        try {
            boolean isUserExists = userService.isUserExists(userId);
            logger.info("User Exists: {}", isUserExists);
            return ResponseEntity.ok(isUserExists);
        } catch (Exception exception) {
            logger.error("Error checking user existence: ", exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error | Unable to check user existence.\nMore Details\n" + exception);
        }
    }
}
