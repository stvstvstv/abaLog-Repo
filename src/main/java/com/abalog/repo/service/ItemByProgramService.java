package com.abalog.repo.service;

import com.abalog.repo.domain.ItemByProgram;
import com.abalog.repo.domain.ItemByProgramPrimaryKey;
import com.abalog.repo.dto.ItemByProgramDTO;
import com.abalog.repo.dto.ItemByProgramDTOMapper;
import com.abalog.repo.dto.ItemUpdateResponseDTO;
import com.abalog.repo.repository.ItemByProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemByProgramService {

    @Autowired
    ItemByProgramRepository itemByProgramRepository;

    @Autowired
    ItemByProgramDTOMapper mapper;

    public final ItemByProgramDTO findOne(String programid, String itemid) {

        return mapper.fromItem(itemByProgramRepository.findOne(programid, itemid));
    }

    public final List<ItemByProgramDTO> findAll(String programid) {
        return itemByProgramRepository.findAllByProgram(programid).stream()
                .map(item -> mapper.fromItem(item))
                .collect(Collectors.toList());
    }

    public final ItemByProgramDTO saveOne(String programid, ItemByProgramDTO itemDTO) {
        ItemByProgram itemByProgram = mapper.toItem(itemDTO, programid);
//        itemByProgramRepository.save(itemByProgram);
        itemByProgramRepository.saveBatch(itemByProgram);
        return itemDTO;
    }


    public final List<ItemUpdateResponseDTO> saveBulk(String programid, List<ItemByProgramDTO> itemDTOList) {

        return itemDTOList.stream().map(item -> {
            ItemUpdateResponseDTO entry;
            entry = ItemUpdateResponseDTO.builder().id(item.getItemID()).build();
            try {
                saveOne(programid, item);

            } catch (Exception e) {
                entry.setErrorMessage(e.getMessage());
            }
            return entry;
        }).collect(Collectors.toList());

    }

    public void deleteOne(String programid, String itemid) {
        itemByProgramRepository.delete(ItemByProgram.builder()
                .primaryKey(ItemByProgramPrimaryKey.builder().itemid(itemid).programid(programid).build())
                .build());
    }
}
