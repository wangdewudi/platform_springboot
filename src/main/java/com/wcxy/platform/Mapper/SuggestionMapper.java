package com.wcxy.platform.Mapper;

import com.wcxy.platform.entity.Suggestion;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SuggestionMapper extends Mapper<Suggestion> {
}
