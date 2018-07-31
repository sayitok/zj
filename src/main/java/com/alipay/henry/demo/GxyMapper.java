/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo;

import com.alipay.henry.demo.model.GxyDO;

/**
 * @author Henry
 * @version $Id: GxyMapper.java, v 0.1 2018-07-31 上午9:53 Henry Exp $$
 */
@Mapper
public interface GxyMapper {

    @Insert("INSERT INTO user(name, hobby) VALUES(#{name}, #{hobby})")
    int insert(@Param("name") String name, @Param("hobby") String hobby);
    @Update("UPDATE user SET hobby=#{hobby} WHERE name=#{name}")
    void update(GxyDO gxyDO);
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
}