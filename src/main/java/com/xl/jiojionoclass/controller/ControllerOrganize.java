package com.xl.jiojionoclass.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.xl.jiojionoclass.common.R;
import com.xl.jiojionoclass.config.JwtConfig;
import com.xl.jiojionoclass.entity.Curriculum;
import com.xl.jiojionoclass.entity.Organize;
import com.xl.jiojionoclass.entity.User;
import com.xl.jiojionoclass.entity.UserOrganize;
import com.xl.jiojionoclass.service.ServiceCurriculum;
import com.xl.jiojionoclass.service.ServiceOrganize;
import com.xl.jiojionoclass.service.ServiceUser;
import com.xl.jiojionoclass.service.ServiceUserOrganize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/organize")
@Slf4j
public class ControllerOrganize {
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private ServiceOrganize serviceOrganize;
    @Autowired
    private ServiceUserOrganize serviceUserOrganize;
    @Autowired
    private ServiceCurriculum serviceCurriculum;
    @Autowired
    private JwtConfig jwtConfig;
    /*创建组织*/
    @PostMapping("/creat")
    public R creat(@RequestBody Organize organize, HttpServletRequest request){
        /*获取token里的用户id*/
        log.info("参数值{}",organize);
        String token = request.getHeader("token");
        Long userId = Long.valueOf(String.valueOf(jwtConfig.getTokenInfo(token,"data").get("username")));

        organize.setOrganizeAdminId(userId);
        Long id = IdWorker.getId();
        organize.setId(id);

        User userById = serviceUser.getById(userId);
        if (userById==null){
            User user = new User();
            user.setId(userId);
            serviceUser.save(user);
        }
        /*创建组织*/
        serviceOrganize.save(organize);
        /*让管理员加入组织*/
        int i = serviceOrganize.joinOrganize(userId, id, token, organize.getSemesterId());

        if (i==0){
            return R.error("非法加入");
        }
        return R.success(id);
    }
    /*管理员更新组织*/
    @PutMapping
    public R update(@RequestBody Organize organize,HttpServletRequest request){
        if (organize.getId()==null){
            return R.error("OrganizeId为空");
        }
        String token = request.getHeader("token");
        Long userId = Long.valueOf(String.valueOf(jwtConfig.getTokenInfo(token,"data").get("username")));

        LambdaQueryWrapper<Organize> organizeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        organizeLambdaQueryWrapper
                .eq(Organize::getOrganizeAdminId,userId)
                .eq(Organize::getId,organize.getId());

        Organize one = serviceOrganize.getOne(organizeLambdaQueryWrapper);

        if (one==null){
            return R.error("非法修改");
        }else {
            serviceOrganize.updateById(organize);
            return R.success("修改成功");
        }

    }
    /*用户加入组织*/
    @PutMapping("/{organizeId}")
    public R join(@PathVariable Long organizeId,HttpServletRequest request){
        String token = request.getHeader("token");
        boolean b = jwtConfig.verifierToken(token);
        if (!b){
            return R.error("token失效");
        }
        Organize organize = serviceOrganize.getById(organizeId);
        Long userId = Long.valueOf(String.valueOf(jwtConfig.getTokenInfo(token,"data").get("username")));

        User userById = serviceUser.getById(userId);
        if (userById==null){
            User user = new User();
            user.setId(userId);
            serviceUser.save(user);
        }

        int i = serviceOrganize.joinOrganize(userId, organizeId, token, organize.getSemesterId());
        if (i==0){
            return R.error("非法加入");
        }
        return R.success("success");
    }
    /*管理员删除组织*/
    @DeleteMapping("/admin/{organizeId}")
    public R deleteByAdmin(@PathVariable Long organizeId,HttpServletRequest request){
        String token = request.getHeader("token");
        Long userId = Long.valueOf(String.valueOf(jwtConfig.getTokenInfo(token,"data").get("username")));

        LambdaQueryWrapper<Organize> organizeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        organizeLambdaQueryWrapper
                .eq(Organize::getOrganizeAdminId,userId)
                .eq(Organize::getId,organizeId);

        Organize one = serviceOrganize.getOne(organizeLambdaQueryWrapper);
        if (one==null){
            return R.error("非法删除");
        }else {
            LambdaQueryWrapper<Curriculum> curriculumLambdaQueryWrapper = new LambdaQueryWrapper<>();
            curriculumLambdaQueryWrapper.eq(Curriculum::getOrganizeId,organizeId);
            serviceCurriculum.remove(curriculumLambdaQueryWrapper);
            serviceOrganize.removeById(organizeId);
            return R.success("删除成功");
        }
    }

    /*用户退出组织*/
    @DeleteMapping("/user/{organizeId}")
    public R deleteByUser(@PathVariable Long organizeId,HttpServletRequest request){
        String token = request.getHeader("token");
        Long userId = Long.valueOf(String.valueOf(jwtConfig.getTokenInfo(token,"data").get("username")));


        LambdaQueryWrapper<Curriculum> curriculumLambdaQueryWrapper = new LambdaQueryWrapper<>();
        curriculumLambdaQueryWrapper
                .eq(Curriculum::getOrganizeId,organizeId)
                .eq(Curriculum::getUserId,userId);
        boolean remove = serviceCurriculum.remove(curriculumLambdaQueryWrapper);
        if (remove){
            return R.success("退出成功");
        }else {
            return R.error("非法退出");
        }
    }
}
