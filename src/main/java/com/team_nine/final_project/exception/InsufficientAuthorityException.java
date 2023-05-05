package com.team_nine.final_project.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author zhuhaotian
 * @Date 2023/5/4
 */

@Getter
@Setter
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InsufficientAuthorityException extends RuntimeException {

    private char authority;

    public InsufficientAuthorityException(char authority) {
        super(String.format("Insufficient Authority: %c.", authority));
        this.authority = authority;
    }
}
