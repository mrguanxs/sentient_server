package com.hoe.sentient.api.controller.test;

import com.hoe.sentient.common.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author guan
 * @date 2023/12/8
 */
@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/test")
public class TestController {

    @GetMapping()
    public Result<String> test() {
        return Result.success(LocalDateTime.now().toString());
    }
}
