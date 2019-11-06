package com.grocerylist.remote;

import com.grocerylist.remote.dto.LoginDataDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
@RequestMapping(value = "/api/v1")
@RestController
public class SignUpController {

    //TODO move to core/controller module

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody LoginDataDto loginDataDto) {
        System.out.println(loginDataDto.getPassword() + "\n" + loginDataDto.getUserName());
        if (loginDataDto.getRetriedPassword().equals(loginDataDto.getPassword())) {
            return new ResponseEntity("Usser succesfully added", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Something goes wrong", HttpStatus.UNAUTHORIZED);
        }
    }

}
