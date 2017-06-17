package com.newcapec.dao.repository.person.custom;

import com.newcapec.dao.domain.Person;

import java.util.List;

/**
 * @Title:
 * @ClassName: com.newcapec.dao.repository.person.custom.PersonRepositoryCustom.java
 * @Description:
 *
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-03-19 18:07
 * @version V1.0
 */
public interface PersonRepositoryCustom {

    public List<Person> searchName(String name);

    public void insertByPreparedStatement();
}
