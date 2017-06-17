package com.newcapec.dao.repository.person.custom.impl;

import com.newcapec.dao.domain.Person;
import com.newcapec.dao.repository.base.BaseRepository;
import com.newcapec.dao.repository.person.custom.PersonRepositoryCustom;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @ClassName: com.newcapec.dao.repository.person.custom.impl.PersonRepositoryImpl.java
 * @Description:
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-03-19 18:07
 */
public class PersonRepositoryImpl extends BaseRepository implements PersonRepositoryCustom {


    @Override
    public List<Person> searchName(String name) {


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.where(builder.like(root.<String>get("name"), "%" + name + "%"));
        return entityManager.createQuery(query.select(root)).getResultList();
    }



    /**
     * @Title: 批量查询
     * @methodName:  insertByPreparedStatement
     * @param
     * @return void
     * @Description:
     *
     * @author: 王延飞
     * @date:  2017-06-12 8:20
     */
    @Override
    @Transactional
    public void insertByPreparedStatement() {

        // 获取session
        SessionImplementor session = entityManager.unwrap(SessionImplementor.class);
        Connection conn = session.connection();
        PreparedStatement ps = null;
        ResultSet rs=null;
        // String sql = "INSERT INTO person (name,age,address) VALUES (?,?,?)";
        // sql前缀
        String prefix = "INSERT INTO person (name,age,address) VALUES ";

        try {
            /*ps = conn.prepareStatement(sql);
            //对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值。
            ps.setString(1, "苗苗2");
            ps.setString(2, "25");
            ps.setString(3, "河南许昌");
            ps.executeUpdate();*/


            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // Statement st = conn.createStatement();
            // 比起st，pst会更好些
            PreparedStatement pst = conn.prepareStatement("");
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 3; i++) {
                // 第次提交步长
                for (int j = 1; j <= 10; j++) {
                    // 构建sql后缀
                    suffix.append("("+"'小王',"+i*j+",'河南郑州'"+ "),");
                }
                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行sql
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            //conn.close();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }




}
