package com.cdielts.writing.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "writing_scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "writing_score", precision = 3, scale = 1)
    private BigDecimal overall;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "writing_answer_id",
            nullable = false,
            unique = true
    )
    private Answer answer;

    public Score(BigDecimal writingScore, Answer answer) {
        this.overall = writingScore;
        this.answer = answer;
    }

    public BigDecimal getWritingScore() {
        return overall;
    }

    public void setWritingScore(BigDecimal writingScore) {
        this.overall = writingScore;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Answer getWritingAnswer() {
        return answer;
    }

    public void setWritingAnswer(Answer answer) {
        this.answer = answer;
    }
}