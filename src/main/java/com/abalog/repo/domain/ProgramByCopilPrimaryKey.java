package com.abalog.repo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyClass
public class ProgramByCopilPrimaryKey {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String copilid;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private String programid;

}
