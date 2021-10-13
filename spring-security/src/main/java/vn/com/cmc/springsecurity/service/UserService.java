package vn.com.cmc.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.cmc.springsecurity.model.LoginRequestDto;
import vn.com.cmc.springsecurity.model.UserEntity;
import vn.com.cmc.springsecurity.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean checkLogin(LoginRequestDto loginRequestDto) {
        return userRepository.checkLogin(loginRequestDto.getUserName(), loginRequestDto.getPassWord());
    }

    public UserEntity findByUserName(String userName) {
        Optional<UserEntity> user = userRepository.findByUserName(userName);
        return user.get();
    }

}
