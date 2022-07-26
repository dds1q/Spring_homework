package com.sparta.springcore.controller;

import com.sparta.springcore.model.Folder;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sparta.springcore.model.UserRoleEnum;

import java.util.List;


@Controller
public class HomeController {

    private final FolderService folderService;

    @Autowired
    public HomeController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if (userDetails.getUsers().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        List<Folder> folders = folderService.getFolders( userDetails.getUsers() );

        model.addAttribute( "folders" , folders );

        return "index";
    }
}