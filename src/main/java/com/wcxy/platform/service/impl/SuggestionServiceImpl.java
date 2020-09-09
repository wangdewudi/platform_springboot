package com.wcxy.platform.service.impl;

import com.wcxy.platform.Mapper.SuggestionMapper;
import com.wcxy.platform.entity.Suggestion;
import com.wcxy.platform.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl  implements SuggestionService {

    @Autowired
    private SuggestionMapper mapper;

    @Override
    public int insert(Suggestion suggestion) {

        return mapper.insert(suggestion);
    }
}
