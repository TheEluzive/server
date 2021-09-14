package org.example.http.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Part {
    private String type;
    private byte[] body;
}
