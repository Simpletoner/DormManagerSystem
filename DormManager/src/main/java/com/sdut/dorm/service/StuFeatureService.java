package com.sdut.dorm.service;

import com.sdut.dorm.bean.StuFeature;
import com.sdut.dorm.dao.StuFeatureDao;
import com.sdut.dorm.util.KMeans;
import com.sdut.dorm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StuFeatureService {
    @Autowired(required = false)
    StuFeatureDao stuFeatureDao;

    public Result getKMeans(int k, double mu, int repeat, int len){
        Result result  = new Result();
        KMeans kMeans = new KMeans(k, mu, repeat, len);
        result.setData(kMeans);
        result.setSuccess(true);
        return result;
    }
    public Double oushijuli(Double x1,Double x2,Double y1,Double y2,Double z1,Double z2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)+(z1-z2)*(z1-z2));
    }

}
