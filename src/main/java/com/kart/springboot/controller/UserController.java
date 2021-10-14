package com.kart.springboot.controller;

import com.kart.springboot.dto.UserDTO;
import com.kart.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.kart.springboot.converter.UserConverter.dtoToUser;


@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String createUser(Map<String, Object> model) {
        model.put("userDTO", new UserDTO());
        return "userRegistrator";
    }

    @PostMapping("/home")
    public String createUser(@ModelAttribute("userDto") UserDTO userDTO) {
        userService.createUpdateUser(dtoToUser(userDTO));
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") String id) throws Exception {
        userService.deleteUser(Long.parseLong(id));
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        List<UserDTO> userList = userService.getAll();
        model.addAttribute("userList", userList);
        return "userList";
    }
}
