package com.example.edu.mapper;

import com.example.edu.entity.KsGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-01-18
 */
public interface KsGoodsMapper extends BaseMapper<KsGoods> {

    List<KsGoods> queryList();
}
