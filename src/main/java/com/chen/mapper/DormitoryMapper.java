package com.chen.mapper;

import com.chen.entity.Dormitory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 */
public interface DormitoryMapper extends BaseMapper<Dormitory> {
    public void subAvailable(Integer id);
    public void addAvailable(Integer id);
    public Integer findAvailableDormitoryId();
}
