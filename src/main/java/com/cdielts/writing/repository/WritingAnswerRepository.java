package com.cdielts.writing.repository;

import com.cdielts.writing.entity.WritingAnswer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingAnswerRepository extends JpaRepository<WritingAnswer, UUID> {
}
