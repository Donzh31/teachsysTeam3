package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.UserEntity;
import com.se.tss.forum.Models.User;
import com.se.tss.forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/bbs/user/{uid}")
    public User getUser(@PathVariable Integer uid) {
        UserEntity u = userService.findByUid(uid);
        return u.getUser();
    }

}

