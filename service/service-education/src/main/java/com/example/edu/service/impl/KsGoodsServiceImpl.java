package com.example.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.edu.entity.KsGoods;
import com.example.edu.entity.KsOrder;
import com.example.edu.entity.Teacher;
import com.example.edu.mapper.KsGoodsMapper;
import com.example.edu.mapper.KsGoodsOrderMapper;
import com.example.edu.mapper.KsOrderMapper;
import com.example.edu.service.KsGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-18
 */
@Service
public class KsGoodsServiceImpl extends ServiceImpl<KsGoodsMapper, KsGoods> implements KsGoodsService {

    @Resource
    KsOrderMapper ksOrderMapper;
    @Resource
    KsGoodsOrderMapper ksGoodsOrderMapper;

    @Override
    public void pageQuery(Page<KsOrder> pageParam) {
        QueryWrapper<KsOrder> queryWrapper = new QueryWrapper<>();
        ksOrderMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public List<KsGoods> queryById(Integer id) {
        return ksOrderMapper.queryById(id);
    }

    @Override
    public List<KsGoods> getAll() {
        return baseMapper.queryList();
    }

    @Override
    public Integer saveOrder(String oname, double prices) {
        Integer uid = 1;
        Date date = new Date();
        return ksOrderMapper.saveOrder(uid, oname, prices, date);
    }

    @Override
    public void saveZhong(Integer oid, List<KsGoods> goods) {
        ksGoodsOrderMapper.saveZhong(oid, goods);
    }
}
