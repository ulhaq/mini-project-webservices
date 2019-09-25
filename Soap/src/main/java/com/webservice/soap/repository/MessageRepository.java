package com.webservice.soap.repository;

import com.webservice.soap.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    @Query(value = "select count(id) from messages", nativeQuery = true)
    Long getCount();

}
