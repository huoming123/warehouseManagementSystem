package com.design.warehouseManagementSystem.service;

import com.design.warehouseManagementSystem.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UpLoadService {
    RestFulBean<Map> upload(MultipartFile coverFile);
}
