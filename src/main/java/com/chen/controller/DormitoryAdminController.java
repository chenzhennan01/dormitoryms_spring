package com.chen.controller;


import com.chen.entity.DormitoryAdmin;
import com.chen.form.RuleForm;
import com.chen.form.SearchForm;
import com.chen.service.DormitoryAdminService;
import com.chen.util.ResultVOUtil;
import com.chen.vo.PageVO;
import com.chen.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 */
@RestController
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {

    @Autowired
    private DormitoryAdminService dormitoryAdminService;

    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.dormitoryAdminService.login(ruleForm);
        return resultVO;
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody DormitoryAdmin dormitoryAdmin){
        boolean save = this.dormitoryAdminService.save(dormitoryAdmin);
        if(!save) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageVO pageVO = this.dormitoryAdminService.list(page, size);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        PageVO pageVO = this.dormitoryAdminService.search(searchForm);
        return ResultVOUtil.success(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        DormitoryAdmin dormitoryAdmin = this.dormitoryAdminService.getById(id);
        return ResultVOUtil.success(dormitoryAdmin);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody DormitoryAdmin dormitoryAdmin){
        boolean update = this.dormitoryAdminService.updateById(dormitoryAdmin);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        boolean remove = this.dormitoryAdminService.removeById(id);
        if(!remove) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list")
    public ResultVO list(){
        List<DormitoryAdmin> dormitoryAdminList = this.dormitoryAdminService.list();
        return ResultVOUtil.success(dormitoryAdminList);
    }
}

