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

    @Query("select u from UserModel u where u.userName like :name order by u.userName")
    List<UserModel> findUserByName(@Param("name") String name);

    @Modifying
    @Query("update UserModel u set u.password = :password where u.id = :id")
    void updateUser(@Param("password") String password, @Param("id") long id);

    @Modifying
    @Query("delete UserModel u where u.id = :id")
    void deleteUser(@Param("id") long id);

}



