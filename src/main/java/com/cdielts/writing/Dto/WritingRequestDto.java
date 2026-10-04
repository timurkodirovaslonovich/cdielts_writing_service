package com.cdielts.writing.Dto;


import com.cdielts.writing.entity.Answer;
import lombok.Data;

import java.util.List;

@Data
public class WritingRequestDto {

    private final String passage1;
    private final String passage2;

    public WritingRequestDto(String passage2, String passage1) {
        this.passage2 = passage2;
        this.passage1 = passage1;
    }
}
