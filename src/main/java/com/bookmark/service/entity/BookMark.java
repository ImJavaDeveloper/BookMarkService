package com.bookmark.service.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection ="bookmarkData")
@Data
public class BookMark implements Serializable {

    @Override
    public String toString() {
        return "BookMark{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", company='" + company + '\'' +
                ", state='" + state + '\'' +
                ", dateRecieved=" + dateRecieved +
                ", issue='" + issue + '\'' +
                '}';
    }

    @Id
    private String id;
    private String complaintId;
    private String product;
    private String company;
    private String state;
    private Date dateRecieved;
    private String issue;

}
