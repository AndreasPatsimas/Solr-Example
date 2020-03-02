package org.patsimas.solr.domain;

import lombok.*;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SolrDocument(collection = "employee")
public class Employee {

    @Id
    @Field
    private int id;

    @Field
    private String name;

    @Field
    private String email;
}
