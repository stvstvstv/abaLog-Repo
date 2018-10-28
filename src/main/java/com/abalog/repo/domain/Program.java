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
public class Program {

    //TODO: add copilID si foloseste @PrimaryKeyClass sau ceva

    @PrimaryKey
    private String programid;

    private Boolean mastered;

    private String name;

}
