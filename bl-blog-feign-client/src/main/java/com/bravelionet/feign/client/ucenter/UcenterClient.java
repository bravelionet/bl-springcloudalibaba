
package com.bravelionet.feign.client.ucenter;

import com.bravelionet.common.response.TypicResponseUtils;
import com.bravelionet.common.response.TypicalRep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("bl-blog-ucenter")
public interface UcenterClient {

    @GetMapping("/u/test")
    public @ResponseBody
    Object test();


    @GetMapping("/balance/v1/update-money-by-user-d/{money}/{userId}")
    public TypicalRep<Object> updateMoneyByUserId(@PathVariable("money") Long money, @PathVariable("userId") Long userId);
}

