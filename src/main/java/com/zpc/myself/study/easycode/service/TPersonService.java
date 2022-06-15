package com.zpc.myself.study.easycode.service;

import com.zpc.myself.study.easycode.entity.TPerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TPerson)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 11:43:10
 */
public interface TPersonService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPerson queryById(Long id);

    /**
     * 分页查询
     *
     * @param tPerson 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TPerson> queryByPage(TPerson tPerson, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tPerson 实例对象
     * @return 实例对象
     */
    TPerson insert(TPerson tPerson);

    /**
     * 修改数据
     *
     * @param tPerson 实例对象
     * @return 实例对象
     */
    TPerson update(TPerson tPerson);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
