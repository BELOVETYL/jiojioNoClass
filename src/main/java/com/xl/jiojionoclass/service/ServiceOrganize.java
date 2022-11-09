package com.xl.jiojionoclass.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xl.jiojionoclass.entity.Organize;

public interface ServiceOrganize extends IService<Organize> {
    /*加入组织*/
    public int joinOrganize(Long userId, Long organizeId, String token, Integer semesterId);
    /*退出组织*/
    /*删除组织*/
}
