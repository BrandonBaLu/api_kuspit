package com.itf.kuspit.repositories;


import com.itf.kuspit.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IUserRepository extends JpaRepository<UserModel, Long> {

}
