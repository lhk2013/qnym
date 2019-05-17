package com.qnym.business.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by liuhaikuo on 2019-5-14 20:31:16
 *
 * @author liuhaikuo
 */
@Data
@Entity
@Table(name = "t_disdata_case_detail_pic")
public class DisDataCaseDetailPic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "case_id")
    private Long caseDetailId;

    @Column(name = "accessery_name")
    private String accesseryName;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "pic_url")
    private String picUrl;

    private String url;

    private Integer status;

}
