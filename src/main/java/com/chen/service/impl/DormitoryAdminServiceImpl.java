package com.chen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.entity.DormitoryAdmin;
import com.chen.form.RuleForm;
import com.chen.form.SearchForm;
import com.chen.mapper.DormitoryAdminMapper;
import com.chen.service.DormitoryAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.vo.PageVO;
import com.chen.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 */
@Service
public class DormitoryAdminServiceImpl extends ServiceImpl<DormitoryAdminMapper, DormitoryAdmin> implements DormitoryAdminService {

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public ResultVO login(RuleForm ruleForm) {
        //1、判断用户名是否存在
        QueryWrapper<DormitoryAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", ruleForm.getUsername());
        DormitoryAdmin dormitoryAdmin = this.dormitoryAdminMapper.selectOne(queryWrapper);
        ResultVO resultVO = new ResultVO();
        if(dormitoryAdmin == null){
            resultVO.setCode(-1);
        } else {
            //2、判断密码是否正确
            if(!dormitoryAdmin.getPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            } else {
                resultVO.setCode(0);
                resultVO.setData(dormitoryAdmin);
            }
        }
        return resultVO;
    }

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<DormitoryAdmin> dormitoryAdminPage = new Page<>(page, size);
        Page<DormitoryAdmin> resultPage = this.dormitoryAdminMapper.selectPage(dormitoryAdminPage, null);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        //模糊查询+分页
        Page<DormitoryAdmin> dormitoryAdminPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<DormitoryAdmin> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = this.dormitoryAdminMapper.selectPage(dormitoryAdminPage, null);
        } else {
            QueryWrapper<DormitoryAdmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.dormitoryAdminMapper.selectPage(dormitoryAdminPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
