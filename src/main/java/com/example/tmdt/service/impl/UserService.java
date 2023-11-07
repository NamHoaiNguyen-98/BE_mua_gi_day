package com.example.tmdt.service.impl;

import com.example.tmdt.dto.UserDTO;
import com.example.tmdt.model.User;
import com.example.tmdt.repository.UserRepository;
import com.example.tmdt.security.model.Account;
import com.example.tmdt.security.repository.IAccountRepository;
import com.example.tmdt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
   private UserRepository userRepository ;
    @Autowired
   private IAccountRepository accountRepository ;



    @Override
    public List<String> listNameEmail() {
        List<String> email = new ArrayList<>() ;
        Iterable<User> userList = userRepository.findAll() ;
        for (User user: userList
             ) {
                email.add(user.getEmail());
        }
        return email;
    }

    @Override
    public List<String> listNameUser() {
        List<String> acc = new ArrayList<>() ;
        Iterable<Account> userList = accountRepository.findAll() ;
        for (Account user: userList
        ) {
            acc.add(user.getUsername());
        }
        return acc;
    }

    @Override
    public void save(UserDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDTO findOne(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }
}
