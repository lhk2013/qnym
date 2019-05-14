package com.qnym.business.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by liuhaikuo on 2019-5-14 20:31:16
 *
 * @author liuhaikuo
 */
@Data
@Entity
@Table(name = "t_disdata_case")
public class DisDataCase {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "disdata_id")
    private String disdataId;

    @Column(name = "key_words")
    private String keyWords;

    private String remark;

    @Column(name = "case_label")
    private String caseLabel;

    @Column(name = "read_num")
    private String readNum;

    private String guid;

    private String bingshi;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "praise_num")
    private String praiseNum;

    @Column(name = "pl_num")
    private String plNum;


}
