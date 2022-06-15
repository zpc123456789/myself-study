package com.zpc.myself.study.easycode.controller;

import com.zpc.myself.study.easycode.entity.TPerson;
import com.zpc.myself.study.easycode.req.IdReq;
import com.zpc.myself.study.easycode.service.TPersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TPerson)表控制层
 *
 * @author makejava
 * @since 2022-06-15 11:43:05
 */
@RestController
//@RequestMapping("/tPerson")
public class TPersonController {
    /**
     * 服务对象
     */
    @Resource
    private TPersonService tPersonService;

    /**
     * 分页查询
     *
     * @param tPerson 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TPerson>> queryByPage(TPerson tPerson, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tPersonService.queryByPage(tPerson, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/testOne")
    public ResponseEntity<TPerson> queryById(@RequestBody IdReq id) {
        return ResponseEntity.ok(this.tPersonService.queryById(id.getId()));
    }

    /**
     * 新增数据
     *
     * @param tPerson 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TPerson> add(TPerson tPerson) {
        return ResponseEntity.ok(this.tPersonService.insert(tPerson));
    }

    /**
     * 编辑数据
     *
     * @param tPerson 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TPerson> edit(TPerson tPerson) {
        return ResponseEntity.ok(this.tPersonService.update(tPerson));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tPersonService.deleteById(id));
    }

}

