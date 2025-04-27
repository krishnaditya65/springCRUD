package com.example.demo.Repository;
import com.example.demo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<MyUser, Long>, JpaSpecificationExecutor<MyUser> {

}