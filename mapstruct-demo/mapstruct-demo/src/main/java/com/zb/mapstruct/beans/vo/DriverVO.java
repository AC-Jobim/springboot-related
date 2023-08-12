package com.zb.mapstruct.beans.vo;

import lombok.Data;

/**
 * @author: zhaobin
 * @date: 2022/8/20 18:50
 * @Description:
 */
@Data
public class DriverVO {
    /**
     * 驾驶员id
     */
    private Long id;
    /**
     * 驾驶员的名字
     */
    private String fullName;
}
