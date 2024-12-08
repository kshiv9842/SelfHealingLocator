package org.Shiv.API.response;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Content {
    private List<Part> parts;
    private String     role;
}