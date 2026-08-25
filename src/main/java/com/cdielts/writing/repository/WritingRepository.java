package com.cdielts.writing.repository;

import com.cdielts.writing.entity.Writing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WritingRepository extends JpaRepository<Writing, UUID> {
    List<Writing> findByUserId(UUID userId);

}
