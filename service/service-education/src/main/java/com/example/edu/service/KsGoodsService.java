package com.example.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.edu.entity.KsGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.edu.entity.KsOrder;
import com.example.edu.entity.Teacher;
import com.example.edu.query.TeacherQuery;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-18
 */
public interface KsGoodsService extends IService<KsGoods> {
    void pageQuery(Page<KsOrder> pageParam);

    List<KsGoods> queryById(Integer id);

    List<KsGoods> getAll();

    Integer saveOrder(String oname, double prices);

    void saveZhong(Integer oid, List<KsGoods> goods);
}
