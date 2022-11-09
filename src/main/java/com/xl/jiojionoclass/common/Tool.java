package com.xl.jiojionoclass.common;

import com.alibaba.fastjson.JSON;
import com.xl.jiojionoclass.service.ServiceCurriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Component
public class Tool {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserAgentInterceptor userAgentInterceptor;

    public String getTheClassSchedule(Integer semesterId,String token) {

        userAgentInterceptor.setToken(token);
        restTemplate.setInterceptors(Collections.singletonList(userAgentInterceptor));
        ResponseEntity<HashMap> object = restTemplate.getForEntity("https://www.jooyeah.xyz/get/select/student/timetable?semester_id=" + semesterId, HashMap.class);
        HashMap<String, Object> hashMap = object.getBody();
        ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) object.getBody().get("data");
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
        for (HashMap<String, Object> map : list) {
            ArrayList<Integer> curriculum_week = (ArrayList) map.get("curriculum_week");
            ArrayList<Integer> curriculum_time = (ArrayList) map.get("curriculum_time");
            for (Integer integerw : curriculum_week) {
                String weekAndDay = integerw + "." + map.get("curriculum_day");

                if (stringListHashMap.get(weekAndDay) == null) {
                    ArrayList<String> list1 = new ArrayList<>();
                    stringListHashMap.put(weekAndDay, list1);
                }
                /**/
                for (Integer integer : curriculum_time) {
                    stringListHashMap.get(weekAndDay).add(integer.toString());
                }
            }
        }
        return JSON.toJSONString(stringListHashMap);
    }
}
