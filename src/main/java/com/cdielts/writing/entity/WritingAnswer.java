package com.cdielts.writing.entity;


import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "writing_answer")
public class WritingAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writing_id", nullable = false)
    private Writing writing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(name = "answer_txt", nullable = true)
    private String answerText;






    public WritingAnswer(Writing writing, User user, String answerText) {
        this.writing = writing;
        this.user = user;
        this.answerText = answerText;
    }





    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
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