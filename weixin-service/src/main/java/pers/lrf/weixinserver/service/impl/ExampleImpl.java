package pers.lrf.weixinserver.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.dao.Example;
import pers.lrf.weixinserver.service.interfaces.IExample;

/**
 * @author lirufeng
 * @date 2019/10/12 11:25
 **/
@Service
@Slf4j
public class ExampleImpl implements IExample {

    @Autowired
    private Example example;

    @Override
    public String getAuthorName() {
        log.info("测试日志");
        return example.getAuthorName();
    }
}
