package com.example.edu.mapper;

import com.example.edu.entity.KsGoods;
import com.example.edu.entity.KsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-01-18
 */
public interface KsOrderMapper extends BaseMapper<KsOrder> {

    List<KsGoods> queryById(Integer id);


    Integer saveOrder(@Param("uid") Integer uid, @Param("oname") String oname, @Param("prices") double prices, @Param("date") Date date);

}
