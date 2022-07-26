package com.sparta.springcore.controller;

import com.sparta.springcore.dto.FolderRequestDto;
import com.sparta.springcore.model.Folder;
import com.sparta.springcore.model.Product;
import com.sparta.springcore.model.UserRoleEnum;
import com.sparta.springcore.model.Users;
import com.sparta.springcore.security.UserDetailsImpl;
import com.sparta.springcore.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {

    private final FolderService folderService;

    @Autowired
    public FolderController( FolderService folderService ){
        this.folderService = folderService;
    }

    @PostMapping("/api/folders")
    public List<Folder> addFolders(
            @RequestBody FolderRequestDto folderRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
            ){

        List<String> folderNames = folderRequestDto.getFolderNames();
        Users user = userDetails.getUsers();

        return folderService.addFolders( folderNames , user  );
    }

    @GetMapping("/api/folders")
    public List<Folder> getFolders(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
       return folderService.getFolders( userDetails.getUsers() );
    }

    @GetMapping("/api/folders/{folderId}/products")
    public Page<Product> getProductsInFolder(
            @PathVariable Long folderId,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        page -= 1;
        return folderService.getProductInFolder(
                folderId ,
                page ,
                size ,
                sortBy ,
                isAsc ,
                userDetails.getUsers()
        );

    }

}
