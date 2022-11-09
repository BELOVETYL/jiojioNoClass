package com.xl.jiojionoclass.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xl.jiojionoclass.entity.User;
import com.xl.jiojionoclass.mapper.MapperUser;
import com.xl.jiojionoclass.service.ServiceUser;
import org.springframework.stereotype.Service;

@Service
public class ImplUser extends ServiceImpl<MapperUser, User>implements ServiceUser {
}
