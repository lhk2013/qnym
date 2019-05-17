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
@Table(name = "t_disdata_case_detail")
public class DisDataCaseDetail {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "case_id")
    private Long caseId;

    private String recommend;

    private String data;

    @Column(name = "share_url")
    private String shareUrl;


    @Column(name = "html_content")
    private String htmlContent;


    private String result;

}
