package com.chen.service;

import com.chen.entity.DormitoryAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.form.RuleForm;
import com.chen.form.SearchForm;
import com.chen.vo.PageVO;
import com.chen.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 */
public interface DormitoryAdminService extends IService<DormitoryAdmin> {
    public ResultVO login(RuleForm ruleForm);
    public PageVO list(Integer page,Integer size);
    public PageVO search(SearchForm searchForm);
}
