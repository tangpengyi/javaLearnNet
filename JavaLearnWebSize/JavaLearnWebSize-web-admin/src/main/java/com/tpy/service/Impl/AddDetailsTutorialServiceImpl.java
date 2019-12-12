package com.tpy.service.Impl;

import com.tpy.dao.instanceMapper;
import com.tpy.entity.DetailsTutorial;
import com.tpy.entity.ExampleTutorial;
import com.tpy.entity.User;
import com.tpy.service.AddDetailsTutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AddDetailsTutorialServiceImpl implements AddDetailsTutorialService {
    

    private instanceMapper mapper;

    @Autowired
    public void setMapper(instanceMapper mapper){
        this.mapper = mapper;
    }
    
    @Override
    public int addDetailsTutorialService(DetailsTutorial detailsTutorial, String path, MultipartFile file, User user,AddExampleTutorialServiceImpl addDetailsTutorialService) throws IOException {
        //获取详情实例共数量
        int i = mapper.queryMaxdetailstutorialCount();
        //设置当前编号
        detailsTutorial.setDtNum(i+1);
        int isSucces = mapper.insertDetailstutorial(detailsTutorial);

        if(isSucces > 0){
            file.transferTo(new File(path));

            ExampleTutorial exampleTutorial = new ExampleTutorial();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            exampleTutorial.setUploadTime(df.format(new Date()));//设置时间

            exampleTutorial.setDtNum(i+1);//设置详情实例编号

            exampleTutorial.setUserId(user.getUserId());//设置用户编号
            int isSuccess = addDetailsTutorialService.addExampleTutorialService(exampleTutorial);

            return isSucces;
        }

        //插入失败返回0
        return 0;
    }
}
