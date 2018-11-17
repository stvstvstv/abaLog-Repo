package com.abalog.repo.controller;


import com.abalog.repo.dto.ItemByProgramDTO;
import com.abalog.repo.dto.ItemUpdateResponseDTO;
import com.abalog.repo.service.ItemByProgramService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/items")
@Api(tags = "Repository Items data")
@Slf4j
public class ItemsController {

    @Autowired
	private ItemByProgramService itemByProgramService;

    @GetMapping("/{programid}/{itemid}")
    public ResponseEntity<Map<String, Object>> findOne(@PathVariable String programid, @PathVariable String itemid) {

		ItemByProgramDTO dto = itemByProgramService.findOne(programid, itemid);
        if (dto == null) {
            return ResponseEntity.noContent().header("NUUUUU").build();
        } else {
            return ResponseEntity.ok().header("heeeeeader")
                    .body(dto.getValue());
        }
    }
    @GetMapping("/{programid}")
    public List<ItemByProgramDTO> findItemsByProgram(@PathVariable String programid) {
		return itemByProgramService.findAll(programid);
    }

    @PutMapping("/{programid}/{itemid}")
    public ResponseEntity<String> save(@PathVariable String programid, @PathVariable String itemid,
                                       @RequestBody @Valid Map<String, Object> payload) {

        ItemByProgramDTO itemDTO = ItemByProgramDTO.builder().itemID(itemid).value(payload).build();
		itemByProgramService.saveOne(programid, itemDTO);
        return ResponseEntity.ok().header("Insert Worked").body("Insert worked body");
    }

    @PutMapping("/{programid}")
    public ResponseEntity<List<ItemUpdateResponseDTO>> saveBulk(@PathVariable String programid,
                                                                @RequestBody @Valid List<ItemByProgramDTO> itemDTOList) {

		return ResponseEntity.ok().body(itemByProgramService.saveBulk(programid, itemDTOList));
    }

    @DeleteMapping("/{programid}/{itemid}")
    public ResponseEntity<String> deleteOne(@PathVariable String programid, @PathVariable String itemid) {
		itemByProgramService.deleteOne(programid, itemid);
        return ResponseEntity.ok().body("OK");
    }


}
