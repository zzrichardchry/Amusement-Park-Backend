package com.team_nine.final_project.service.impl;

import com.team_nine.final_project.exception.InsufficientAuthorityException;
import com.team_nine.final_project.payload.VisitorDto;
import com.team_nine.final_project.service.AuthorityService;
import org.springframework.stereotype.Service;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Override
    public void isManager(VisitorDto visitorDto) {
        char aType = visitorDto.getAType();
        String authority = String.valueOf(aType);

        if(authority.equals("1")) throw new InsufficientAuthorityException(visitorDto.getAType());
    }
}
