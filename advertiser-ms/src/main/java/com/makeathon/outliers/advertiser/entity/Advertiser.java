package com.makeathon.outliers.advertiser.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

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
