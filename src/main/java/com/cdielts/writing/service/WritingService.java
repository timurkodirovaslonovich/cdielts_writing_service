package com.cdielts.writing.service;

import com.cdielts.writing.Dto.WritingRequestDto;
import com.cdielts.writing.Dto.WritingResponseDto;
import com.cdielts.writing.entity.Writing;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface WritingService {

    WritingResponseDto getWritingById(UUID uuid);

    List<WritingResponseDto> getAllWritings();

    WritingResponseDto addWriting(WritingRequestDto writing);

    ResponseEntity<String> deleteWritingById(UUID uuid);

    WritingResponseDto toDto(Writing writing);

}
