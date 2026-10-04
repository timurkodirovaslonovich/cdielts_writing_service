package com.cdielts.writing.entity;


import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "writing_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writing_id", nullable = false)
    private Writing writing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name = "answer_txt1", nullable = true)
    private String answerText1;


    @Column(name = "answer_txt2", nullable = true)
    private String answerText2;



    public Answer(Writing writing, User user, String answerText1, String answerText2) {
        this.writing = writing;
        this.user = user;
        this.answerText1 = answerText1;
        this.answerText2 = answerText2;
    }





    public String getAnswerText() {
        return answerText1 + answerText2;
    }

    public void setAnswerText1(String answerText1) {
        this.answerText1 = answerText1;
    }
    public void setAnswerText2(String answerText2) {
        this.answerText2 = answerText2;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Writing getWriting() {
        return writing;
    }

    public void setWriting(Writing writing) {
        this.writing = writing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}