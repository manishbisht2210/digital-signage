package com.makeathone.outliers.booking.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Advertiser {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "content_id")
//    private List<Content> contentList;

}
