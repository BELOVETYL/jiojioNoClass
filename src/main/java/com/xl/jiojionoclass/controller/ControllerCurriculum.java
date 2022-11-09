package com.xl.jiojionoclass.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xl.jiojionoclass.common.R;
import com.xl.jiojionoclass.config.JwtConfig;
import com.xl.jiojionoclass.entity.Curriculum;
import com.xl.jiojionoclass.entity.Organize;
import com.xl.jiojionoclass.entity.User;
import com.xl.jiojionoclass.service.ServiceCurriculum;
import com.xl.jiojionoclass.service.ServiceUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/curriculum")
public class ControllerCurriculum {
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private ServiceCurriculum serviceCurriculum;

    @Autowired
    private JwtConfig jwtConfig;
    @GetMapping("/{organizeId}/{semesterId}")
    /*传入组织id返回所有成员课表*/
    public R getCurriculum(@PathVariable Long organizeId, @PathVariable Integer semesterId, HttpServletRequest request){
        log.info("传入参数分别为 {},{}",organizeId,semesterId);
        String token = request.getHeader("token");
        Long userId = Long.valueOf(String.valueOf(jwtConfig.getTokenInfo(token,"data").get("username")));

        LambdaQueryWrapper<Curriculum> curriculumLambdaQueryWrapper = new LambdaQueryWrapper<>();
        curriculumLambdaQueryWrapper
                .eq(Curriculum::getOrganizeId,organizeId)
                .eq(Curriculum::getUserId,userId);
        Curriculum one = serviceCurriculum.getOne(curriculumLambdaQueryWrapper);
        if (one==null){
            return   R.error("非法请求");
        }

        curriculumLambdaQueryWrapper = new LambdaQueryWrapper<>();
        curriculumLambdaQueryWrapper
                .select(Curriculum::getUserId,Curriculum::getClassSchedule,Curriculum::getName)
                .eq(Curriculum::getOrganizeId,organizeId)
                .eq(Curriculum::getSemesterId,semesterId);
        List<Curriculum> list = serviceCurriculum.list(curriculumLambdaQueryWrapper);
        return R.success(list);
    }
}
