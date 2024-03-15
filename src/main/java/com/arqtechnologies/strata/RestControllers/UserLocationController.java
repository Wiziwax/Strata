package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.UserDTOs.LocationRequest;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/userlocation")
public class UserLocationController {

    @Autowired
    private UserService userService;

    //TODO CONSTANTLY UPDATE USER'S LOCATION
    //TODO JUST GET THE ID FROM THE SIGNED IN USER

    //TODO MAKE USE OF WEBSOCKETS IN ORDER TO MAINTAIN CONSTANT CONNECTION

    //TODO RE-WATCH THE VIDEO ON YOUTUBE BY 'INTERVIEW PEN' CHANNEL ON HOW TO DO THIS RIGHT
    @PostMapping("update")
    public ResponseEntity<String> updateLocation(@RequestBody LocationRequest locationRequest) {
        userService.updateUserLocation(locationRequest);
        return ResponseEntity.ok("Location updated successfully");
    }
}
