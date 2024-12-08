package org.Shiv.API.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Candidate {
    private Content content;
    private String finishReason;
    private int index;
}