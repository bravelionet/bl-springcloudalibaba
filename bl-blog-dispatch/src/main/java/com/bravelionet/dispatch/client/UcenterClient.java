package com.bravelionet.dispatch.client;

import com.bravelionet.domain.ucenter.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("bl-blog-ucenter")
public interface UcenterClient {


    @GetMapping("/ucenter/select-user-by-id/{id}")
    User selectUserById(@PathVariable("id") Long a);
}
