package com.sparta.springcore.service;

import com.sparta.springcore.model.Folder;
import com.sparta.springcore.model.Users;
import com.sparta.springcore.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;

    @Autowired
    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public List<Folder> addFolders(List<String> folderNames, Users user) {

        List<Folder> folderList = new ArrayList<>();
        for( String foldername : folderNames ){
            Folder folder = new Folder( foldername , user );
            folderList.add( folder );
        }
        return folderRepository.saveAll( folderList );
    }

    public List<Folder> getFolders(Users user) {

        return folderRepository.findAllByUser( user );

    }
}
