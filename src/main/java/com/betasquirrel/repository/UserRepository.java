package com.betasquirrel.repository;

import com.betasquirrel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query("update User user set user.name=:name, user.password=:password, user.mobile=:mobile where user.id=:id")
    void updateUser(@Param("name") String name, @Param("password") String password,
                    @Param("mobile") String mobile, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("update User user set user.token=:token where user.email=:email")
    void updateToken(@Param("token") String token, @Param("email") String email);

    User findByEmail(String email);

    User findByEmailAndToken(String email, String token);

}
