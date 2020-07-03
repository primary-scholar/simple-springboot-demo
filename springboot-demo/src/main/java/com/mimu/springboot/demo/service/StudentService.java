package com.mimu.springboot.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.mimu.springboot.demo.config.customizer.cache.RedisTTlConstant;
import com.mimu.springboot.demo.dao.StudentRepository;
import com.mimu.springboot.demo.model.StudentStudentInfo;
import com.mimu.springboot.demo.request.StudentRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * author: mimu
 * date: 2020/4/27
 */

/**
 * spring cache 必须使用代理对象进行访问才会生效(内部调用不生效)
 */
@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private StudentRepository studentRepository;

    public StudentStudentInfo getStudentInfo(StudentRequest request) {
        String key = "mo::stu_" + request.getNo();
        String s = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotEmpty(s)) {
            return JSONObject.parseObject(s, StudentStudentInfo.class);
        }
        StudentStudentInfo studentInfo = studentRepository.getStudentInfo(request.getNo());
        if (studentInfo != null) {
            String s1 = JSONObject.toJSONString(studentInfo);
            redisTemplate.opsForValue().set(key, s1, Duration.ofMillis(60000));
        }
        logger.info("{}", studentInfo);
        return studentInfo;
    }

    /**
     * 这里 Cacheable 执行逻辑:
     * 和 {@link StudentService #getStudentInfo(StudentRequest request) }
     * 逻辑 一致 key 的拼接也是 一致的
     * 只是 没有 设置 有效期
     *
     * @param request
     * @return
     */
    @Cacheable(cacheNames = RedisTTlConstant.minute_1_info, key = "'stu_'+#request.no", unless = "#result==null")
    public StudentStudentInfo getStudentInfoCacheableEquivalent(StudentRequest request) {
        return studentRepository.getStudentInfo(request.getNo());
    }

    /**
     * CachePut 的执行逻辑
     * 是 执行方法，并更新缓存
     * 更新的 缓存中的值 是 方法的 返回值 这点 需 注意!!!!
     *
     * @param request
     * @return
     */
    @CachePut(cacheNames = RedisTTlConstant.minute_1_info, key = "'stu_'+#request.no")
    public boolean updateUserInfo(StudentRequest request) {
        return studentRepository.updateStudent(request.getNo(), request.getName());
    }


    @CacheEvict(cacheNames = RedisTTlConstant.minute_1_info, key = "'stu_'+#userInfo.personId")
    public boolean updateUser(StudentRequest request) {
        return studentRepository.updateStudent(request.getNo(), request.getName());
    }

    public boolean deleteUserInfo(int pid) {
        boolean b = studentRepository.deleteUserInfo(pid);
        if (b) {
            String key = "mo::stu_" + pid;
            redisTemplate.delete(key);
        }
        return b;
    }

    /**
     * 这里 CacheEvict 执行逻辑:
     * 和 {@link StudentService #deleteUserInfo(int pid) 逻辑 一致 key 的拼接也是 一致的 }
     *
     * @param personId
     * @return
     */
    @CacheEvict(cacheNames = RedisTTlConstant.minute_1_info, key = "'user_'+#p0")
    public boolean deleteUserInfoCacheEvitEquivalent(int personId) {
        return studentRepository.deleteUserInfo(personId);
    }
}
