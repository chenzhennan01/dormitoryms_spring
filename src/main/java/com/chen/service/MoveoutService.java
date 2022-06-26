package com.chen.service;

import com.chen.entity.Moveout;
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
public interface MoveoutService extends IService<Moveout> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean moveout(Integer id,String reason);
    public PageVO moveoutList(Integer page, Integer size);
    public PageVO moveoutSearch(SearchForm searchForm);
}
