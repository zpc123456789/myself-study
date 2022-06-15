package com.zpc.myself.study.easycode.service.impl;

import com.zpc.myself.study.easycode.entity.TPerson;
import com.zpc.myself.study.easycode.dao.TPersonDao;
import com.zpc.myself.study.easycode.service.TPersonService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TPerson)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 11:43:13
 */
@Service("tPersonService")
public class TPersonServiceImpl implements TPersonService {
    @Resource
    private TPersonDao tPersonDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TPerson queryById(Long id) {
        return this.tPersonDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tPerson 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TPerson> queryByPage(TPerson tPerson, PageRequest pageRequest) {
        long total = this.tPersonDao.count(tPerson);
        return new PageImpl<>(this.tPersonDao.queryAllByLimit(tPerson, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tPerson 实例对象
     * @return 实例对象
     */
    @Override
    public TPerson insert(TPerson tPerson) {
        this.tPersonDao.insert(tPerson);
        return tPerson;
    }

    /**
     * 修改数据
     *
     * @param tPerson 实例对象
     * @return 实例对象
     */
    @Override
    public TPerson update(TPerson tPerson) {
        this.tPersonDao.update(tPerson);
        return this.queryById(tPerson.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tPersonDao.deleteById(id) > 0;
    }
}
