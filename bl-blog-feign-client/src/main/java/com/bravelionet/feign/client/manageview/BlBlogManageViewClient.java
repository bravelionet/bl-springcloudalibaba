package com.bravelionet.feign.client.manageview;

import com.bravelionet.common.response.TypicalRep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("bl-blog-manage-view")
public interface BlBlogManageViewClient {

    /**
     * 查询可有 routes
     *
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/2/8  17:30
     */
    @GetMapping("/v1/init/routes-all")
    public @ResponseBody TypicalRep<Object> selectAll();

    @GetMapping("/product-case/v1/update-by-id/{id}/{mount}")
    public TypicalRep<Object> updateById(@PathVariable("id") Long id, @PathVariable("mount") Integer mount);

}
