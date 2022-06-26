package com.chen.controller;


import com.chen.form.RuleForm;
import com.chen.service.SystemAdminService;
import com.chen.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 */
@RestController
@RequestMapping("/systemAdmin")
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;

    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.systemAdminService.login(ruleForm);
        return resultVO;
    }

}

