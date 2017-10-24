package com.qnym.business.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * Created by liuhaikuo on 2017/10/24.
 */
@Data
@Entity
@Table(name = "t_id_card")
public class IDCard {


    @Id
    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "real_name")
    private String realName;

    /**
     * 身份证状态
     */
    private Integer status;
}
