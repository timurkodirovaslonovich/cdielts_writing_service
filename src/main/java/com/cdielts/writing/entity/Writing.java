package com.cdielts.writing.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Writing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "passage_1", nullable = false)
    private String passage1;

    @Column(name = "passage_2", nullable = false)
    private String passage2;

    @OneToMany(mappedBy = "writing")
    private List<WritingAnswer> answers = new ArrayList<>();

    public Writing(String passage1, String passage2, List<WritingAnswer> answers) {
        this.passage1 = passage1;
        this.passage2 = passage2;
        this.answers = answers;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getPassage1() {
        return passage1;
    }

    public void setPassage1(String passage1) {
        this.passage1 = passage1;
    }

    public String getPassage2() {
        return passage2;
    }

    public void setPassage2(String passage2) {
        this.passage2 = passage2;
    }

    public List<WritingAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<WritingAnswer> answers) {
        this.answers = answers;
    }
}