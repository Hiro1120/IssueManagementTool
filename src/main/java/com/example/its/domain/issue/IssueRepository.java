package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//MyBatisのアノテーション（DBと接続）
public interface IssueRepository {

    @Select("SELECT * FROM issues")
    List<IssueEntity> findAll();
    @Insert("insert into issues (summary, description) values (#{summary},#{description})")//#{}Mybatisの記法
    void insert(String summary, String description);
}
