package com.qnym.business.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuhaikuo on 2018-10-22 21:31:16
 *
 * @author liuhaikuo
 */
@Data
@Entity
@Table(name = "t_ex_user")
public class ExUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mob;

    private String name;

    private String area;

    private String result;
}
