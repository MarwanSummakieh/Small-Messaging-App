package com.example.sep3t3demo.controllers;

import com.example.sep3t3demo.res.Message;
import com.example.sep3t3demo.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sep3")
public class MessageController {
    @Autowired
    MessagesService service;

    @GetMapping("/getMessages")
    public ResponseEntity<List<Message>> getCustomerBy() {
        List<Message> messagesList = service.findAll();
        System.out.println("done");

        return new ResponseEntity<List<Message>>(messagesList, HttpStatus.OK);
    }
    @GetMapping("/getMessageBySenderName")
    public ResponseEntity<List<Message>> getMessageBySenderName(@RequestParam("sender") String sender) {
        List<Message> message = service.getMessagesBySenderName(sender);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("/getMessageByReceiverName")
    public ResponseEntity<List<Message>> getMessageByReceiverName(@RequestParam("receiver") String receiver) {
        List<Message> message = service.getMessagesByReceiver(receiver);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/postMessage")
    public String postCustomerById2(@RequestBody Message message) {
        Message msg = new Message(message.getSender(), message.getReceiver(), message.getBody());
        service.postMessage(message);
        return "Done";
    }

}
