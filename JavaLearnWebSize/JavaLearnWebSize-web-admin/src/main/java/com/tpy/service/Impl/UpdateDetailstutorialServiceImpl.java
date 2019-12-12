package com.tpy.service.Impl;

import com.tpy.dao.instanceMapper;
import com.tpy.service.UpdateDetailstutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UpdateDetailstutorialServiceImpl implements UpdateDetailstutorialService {

    private instanceMapper mapper;
    @Autowired
    public void setMapper(instanceMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public boolean deleteExampleTutorialService(int dtNum, int tutorialNum) {
        int i = mapper.deleteDetailstutorialByNum(dtNum);
        if(i == 0){
            return false;
        }
        int isDelete = mapper.deleteexampleTutorialByNum(tutorialNum);
        if(isDelete == 0){
            //回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return true;
    }
}
