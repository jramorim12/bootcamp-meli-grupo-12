package com.example.demo.repository;

import com.example.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query(value = "select * from user", nativeQuery = true)
    List<UserModel> findAll();

    @Query(value = "select * from user where user.id = :id", nativeQuery = true)
    UserModel findById(@Param("id") long id);

    @Query(value = "select * from user where user.user_name like :name order by user.user_name", nativeQuery = true)
    List<UserModel> findUserByName(@Param("name") String name);

    @Query(value = "insert into user value(password=:password, user_name = :name)", nativeQuery = true)
    UserModel save(@Param("password") String password, @Param("name") String name);

    @Modifying
    @Query(value = "update user set user.password = :password where user.id = :id", nativeQuery = true)
    void updateUser(@Param("password") String password, @Param("id") long id);

    @Modifying
    @Query(value = "delete from user where user.id = :id", nativeQuery = true)
    void deleteUser(@Param("id") long id);

}



