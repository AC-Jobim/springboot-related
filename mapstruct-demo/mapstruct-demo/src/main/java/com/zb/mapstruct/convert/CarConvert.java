package com.zb.mapstruct.convert;

import java.util.List;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.zb.mapstruct.beans.dto.CarDTO;
import com.zb.mapstruct.beans.dto.DriverDTO;
import com.zb.mapstruct.beans.vo.CarVO;
import com.zb.mapstruct.beans.vo.DriverVO;

/**
 * @author: zhaobin
 * @date: 2022/8/20 20:05
 * @Description:
 */
@Mapper(componentModel = "spring")
public abstract class CarConvert {

    public static CarConvert INSTANCE = Mappers.getMapper(CarConvert.class);
    @Mappings({
            @Mapping(source = "totalPrice", target = "totalPrice", numberFormat = "#.00"),
            @Mapping(source = "publishDate", target = "publishDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "brand", target = "brandName"),
//            @Mapping(source = "driverDTO", target = "driverVO", expression = "java(DriverConvert.INSTANCE.dto2DriverVO(carDTO.getDriverDTO()))")
            @Mapping(source = "driverDTO", target = "driverVO")
    })
    public abstract CarVO dto2CarVO(CarDTO carDTO);


    public DriverVO dto2DriverVO(DriverDTO driverDTO) {
        DriverVO driverVO = new DriverVO();
        driverVO.setId(driverVO.getId());
        driverVO.setFullName(driverVO.getFullName());
        return driverVO;
    }

//    @Mappings({
//            @Mapping(source = "name", target = "fullName")
//    })
//    public abstract DriverVO dto2DriverVO(DriverDTO driverDTO);

    public abstract List<CarVO> dtos2CarVOs(List<CarDTO> driverDTOs);

    @AfterMapping // 表示让mapstruct在调用完自动转换的方法之后，会来自动调用本方法
    public void dto2CarVOAfter(CarDTO carDTO, @MappingTarget CarVO carVO) {
        // @MappingTarget : 表示传来的carVO对象是已经赋值过的
        carVO.setHasPart(carDTO.getPartDTOS() != null && !carDTO.getPartDTOS().isEmpty());
    }


}
