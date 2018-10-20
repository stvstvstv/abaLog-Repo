package com.abalog.repo.domain;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ItemByProgram {

    @PrimaryKey
    private ItemByProgramPrimaryKey primaryKey;

    private String value;
}
