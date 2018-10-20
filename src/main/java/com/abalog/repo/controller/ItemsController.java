package com.abalog.repo.controller;


import com.abalog.repo.dto.ItemByProgramDTO;
import com.abalog.repo.service.ItemsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/data")
@Api(tags = "Repository data")
@Slf4j
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping("/{programid}/{itemid}")
    public ResponseEntity<Map<String, Object>> findOne(@PathVariable String programid, @PathVariable String itemid) {

        ItemByProgramDTO dto = itemsService.findOne(programid, itemid);
        return ResponseEntity.ok().header("heeeeeader")
                .body(dto.getValue());
    }

    @GetMapping("/{programid}")
    public List<ItemByProgramDTO> findItemsByProgram(@PathVariable String programid) {
        return itemsService.findAll(programid);
    }

    @PutMapping("/{programid}/{itemid}")
    public ResponseEntity<String> save(@PathVariable String programid, @PathVariable String itemid,
                                       @RequestBody @Valid Map<String, Object> payload) {
        ItemByProgramDTO dto = ItemByProgramDTO.builder().itemID(itemid).value(payload).build();
        dto = itemsService.saveOne(programid, itemid, dto);
        return ResponseEntity.ok().body("itemsController OK");
    }


}
