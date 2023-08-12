package com.zb.mapstruct.beans.dto;

import lombok.Data;

/**
 * @author: zhaobin
 * @date: 2022/8/20 18:47
 * @Description:
 */
@Data
public class PartDTO {
    
    /**
     * 汽车零件的id
     */
    private Long partId;

    /**
     * 零件的名字，比如:多功能方向盘
     */
    private String partName;
}
