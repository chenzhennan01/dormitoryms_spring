package com.chen.service;

import com.chen.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.form.SearchForm;
import com.chen.form.StudentForm;
import com.chen.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 */
public interface StudentService extends IService<Student> {
    public Boolean saveStudent(Student student);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean update(StudentForm studentForm);
    public Boolean deleteById(Integer id);
}
