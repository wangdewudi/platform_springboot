package com.wcxy.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcxy.platform.Mapper.LabelMapper;
import com.wcxy.platform.entity.Message;
import com.wcxy.platform.entity.Messagelabel;
import com.wcxy.platform.service.MessagelabelService;
import com.wcxy.platform.tools.Getpage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class MessagelabelServiceImpl implements MessagelabelService {

    @Autowired
    private LabelMapper mapper;

    private Messagelabel messagelabel;

    @Override
    public void insert(Messagelabel record) {
        mapper.insert(record);

    }

    @Override
    public void update(Messagelabel record) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Messagelabel> getList( String msgId) {
        messagelabel =new Messagelabel();
        messagelabel.setMsgId(msgId);
        return mapper.select(messagelabel);
    }

    @Override
    public List<Messagelabel> getMsgId(String schoolCode, int page, int size, String label) {
        Example example = new Example(Messagelabel.class);
        Example.Criteria criteria=  example.createCriteria();
        criteria.andEqualTo("schoolCode",schoolCode);
        criteria.andEqualTo("label",label);

        example.setOrderByClause("id desc ");
//
        //查询
        PageHelper.startPage(page, size,false);
        List<Messagelabel> messagelabels = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(messagelabels)) {
            return null;
        }
        Getpage getpage=new Getpage();
        //解析分页结果
        messagelabels=getpage.getMessagelabel( new PageInfo<Messagelabel>(messagelabels));



        return messagelabels;


    }
}
