package com.abalog.repo.service;

import com.abalog.repo.domain.ItemByProgram;
import com.abalog.repo.dto.ItemByProgramDTOMapper;
import com.abalog.repo.dto.ItemByProgramDTO;
import com.abalog.repo.repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemsService {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    ItemByProgramDTOMapper mapper;

    public final ItemByProgramDTO findOne(String programid, String itemid){
        return mapper.fromItem(itemsRepository.findOne(programid,itemid));
    }

    public final List<ItemByProgramDTO> findAll(String programid){
        return itemsRepository.findAllByProgram(programid).stream()
                .map(item -> mapper.fromItem(item))
                .collect(Collectors.toList());
    }

    public final ItemByProgramDTO saveOne(String programid, String itemid, ItemByProgramDTO itemDTO){
        ItemByProgram itemByProgram = mapper.toItem(itemDTO,programid,itemid);
        itemsRepository.save(itemByProgram);
        return itemDTO;
    }


}
