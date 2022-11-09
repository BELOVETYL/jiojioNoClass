package com.xl.jiojionoclass;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xl.jiojionoclass.common.Tool;
import com.xl.jiojionoclass.common.UserAgentInterceptor;
import com.xl.jiojionoclass.entity.Curriculum;
import com.xl.jiojionoclass.service.ServiceCurriculum;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootTest
class JiojioNoClassApplicationTests {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ServiceCurriculum serviceCurriculum;

    @Autowired
    private Tool tool;
    @Test
    void f1(){

    }

    @Test
    void f(){

        String s="{\"8.7\":[\"7\",\"8\",\"9\",\"10\"],\"12.4\":[\"9\",\"10\",\"7\",\"8\"],\"14.2\":[\"7\",\"8\"],\"10.6\":[\"7\",\"8\"],\"14.1\":[\"3\",\"4\"],\"10.5\":[\"3\",\"4\",\"1\",\"2\"],\"12.3\":[\"1\",\"2\"],\"12.2\":[\"1\",\"2\",\"9\",\"10\",\"7\",\"8\"],\"10.4\":[\"9\",\"10\",\"7\",\"8\"],\"12.1\":[\"9\",\"10\",\"7\",\"8\",\"3\",\"4\"],\"10.3\":[\"1\",\"2\"],\"10.2\":[\"1\",\"2\",\"9\",\"10\",\"7\",\"8\"],\"1.1\":[\"7\",\"8\",\"3\",\"4\"],\"10.1\":[\"9\",\"10\",\"7\",\"8\",\"3\",\"4\"],\"1.2\":[\"9\",\"10\"],\"1.3\":[\"1\",\"2\"],\"3.1\":[\"7\",\"8\",\"3\",\"4\"],\"1.4\":[\"7\",\"8\"],\"3.2\":[\"9\",\"10\",\"7\",\"8\"],\"1.5\":[\"3\",\"4\"],\"3.3\":[\"1\",\"2\"],\"5.1\":[\"7\",\"8\",\"3\",\"4\"],\"3.4\":[\"7\",\"8\"],\"5.2\":[\"9\",\"10\",\"7\",\"8\"],\"7.1\":[\"9\",\"10\",\"7\",\"8\",\"3\",\"4\"],\"3.5\":[\"3\",\"4\",\"1\",\"2\"],\"7.2\":[\"1\",\"2\",\"9\",\"10\",\"7\",\"8\"],\"5.4\":[\"7\",\"8\",\"3\",\"4\"],\"14.7\":[\"7\",\"8\",\"9\",\"10\"],\"9.1\":[\"9\",\"10\",\"7\",\"8\",\"3\",\"4\"],\"5.5\":[\"3\",\"4\",\"1\",\"2\"],\"7.3\":[\"1\",\"2\"],\"14.6\":[\"7\",\"8\"],\"9.2\":[\"1\",\"2\",\"9\",\"10\",\"7\",\"8\"],\"7.4\":[\"9\",\"10\",\"7\",\"8\"],\"14.5\":[\"3\",\"4\"],\"12.7\":[\"7\",\"8\",\"9\",\"10\"],\"9.3\":[\"1\",\"2\"],\"16.2\":[\"7\",\"8\"],\"12.6\":[\"7\",\"8\"],\"9.4\":[\"9\",\"10\",\"7\",\"8\"],\"12.5\":[\"3\",\"4\",\"1\",\"2\"],\"10.7\":[\"7\",\"8\",\"9\",\"10\"],\"9.7\":[\"7\",\"8\",\"9\",\"10\"],\"11.5\":[\"3\",\"4\",\"1\",\"2\"],\"13.2\":[\"1\",\"2\",\"7\",\"8\"],\"11.4\":[\"9\",\"10\",\"7\",\"8\"],\"13.1\":[\"9\",\"10\"],\"11.3\":[\"1\",\"2\"],\"11.2\":[\"1\",\"2\",\"9\",\"10\",\"7\",\"8\"],\"11.1\":[\"9\",\"10\",\"7\",\"8\",\"3\",\"4\"],\"2.1\":[\"7\",\"8\",\"3\",\"4\"],\"2.2\":[\"9\",\"10\"],\"2.3\":[\"1\",\"2\"],\"4.1\":[\"7\",\"8\",\"3\",\"4\"],\"2.4\":[\"7\",\"8\"],\"4.2\":[\"9\",\"10\",\"7\",\"8\"],\"6.1\":[\"9\",\"10\",\"7\",\"8\",\"3\",\"4\"],\"2.5\":[\"3\",\"4\"],\"4.3\":[\"1\",\"2\"],\"6.2\":[\"1\",\"2\",\"9\",\"10\",\"7\",\"8\"],\"4.4\":[\"7\",\"8\"],\"15.7\":[\"7\",\"8\",\"9\",\"10\",\"7\",\"8\"],\"8.1\":[\"9\",\"10\",\"7\",\"8\",\"3\",\"4\"],\"4.5\":[\"3\",\"4\",\"1\",\"2\"],\"6.3\":[\"1\",\"2\"],\"15.6\":[\"7\",\"8\"],\"6.4\":[\"9\",\"10\",\"7\",\"8\"],\"8.2\":[\"1\",\"2\",\"9\",\"10\",\"7\",\"8\"],\"15.5\":[\"1\",\"2\"],\"13.7\":[\"7\",\"8\",\"9\",\"10\",\"7\",\"8\"],\"6.5\":[\"3\",\"4\",\"1\",\"2\"],\"8.3\":[\"1\",\"2\"],\"13.6\":[\"7\",\"8\"],\"8.4\":[\"9\",\"10\",\"7\",\"8\"],\"13.5\":[\"1\",\"2\"],\"11.7\":[\"7\",\"8\",\"9\",\"10\"],\"13.4\":[\"9\",\"10\"],\"8.5\":[\"3\",\"4\",\"1\",\"2\"],\"15.2\":[\"7\",\"8\"],\"11.6\":[\"7\",\"8\"]}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        List<Integer> list=(List<Integer>)jsonObject.get(8.7);

    }

