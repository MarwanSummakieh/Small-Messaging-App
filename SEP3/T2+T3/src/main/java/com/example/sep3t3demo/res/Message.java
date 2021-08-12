package com.example.sep3t3demo.res;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sender",  nullable = false)
    private String sender;
    @Column(name = "receiver",  nullable = false)
    private String receiver;
    @Column(name = "body", length = 2000000)
    private String body;

    public Message() {

    }



    public Message(String sender, String reciever, String body) {

        this.sender = sender;
        this.receiver = reciever;
        this.body = body;
    }



    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String toString() {
        return "Owner [id=" + id + ", sender= " + sender + ", receiver= " + receiver + ", body= " + body + "]";
    }

}
