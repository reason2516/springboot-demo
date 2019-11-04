package com.wmx.demo.springbootdemo.controller;

import com.wmx.demo.springbootdemo.common.ResponseDTO;
import com.wmx.demo.springbootdemo.dao.UserDao;
import com.wmx.demo.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * GET + param 如："/user/getByPhoneNumber?phoneNumber=18801010101"
     * "curl -XGET localhost:8080/user/getByPhoneNumber?phoneNumber=18801010101"
     * @param phoneNumber
     * @return
     */
    @GetMapping("/getByPhoneNumber")
    public ResponseDTO<User> getByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        User user = userDao.findByPhoneNumber(phoneNumber);
        return ResponseDTO.ok(user);
    }

    /**
     * POST+ postJson 如："/user/add {"phoneNumber":"18801010101","password":"123456"}"
     * "curl -XPOST -H"content-type:application/json" localhost:8080/user/add --data '{"phoneNumber":"18801010101","password":"123456"}'"
     * @param user
     * @return
     */
    @PostMapping("/add")
    public ResponseDTO<User> add(@RequestBody User user) {
        user.setId(null);
        user.setStatus(1);
        user.setRegisterTime(new Date());
        user.setSalt("test11");
        userDao.save(user);
        return ResponseDTO.ok(user);
    }
}
