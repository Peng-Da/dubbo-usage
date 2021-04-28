package com.singerdream.textdetection.service;

import com.singerdream.textdetection.tables.daos.SensitiveWordDao;
import com.singerdream.textdetection.tables.pojos.SensitiveWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsoleService {

    @Autowired
    SensitiveWordDao sensitiveWordDao;

    public void create(SensitiveWord sw){
        sensitiveWordDao.insert(sw);
    }

    public void remove(long id){
        sensitiveWordDao.deleteById(id);
    }

    public void update(SensitiveWord s){
        sensitiveWordDao.update(s);
    }

    public List<SensitiveWord> select(){
        return  sensitiveWordDao.findAll();
    }
}
