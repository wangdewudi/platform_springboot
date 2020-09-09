package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.Messagelabel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LabelMapper extends Mapper<Messagelabel> {
}
