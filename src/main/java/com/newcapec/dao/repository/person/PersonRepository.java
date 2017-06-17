package com.newcapec.dao.repository.person;

import com.newcapec.dao.domain.Person;
import com.newcapec.dao.domain.PersonDTO;
import com.newcapec.dao.repository.person.custom.PersonRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Title:
 * @ClassName: org.sang.PersonRepository.java
 * @Description:
 *
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-03-16 8:43
 * @version V1.0
 */
public interface PersonRepository extends JpaRepository<Person, Long>,PersonRepositoryCustom {


    // List<Person> findByAddress(String address);

    // Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);



    @Query("select new com.newcapec.dao.domain.PersonDTO(p.name,p.address) from Person p group by p.name")
	public List<PersonDTO> findCountGroupByName();


}
