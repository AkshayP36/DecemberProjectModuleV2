package com.eshopping.decemberprojectmodulev2.services.Users;

import com.eshopping.decemberprojectmodulev2.models.User.Address;
import com.eshopping.decemberprojectmodulev2.models.User.Name;
import com.eshopping.decemberprojectmodulev2.models.User.User;

public interface UserService {

    User getAUser(Long id);
    User[] getAllUsers();
    User createAUser(String email, String username, Name name, Address address, String phone);
    User deleteAUser(Long id);
    User updateAUser(Long id, String email, String username, String phone);
}
