package xyz.redhawk.mybatisplus.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import xyz.redhawk.mybatisplus.entity.User;
import xyz.redhawk.mybatisplus.vo.RestResponse;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liping404
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "用户操作", tags = "用户操作接口")
public class UserController {

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public RestResponse add(@Valid User user) {

        return RestResponse.success(new User());
    }

    @ApiOperation("更新用户")
    @GetMapping("update")
    public RestResponse update(@Valid User user) {

        return RestResponse.success(new User());
    }
}

