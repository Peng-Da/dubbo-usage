package com.singerdream.comment.dao;

import com.singerdream.comment.tables.daos.CommentDao;
import com.singerdream.comment.tables.records.CommentRecord;
import org.jooq.Condition;
import org.jooq.Configuration;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentCustomDao extends CommentDao {

    /**
     *  jooq fetch的record是关联configuration的，new的record需要attach configuration才能执行sql操作
     */

    //父类注入了configuration bean， 继承父类构造器
    public CommentCustomDao(Configuration configuration) {
        super(configuration);
    }

    public CommentRecord insert(CommentRecord detachedRecord){
        detachedRecord.attach(configuration());
        detachedRecord.insert();
        detachedRecord.detach();
        return detachedRecord;
    }

    public List<CommentRecord> fetchByCondition(Condition condition){
        return DSL.using(configuration()).fetch(getTable(),condition);
    }
}
