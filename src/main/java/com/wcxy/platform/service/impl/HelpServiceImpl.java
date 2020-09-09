package com.wcxy.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcxy.platform.Mapper.HelpMapper;
import com.wcxy.platform.entity.Help;
import com.wcxy.platform.entity.Message;
import com.wcxy.platform.service.HelpService;
import com.wcxy.platform.tools.Getpage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class HelpServiceImpl implements HelpService {

    @Autowired
    private HelpMapper mapper;

    @Override
    public int insert(Help help) {
        return mapper.insert(help);
    }

    @Override
    public Help selectone(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Help> selectpage(Integer page) {
        Example example = new Example(Help.class);
        Example.Criteria criteria=  example.createCriteria();
        criteria.andEqualTo("checked",1);
        PageHelper.startPage(page, 5,false);
        List<Help> helps = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(helps)) {
            return null;
        }
        Getpage getpage=new Getpage();
        //解析分页结果
        helps=getpage.getHelp( new PageInfo<Help>(helps));

        for(int i=0;i<helps.size();i++){
            helps.get(i).setContent("");
        }

        return helps;

    }
}
