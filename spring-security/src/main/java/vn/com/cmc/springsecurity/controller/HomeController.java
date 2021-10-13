package vn.com.cmc.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.cmc.springsecurity.model.LoginRequestDto;
import vn.com.cmc.springsecurity.security.JwtService;
import vn.com.cmc.springsecurity.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest")
public class HomeController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody LoginRequestDto user) {
        String result = "";
        HttpStatus httpStatus = null;
        try {
            if (userService.checkLogin(user)) {
                result = jwtService.generateTokenLogin(user.getUserName());
                httpStatus = HttpStatus.OK;
            } else {
                result = "Wrong userId and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception ex) {
            result = "Server Error";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<String>(result, httpStatus);
    }

    @GetMapping("/user")
    public ResponseEntity<String>  user() {
        return new ResponseEntity<>("User Page", HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String>  admin() {
        return new ResponseEntity<String>("Admin Page", HttpStatus.OK);
    }

}
