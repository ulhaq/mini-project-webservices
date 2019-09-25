package com.webservice.soap.repository;

import com.webservice.soap.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query(value = "select count(id) from comments", nativeQuery = true)
    Long getCount();

}