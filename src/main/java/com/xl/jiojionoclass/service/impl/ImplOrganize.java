package com.xl.jiojionoclass.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xl.jiojionoclass.common.Tool;
import com.xl.jiojionoclass.entity.Curriculum;
import com.xl.jiojionoclass.entity.Organize;
import com.xl.jiojionoclass.entity.User;
import com.xl.jiojionoclass.entity.UserOrganize;
import com.xl.jiojionoclass.mapper.MapperCurriculum;
import com.xl.jiojionoclass.mapper.MapperOrganize;
import com.xl.jiojionoclass.mapper.MapperUser;
import com.xl.jiojionoclass.mapper.MapperUserOrganize;
import com.xl.jiojionoclass.service.ServiceOrganize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplOrganize extends ServiceImpl<MapperOrganize, Organize>implements ServiceOrganize {
   @Autowired
   private MapperOrganize mapperOrganize;
   @Autowired
   private MapperUser mapperUser;
   @Autowired
   private MapperUserOrganize mapperUserOrganize;
   @Autowired
   private MapperCurriculum mapperCurriculum;
   @Autowired
   private Tool tool;
   @Override
   public int joinOrganize(Long userId, Long organizeId, String token, Integer semesterId) {

        /*添加用户组织中间表*/
        /*UserOrganize userOrganize = new UserOrganize();
        userOrganize.setOrganizeId(organizeId);
        userOrganize.setUserId(userId);
        mapperUserOrganize.insert(userOrganize);*/

        /*添加用户*/
        /*添加用户课表*/
       String classSchedule = tool.getTheClassSchedule(semesterId, token);
       Curriculum curriculum = new Curriculum();
       curriculum.setUserId(userId);
       curriculum.setClassSchedule(classSchedule);
       curriculum.setSemesterId(semesterId);
       curriculum.setOrganizeId(organizeId);
       try {
           mapperCurriculum.insert(curriculum);
       } catch (Exception e) {
          return 0;
       }

       return 1;
   }
}
