package com.chen.service;

import com.chen.entity.Absent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.form.SearchForm;
import com.chen.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 */
public interface AbsentService extends IService<Absent> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
}
