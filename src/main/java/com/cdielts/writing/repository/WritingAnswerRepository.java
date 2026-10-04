package com.cdielts.writing.repository;

import com.cdielts.writing.entity.Answer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingAnswerRepository extends JpaRepository<Answer, UUID> {
}