    @Test
    void contextLoads() {

        restTemplate.setInterceptors(Collections.singletonList(new UserAgentInterceptor()));
        HttpHeaders httpHeaders = new HttpHeaders();
        //1.直接获取响内容
        ResponseEntity<HashMap> object = restTemplate.getForEntity("https://www.jooyeah.xyz/get/select/student/timetable?semester_id=102", HashMap.class);
        HashMap<String, Object> hashMap = object.getBody();
        ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) object.getBody().get("data");


        System.out.println(list);
//        for (HashMap<String, Object> stringObjectHashMap : list) {
//            System.out.println(stringObjectHashMap);
//        }

       /* LinkedMultiValueMap<String, LinkedMultiValueMap> stringListHashMap = new LinkedMultiValueMap<>();
*/
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
        /* HashMap<String, List<HashMap<String,List<String>>>> stringListHashMap = new HashMap<>();*/

        for (HashMap<String, Object> map : list) {
            ArrayList<Integer> curriculum_week = (ArrayList) map.get("curriculum_week");
            ArrayList<Integer> curriculum_time = (ArrayList) map.get("curriculum_time");
            for (Integer integerw : curriculum_week) {
                String weekAndDay=integerw+"."+map.get("curriculum_day");

                if (stringListHashMap.get(weekAndDay)==null){
                    ArrayList<String> list1 = new ArrayList<>();
                    stringListHashMap.put(weekAndDay,list1);
                }
                /**/
                for (Integer integer : curriculum_time) {
                    stringListHashMap.get(weekAndDay).add(integer.toString());
                }

            }
        }




