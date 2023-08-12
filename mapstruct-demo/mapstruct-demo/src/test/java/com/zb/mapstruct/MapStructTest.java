package com.zb.mapstruct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.zb.mapstruct.beans.dto.CarDTO;
import com.zb.mapstruct.beans.dto.DriverDTO;
import com.zb.mapstruct.beans.dto.PartDTO;
import com.zb.mapstruct.beans.vo.CarVO;
import com.zb.mapstruct.convert.CarConvert;

/**
 * @author: zhaobin
 * @date: 2022/8/20 18:51
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapStructDemoApplication.class)
public class MapStructTest {

    @Autowired
    private CarConvert carConvert;

    /**
     * 测试mapstruct批量转换
     * List<CarDto>--> List<CarVo>
     */
    @Test
    public void test3() {
        CarDTO carDTO = buildCarDTO();
        List<CarDTO> carDTOList = new ArrayList<>();
        carDTOList.add(carDTO); // source

        // target
        List<CarVO> carVOList = CarConvert.INSTANCE.dtos2CarVOs(carDTOList);
        System.out.println(carVOList);
    }

    @Test
    public void test2() {
        CarVO carVO = carConvert.dto2CarVO(buildCarDTO());
        System.out.println(carVO);
    }

    /**
     * 模拟业务构造出的CarDTO对象
     * @return
     */
    private CarDTO buildCarDTO() {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(330L);
        carDTO.setVin("vin123456789");
        carDTO.setPrice(123789.126d);
        carDTO.setTotalPrice(143789.126d);
        carDTO.setPublishDate(new Date());
        carDTO.setColor("白色");
        carDTO.setBrand("大众");
        // 零件
        PartDTO partDTO1 = new PartDTO();
        partDTO1.setPartId(1L);
        partDTO1.setPartName("多功能方向盘");
        PartDTO partDTO2 = new PartDTO();
        partDTO2.setPartId(2L);
        partDTO2.setPartName("智能车门");
        List<PartDTO> partDTOList = new ArrayList<>();
        partDTOList.add(partDTO1);
        partDTOList.add(partDTO2);
        carDTO.setPartDTOS(partDTOList);
        // 设置驾驶员
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(88L);
        driverDTO.setName("小明");
        carDTO.setDriverDTO(driverDTO);
        return carDTO;
    }
}
