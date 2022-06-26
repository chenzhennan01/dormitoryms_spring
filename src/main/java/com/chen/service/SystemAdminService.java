package com.chen.service;

import com.chen.entity.SystemAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.form.RuleForm;
import com.chen.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 */
public interface SystemAdminService extends IService<SystemAdmin> {
    public ResultVO login(RuleForm ruleForm);
}
