package com.abalog.repo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemByProgramDTO {

    private String itemID;
    private Map<String, Object> value;

}
