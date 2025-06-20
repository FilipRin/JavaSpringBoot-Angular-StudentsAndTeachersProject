package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest loginRequest){
        //System.out.println("Login request : username : "+loginRequest.getKorisnickoIme()+" password : "+loginRequest.getLozinka()+" tip : "+loginRequest.getTip());
        Optional<User> user =  userRepository.findByKorisnickoImeAndTip(loginRequest.getKorisnickoIme(), loginRequest.getTip());
        //System.out.println("User : "+user);
        if(user.isPresent()){
            //System.out.println("User : "+user);
            if(user.get().getLozinka().equals(loginRequest.getLozinka())){
                return new LoginResponse("Login successful", true, user.get());
            }
        }
        else{
            System.out.println("User nije pronadjen");
        }
        return new LoginResponse("Login failed", false, null);

    }


}
