package com.cdielts.writing.service;

import com.cdielts.writing.Dto.WritingRequestDto;
import com.cdielts.writing.Dto.WritingResponseDto;
import com.cdielts.writing.entity.Writing;
import com.cdielts.writing.repository.WritingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class WritingServiceImpl implements WritingService{

    private final WritingRepository writingRepository;


    @Override
    public WritingResponseDto getWritingById(UUID uuid) {
        return writingRepository.findById(uuid).map(this::toDto).orElseThrow(() ->
                new NoSuchElementException("User with id " + uuid + " not found")
        );
    }

    @Override
    public List<WritingResponseDto> getAllWritings() {
        return writingRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public WritingResponseDto addWriting(WritingRequestDto writing) {
        Writing newWriting = new Writing(
                writing.getPassage1(),
                writing.getPassage2()
        );
        return null;
    }

    @Override
    public ResponseEntity<String> deleteWritingById(UUID uuid) {
        return null;
    }

    @Override
    public WritingResponseDto toDto(Writing writing) {
        return new WritingResponseDto(
                writing.getUuid(),
                writing.getPassage1(),
                writing.getPassage2()
        );
    }
}
