package com.example.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.edu.entity.KsGoods;
import com.example.edu.entity.KsOrder;
import com.example.edu.entity.Teacher;
import com.example.edu.query.TeacherQuery;
import com.example.edu.service.KsGoodsService;
import com.example.utlis.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-18
 */
@CrossOrigin
@RestController
@RequestMapping("/edu/goods")
public class KsGoodsController {

    @Resource
    KsGoodsService ksGoodsService;

    @PostMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        Page<KsOrder> pageParam = new Page<>(page, limit);
        ksGoodsService.pageQuery(pageParam);
        List<KsOrder> res = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("items", res);
    }

    @GetMapping("{id}")
    public R pageQuery(@ApiParam(name = "id", value = "id", required = true) @PathVariable Integer id) {
        List<KsGoods> ksGoods = ksGoodsService.queryById(id);
        return R.ok().data("items", ksGoods);
    }

    @GetMapping
    public R findAll() {
        List<KsGoods> list = ksGoodsService.getAll();
        return R.ok().data("items", list);
    }

    @GetMapping("save-order/{oname}/{prices}")
    public R saveOrder(@PathVariable String oname, @PathVariable double prices) {
        Integer id = ksGoodsService.saveOrder(oname, prices);
        return R.ok().data("id", id);
    }

    @PostMapping("save-zhong/{oid}")
    public R save(@PathVariable Integer oid, @RequestBody List<KsGoods> ids) {
        ksGoodsService.saveZhong(oid, ids);
        return R.ok();
    }
}

