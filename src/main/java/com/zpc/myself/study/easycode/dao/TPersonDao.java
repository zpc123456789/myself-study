package com.zpc.myself.study.easycode.dao;

import com.zpc.myself.study.easycode.entity.TPerson;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TPerson)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-15 11:43:06
 */
public interface TPersonDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPerson queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tPerson 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TPerson> queryAllByLimit(TPerson tPerson, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tPerson 查询条件
     * @return 总行数
     */
    long count(TPerson tPerson);

    /**
     * 新增数据
     *
     * @param tPerson 实例对象
     * @return 影响行数
     */
    int insert(TPerson tPerson);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TPerson> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TPerson> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TPerson> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TPerson> entities);

    /**
     * 修改数据
     *
     * @param tPerson 实例对象
     * @return 影响行数
     */
    int update(TPerson tPerson);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

