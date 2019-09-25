package com.webservice.soap.repository;

import com.webservice.soap.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "select count(id) from students", nativeQuery = true)
    Long getCount();

}
