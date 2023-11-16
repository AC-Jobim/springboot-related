package com.zb.mapstruct.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import com.zb.mapstruct.beans.dto.DriverDTO;
import com.zb.mapstruct.beans.vo.DriverVO;

/**
 * @author: zhaobin
 * @date: 2022/8/21 18:35
 * @Description:
 */
@Mapper(componentModel = "spring")
public abstract class DriverConvert {

    public static DriverConvert INSTANCE = Mappers.getMapper(DriverConvert.class);

    @Mappings({
            @Mapping(source = "name", target = "fullName")
    })
    public abstract DriverVO dto2DriverVO(DriverDTO driverDTO);

}
