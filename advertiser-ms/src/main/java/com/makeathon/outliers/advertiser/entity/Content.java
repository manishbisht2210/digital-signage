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
import javax.persistence.ManyToOne;

@Data
@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String location;

    @Column
    private String contentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertiser_id", nullable = false)
    private Advertiser advertiser;

}
