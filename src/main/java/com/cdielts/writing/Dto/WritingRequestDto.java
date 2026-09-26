package com.cdielts.writing.Dto;


import com.cdielts.writing.entity.WritingAnswer;
import lombok.Data;

import java.util.List;

@Data
public class WritingRequestDto {

    private final String passage1;
    private final String passage2;
    private final List<WritingAnswer> answers;

}
