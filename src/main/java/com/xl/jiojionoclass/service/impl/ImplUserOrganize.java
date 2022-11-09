package com.xl.jiojionoclass.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xl.jiojionoclass.entity.UserOrganize;
import com.xl.jiojionoclass.mapper.MapperUserOrganize;
import com.xl.jiojionoclass.service.ServiceUserOrganize;
import org.springframework.stereotype.Service;
@Service
public class ImplUserOrganize extends ServiceImpl<MapperUserOrganize, UserOrganize>implements ServiceUserOrganize {
}