        /*{"8.7":["7","8","9","10"],"12.4":["9","10","7","8"],"14.2":["7","8"],"10.6":["7","8"],"14.1":["3","4"],"10.5":["3","4","1","2"],"12.3":["1","2"],"12.2":["1","2","9","10","7","8"],"10.4":["9","10","7","8"],"12.1":["9","10","7","8","3","4"],"10.3":["1","2"],"10.2":["1","2","9","10","7","8"],"1.1":["7","8","3","4"],"10.1":["9","10","7","8","3","4"],"1.2":["9","10"],"1.3":["1","2"],"3.1":["7","8","3","4"],"1.4":["7","8"],"3.2":["9","10","7","8"],"1.5":["3","4"],"3.3":["1","2"],"5.1":["7","8","3","4"],"3.4":["7","8"],"5.2":["9","10","7","8"],"7.1":["9","10","7","8","3","4"],"3.5":["3","4","1","2"],"7.2":["1","2","9","10","7","8"],"5.4":["7","8","3","4"],"14.7":["7","8","9","10"],"9.1":["9","10","7","8","3","4"],"5.5":["3","4","1","2"],"7.3":["1","2"],"14.6":["7","8"],"9.2":["1","2","9","10","7","8"],"7.4":["9","10","7","8"],"14.5":["3","4"],"12.7":["7","8","9","10"],"9.3":["1","2"],"16.2":["7","8"],"12.6":["7","8"],"9.4":["9","10","7","8"],"12.5":["3","4","1","2"],"10.7":["7","8","9","10"],"9.7":["7","8","9","10"],"11.5":["3","4","1","2"],"13.2":["1","2","7","8"],"11.4":["9","10","7","8"],"13.1":["9","10"],"11.3":["1","2"],"11.2":["1","2","9","10","7","8"],"11.1":["9","10","7","8","3","4"],"2.1":["7","8","3","4"],"2.2":["9","10"],"2.3":["1","2"],"4.1":["7","8","3","4"],"2.4":["7","8"],"4.2":["9","10","7","8"],"6.1":["9","10","7","8","3","4"],"2.5":["3","4"],"4.3":["1","2"],"6.2":["1","2","9","10","7","8"],"4.4":["7","8"],"15.7":["7","8","9","10","7","8"],"8.1":["9","10","7","8","3","4"],"4.5":["3","4","1","2"],"6.3":["1","2"],"15.6":["7","8"],"6.4":["9","10","7","8"],"8.2":["1","2","9","10","7","8"],"15.5":["1","2"],"13.7":["7","8","9","10","7","8"],"6.5":["3","4","1","2"],"8.3":["1","2"],"13.6":["7","8"],"8.4":["9","10","7","8"],"13.5":["1","2"],"11.7":["7","8","9","10"],"13.4":["9","10"],"8.5":["3","4","1","2"],"15.2":["7","8"],"11.6":["7","8"]}*/
        Curriculum curriculum = new Curriculum();
        curriculum.setUserId(20442060L);
        curriculum.setClassSchedule(JSON.toJSONString(stringListHashMap));
        serviceCurriculum.save(curriculum);





        //2.获取响应信息，包含响应状态、响应头、响应内容
        ResponseEntity<String> entity = restTemplate.getForEntity("https://www.jooyeah.xyz/get/select/student/timetable?semester_id=102", String.class);

        /*// post请求
        User user = restTemplate.postForObject("http://localhost:8080/getUser", postData, User.class);
*/

        // 设置请求头


        //设置请求参数
        Map<String, Object> postData = new HashMap<>();
        postData.put("id", 1L);
        postData.put("name", "测试");
        postData.put("age", 18);

        //将请求头和请求参数设置到HttpEntity中
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(postData, httpHeaders);

        /*User user = restTemplate.postForObject("http://localhost:8080/getUser", httpEntity, User.class);
         */

        // 使用exchange()方法
       /* exchange():
        String strbody=restTemplate.exchange(uri, HttpMethod.GET, entity,String.class).getBody();
	    WeatherResponse weatherResponse= JSONObject.parseObject(strbody,WeatherResponse.class);*/
    }

/*{curriculum_code=93203.05, curriculum_day=2,
curriculum_name=软件项目管理, curriculum_place=实验楼104机房,
curriculum_teacher=赵庆佳, curriculum_time=[1, 2], curriculum_week=[7, 9, 10, 11, 12, 13]}
 */
}
