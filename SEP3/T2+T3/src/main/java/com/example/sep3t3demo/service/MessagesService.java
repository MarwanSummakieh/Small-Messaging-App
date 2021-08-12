package com.example.sep3t3demo.service;

import com.example.sep3t3demo.res.Message;
import com.example.sep3t3demo.daoInterfaces.MessagesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {

    @Autowired
    MessagesDao dao;

    public List<Message> findAll() {
        return dao.findAll();
    }

    public void postMessage(Message messages) {
        dao.save(messages);
    }

    public List<Message> getMessagesByReceiver(String receiver) {
        List<Message> message = dao.findByReceiver(receiver);

        return message;
    }

    public List<Message> getMessagesBySenderName(String sender) {
        List<Message> message = dao.findBySender(sender);

        return message;
    }
}
