package com.cdielts.writing.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "writing_scores")
public class WritingScore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "writing_score", precision = 3, scale = 1)
    private BigDecimal writingScore;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "writing_answer_id",
            nullable = false,
            unique = true
    )
    private WritingAnswer writingAnswer;

    public WritingScore(BigDecimal writingScore, WritingAnswer writingAnswer) {
        this.writingScore = writingScore;
        this.writingAnswer = writingAnswer;
    }

    public BigDecimal getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(BigDecimal writingScore) {
        this.writingScore = writingScore;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public WritingAnswer getWritingAnswer() {
        return writingAnswer;
    }

    public void setWritingAnswer(WritingAnswer writingAnswer) {
        this.writingAnswer = writingAnswer;
    }
}