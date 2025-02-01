package com.eshopping.decemberprojectmodulev2.services.Users;

import com.eshopping.decemberprojectmodulev2.models.User.User;
import com.eshopping.decemberprojectmodulev2.repository.Users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("selfUserService")
public class SelfUserService implements UserService{

    UserRepository userRepository;

    public SelfUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getAUser(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
    public User[] getAllUsers(){
        List<User> userList = userRepository.findAll();
        User[] response = new User[userList.size()];
        for(int i=0;i<userList.size(); i++){
            response[i] = userList.get(i);
        }
        return response;
    }
    public User createAUser(String email, String username, String phone){
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPhone(phone);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setDeleted(false);
        return userRepository.save(user);
    }
    public User deleteAUser(Long id){
        Optional<User> res = userRepository.findById(id);
        if(res.isPresent()){
            userRepository.delete(res.get());
            return res.get();
        }
        return null;
    }
    public User updateAUser(Long id, String email, String username, String phone){
        Optional<User> res = userRepository.findById(id);
        if(res.isPresent()){
            User user = new User();
            user.setId(id);
            user.setEmail(email);
            user.setUsername(username);
            user.setPhone(phone);
            user.setUpdatedAt(new Date());
            return userRepository.save(user);
        }
        return null;
    }
}
