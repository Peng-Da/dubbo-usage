package com.singerdream.textdetection.service;

import com.singerdream.textdetection.Helper;
import com.singerdream.textdetection.api.TextDetectionInterface;
import com.singerdream.textdetection.tables.daos.SensitiveWordDao;
import com.singerdream.textdetection.tables.pojos.SensitiveWord;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DubboService
public class TextDetectionServiceImp implements TextDetectionInterface {

    @Autowired
    SensitiveWordDao sensitiveWordDao;

    @Override
    public boolean containsSensitiveWords(String s) {
        List<SensitiveWord> words=sensitiveWordDao.findAll();
        Map<String,Map> map= Helper.addSensitiveWordToHashMap(words.stream()
                .map(SensitiveWord::getContent).collect(Collectors.toList()));
        return Helper.isContaintSensitiveWord(s,map);
    }

    @Override
    public String replaceSensitive(String s, String s1) {
        List<SensitiveWord> words=sensitiveWordDao.findAll();
        Map<String,Map> map= Helper.addSensitiveWordToHashMap(words.stream()
                .map(SensitiveWord::getContent).collect(Collectors.toList()));

        return Helper.excludeWhiteWordAndReplaceSensitive(s,"*",new HashMap(),map);
    }

    @Override
    public String[] checkoutSensitive(String s) {
        return new String[0];
    }


}
