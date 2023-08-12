package com.zb.mapstruct.beans.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author: zhaobin
 * @date: 2022/8/20 18:29
 * @Description:
 */
@Data
public class CarDTO {
    /**
     * 编号id
     */
    private Long id;
    /**
     * 车辆的编号
     */
    private String vin;
    /**
     * 裸车的价格,单位:元
     */
    private double price;
    /**
     * 上路的价格,单位:元
     */
    private double totalPrice;
    /**
     * 生产日期
     */
    private Date publishDate;
    /**
     * 车的颜色,不想映射给vo
     */
    private String color;
    /**
     * 品牌名字
     */
    private String brand;
    /**
     * 汽车包含的零件列表
     */
    private List<PartDTO> partDTOS;
    /**
     * 汽车的司机
     */
    private DriverDTO driverDTO;
}
