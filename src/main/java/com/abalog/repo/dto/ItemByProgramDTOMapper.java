package com.abalog.repo.dto;


import com.abalog.repo.domain.ItemByProgram;
import com.abalog.repo.domain.ItemByProgramPrimaryKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Slf4j
@Component
public class ItemByProgramDTOMapper {

    @Autowired
    private ObjectMapper objectMapper;

    @SuppressWarnings("unchecked")
    public ItemByProgramDTO fromItem(ItemByProgram itemByProgram) {
        if (itemByProgram == null) {
            return null;
        } else try {
            return ItemByProgramDTO.builder()
                    .value(objectMapper.readValue(itemByProgram.getValue(), Map.class)).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public ItemByProgram toItem(ItemByProgramDTO dto, String proiectid, String itemid) {
        if (dto == null) {
            return null;
        } else try {
            return ItemByProgram.builder()
                    .primaryKey(ItemByProgramPrimaryKey.builder()
                            .programid(proiectid).itemid(itemid).build())
                    .value(objectMapper.writeValueAsString(dto.getValue()))
                    .build();
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return null;
        }

    }


}
