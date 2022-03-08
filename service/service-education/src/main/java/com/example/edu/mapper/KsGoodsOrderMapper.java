package com.example.edu.mapper;

import com.example.edu.entity.KsGoods;
import com.example.edu.entity.KsGoodsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-01-18
 */
public interface KsGoodsOrderMapper extends BaseMapper<KsGoodsOrder> {

    void saveZhong(@Param("oid") Integer oid, @Param("ids") List<KsGoods> goods);
}
