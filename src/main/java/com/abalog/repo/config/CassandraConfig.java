package com.abalog.repo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

import java.util.Collections;
import java.util.List;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("aba")
    private String keyspace;

    @Value("${cassandra.contactpoints}")
    private String contactPoints;

    @Value("1")
    private Integer replicationFactor;

    @Value("9042")
    private String port;

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(contactPoints);
        cluster.setPort(Integer.parseInt(port));
        cluster.setKeyspaceCreations(getKeyspaceCreations());
        return cluster;
    }

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification
                .createKeyspace(getKeyspaceName()).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication(replicationFactor));
    }
}
