package com.cdielts.writing.Dto;


import lombok.Data;

import java.util.UUID;

@Data
public class WritingResponseDto {

    private final UUID uuid;
    private final String passage1;
    private final String passage2;

}
