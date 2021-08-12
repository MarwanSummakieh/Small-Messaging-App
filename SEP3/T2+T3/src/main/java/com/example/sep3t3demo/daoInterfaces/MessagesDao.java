package com.example.sep3t3demo.daoInterfaces;

import com.example.sep3t3demo.res.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessagesDao extends CrudRepository<Message, Integer> {
    List<Message> findAll();
    List<Message> findBySender(String sender);
    List<Message> findByReceiver(String receiver);
}
