package com.sparta.springcore.service;

import com.sparta.springcore.model.Folder;
import com.sparta.springcore.model.Product;
import com.sparta.springcore.model.Users;
import com.sparta.springcore.repository.FolderRepository;
import com.sparta.springcore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FolderService {

    private final FolderRepository folderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public FolderService(
            FolderRepository folderRepository,
            ProductRepository productRepository) {
        this.folderRepository = folderRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public List<Folder> addFolders(List<String> folderNames, Users user) {

        List<Folder> existFolderList = folderRepository.findAllByUserAndNameIn( user , folderNames );

        List<Folder> folderList = new ArrayList<>();
        for( String foldername : folderNames ){
            if( !isExistFolderName( foldername , existFolderList ) ){
                Folder folder = new Folder( foldername , user );
                folderRepository.save( folder );
                folderList.add( folder );
            } else{
                throw new IllegalArgumentException("중복된 폴더명을 제거해주세요!");
            }
        }
        return folderList;
    }

    private boolean isExistFolderName(String foldername, List<Folder> existFolderList) {
        for( Folder existFolder : existFolderList ){
            if( existFolder.getName().equals( foldername ) ){
                return true;
            }
        }
        return false;
    }

    public List<Folder> getFolders(Users user) {

        return folderRepository.findAllByUser( user );

    }

    public Page<Product> getProductInFolder(
            Long folderId,
            int page,
            int size,
            String sortBy,
            boolean isAsc,
            Users user
    ) {

        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by( direction , sortBy );
        Pageable pageable = PageRequest.of( page , size ,sort );

        return productRepository.findAllByUserIdAndFolderList_Id(
                user.getId(), folderId, pageable  );
    }
}
