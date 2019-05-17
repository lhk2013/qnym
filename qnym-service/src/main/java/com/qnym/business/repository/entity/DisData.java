package com.qnym.business.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by liuhaikuo on 2019-5-14 21:31:16
 *
 * @author liuhaikuo
 */
@Data
@Entity
@Table(name = "t_disdata")
public class DisData {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "dep_id")
    private Long depId;

    private String name;

}
