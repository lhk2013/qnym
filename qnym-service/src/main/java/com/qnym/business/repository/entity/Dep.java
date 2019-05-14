package com.qnym.business.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by liuhaikuo on 2018-10-22 21:31:16
 *
 * @author liuhaikuo
 */
@Data
@Entity
@Table(name = "t_dep")
public class Dep {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "dep_name")
    private String depName;

    private String data_msg;

    private Long pid;

    private Integer level;

}
