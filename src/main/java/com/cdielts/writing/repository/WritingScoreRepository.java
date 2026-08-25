package com.cdielts.writing.repository;
import java.util.UUID;

import com.cdielts.writing.entity.WritingScore;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WritingScoreRepository extends JpaRepository<WritingScore, UUID> {

}
