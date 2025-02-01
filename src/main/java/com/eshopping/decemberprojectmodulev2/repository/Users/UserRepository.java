package com.eshopping.decemberprojectmodulev2.repository.Users;

import com.eshopping.decemberprojectmodulev2.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
