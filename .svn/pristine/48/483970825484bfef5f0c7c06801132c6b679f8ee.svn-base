package com.newcapec.web.controller.person;

import com.newcapec.config.exception.CustomException;
import com.newcapec.dao.domain.Person;
import com.newcapec.dao.repository.person.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * @version V1.0
 * @Title: PersonController
 * @ClassName: com.newcapec.web.person.PersonController.java
 * @Description:
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-03-17 8:20
 */

@Api(value = "用户服务", description = "基本的用户增删改查API")
@Controller
@RequestMapping(value = "/users")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonRepository personRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @ApiOperation(value = "新建用户", notes = "根据Person对象创建用户")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Person person) {
        Person per = personRepository.saveAndFlush(person);
        logger.info("新建用户:{}", per);
        return per.toString();
    }


    @ApiOperation(value = "根据实体[Person]查询用户详细信息", notes = "根据实体[Person]查询用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
////            ,
////            @ApiImplicitParam(name = "person", value = "用户详细实体Person", required = true)
//    })
    @RequestMapping(value = "/findOne", method = RequestMethod.POST)
    @ResponseBody
    public Person findOne(@RequestBody Person person) {

        // 判断是否存在
        boolean isExists = personRepository.exists(Example.of(person));

        Person personRepositoryOne = null;

        if (isExists) {
            personRepositoryOne = personRepository.findOne(Example.of(person));
        }

        return personRepositoryOne;
    }


    @ApiOperation(value = "根据实体[Person]更新用户", notes = "根据实体[Person]更新用户")
    @RequestMapping(value = "/saveAndFlushOne", method = RequestMethod.POST)
    @ResponseBody
    public Person saveAndFlushOne(@RequestBody Person person) {

        Person personRepositoryOne = null;

        /**
         * 更新也是根据主键来更新  update XX  xx where id=1
         */
        personRepositoryOne = personRepository.saveAndFlush(person);

        return personRepositoryOne;
    }

    @ApiOperation(value = "用户详情页面", notes = "用户详情页面")
    @RequestMapping(value ="/detail", method = RequestMethod.GET)
    public String index(Model model) {
        Person single = new Person("弗兰克", 25,"加州");
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("贝多芬", 35,"德国");
        Person p2 = new Person("伽利略", 32,"意大利");
        Person p3 = new Person("拉里佩奇", 43,"美国");
        int money = 0;
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        model.addAttribute("money", money);
        return "/person/person";
    }


    /**
     * @Title:错误页面
     * @methodName: hello
     * @param
     * @return java.lang.String
     * @Description:
     *
     * @author: 王延飞
     * @date: 2017-03-29 8:34
     */
    @ApiOperation(value = "错误页面", notes = "错误页面")
    @RequestMapping("/errorPage")
    public String hello() throws Exception {

        throw new Exception("跳转到错误页面");
    }

    /**
     * @Title:自定义错误【JSON】
     * @methodName: json
     * @param
     * @return java.lang.String
     * @Description:
     *
     * @author: 王延飞
     * @date: 2017-03-29 8:13
     */
    @ApiOperation(value = "自定义错误【JSON】", notes = "自定义错误【JSON】")
    @RequestMapping("/errorJson")
    public String json() throws CustomException {

        throw new CustomException("发生自定义错误");
    }


    /**
     * @Title:  Spring 4和Java 8的时间与日期API
     * @methodName: getLocalDate
     * @param localDate
     * @return java.lang.String
     * @Description:  Spring4能接受一个字符串参数例如2014-02-01并将它转换成Java 8 LocalDate的实例
     *
     * @author: 王延飞
     * @date: 2017-05-18 10:04
     */
    @ApiOperation(value = "Spring 4和Java 8的时间与日期API", notes = "Spring4能接受一个字符串参数例如2014-02-01并将它转换成Java 8 LocalDate的实例")
    @RequestMapping("/date/{localDate}")
    @ResponseBody
    public String getLocalDate(@ApiParam("字符串参数例如2014-02-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate)
    {
        return localDate.toString();
    }

    /*@RequestMapping("/findByAddress")
    public List<Person> q1(String address) {
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/findByNameAndAddress")
    public Person q2(String name, String address) {
        Person people = personRepository.findByNameAndAddress(name, address);
        return people;
    }

    @RequestMapping("/withNameAndAddressQuery")
    public Person q3(String name, String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }


    @RequestMapping("/findAll")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page(int page, int size) {
        Page<Person> all = personRepository.findAll(new PageRequest(page, size));
        return all;
    }

    @RequestMapping("/all")
    public List<Person> all() {
        return personRepository.findAll();
    }*/


}
