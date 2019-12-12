package com.tpy.service;

import com.tpy.entity.DetailsTutorial;
import com.tpy.entity.User;
import com.tpy.service.Impl.AddExampleTutorialServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AddDetailsTutorialService {

    /**
     * 增加详情实例
     * @param detailsTutorial
     * @return
     */
    public int addDetailsTutorialService(DetailsTutorial detailsTutorial, String path, MultipartFile file, User user, AddExampleTutorialServiceImpl addDetailsTutorialService) throws IOException;

}
