/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo.dao;

import com.alipay.henry.demo.model.GxyDO;
import org.apache.ibatis.annotations.*;


/**
 * @author Henry
 * @version $Id: GxyMapper.java, v 0.1 2018-07-31 上午9:53 Henry Exp $$
 */
@Mapper
public interface GxyMapper {

    @Insert("INSERT INTO gxy_tbl(id,gmt_create, gmt_modified,name,gender,birthday,ckdDate," +
            "gxy,tnb,gxg,sbp1,dbp1,sbp2,dbp2,sbp3,dbp3,dtxy,avgSsy,avgSzy,avgSsyDay,avgSzyDay," +
            "avgSsyNight,avgSzyNight,stdSsy,stdSzy,ndb,ndb24h,hasBloodN,nczRed,xhs,whiteCellCount," +
            "midCellCount,xxbCount,xj,xhdb,ipth,bloodG,bloodL,ctgs,xzcc, ivsFjg) VALUES(#{id},now(),now(),#{name}, #{gender}," +
            "#{birthday},#{ckdDate},#{gxy},#{tnb},#{gxg},#{sbp1},#{dbp1},#{sbp2},#{dbp2},#{sbp3},#{dbp3}," +
            "#{dtxy},#{avgSsy},#{avgSzy},#{avgSsyDay},#{avgSzyDay},#{avgSsyNight},#{avgSzyNight},#{stdSsy},#{stdSzy}," +
            "#{ndb},#{ndb24h},#{hasBloodN},#{nczRed},#{xhs},#{whiteCellCount},#{midCellCount},#{xxbCount}," +
            "#{xj},#{xhdb},#{ipth},#{bloodG},#{bloodL},#{ctgs},#{xzcc},#{ivsFjg})")
    int insert(GxyDO gxyDO);
    @Update("UPDATE user SET hobby=#{hobby} WHERE name=#{name}")
    void update(GxyDO gxyDO);
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
}