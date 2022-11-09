package com.xl.jiojionoclass.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xl.jiojionoclass.entity.Curriculum;
import com.xl.jiojionoclass.mapper.MapperCurriculum;
import com.xl.jiojionoclass.service.ServiceCurriculum;
import org.springframework.stereotype.Service;
@Service
public class ImplCurriculum extends ServiceImpl<MapperCurriculum,Curriculum> implements ServiceCurriculum {
}
