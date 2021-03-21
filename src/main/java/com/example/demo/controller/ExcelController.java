package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.example.demo.entity.People;
import com.example.demo.read.PeopleDataListener;
import com.example.demo.service.ExcelService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController("/list")
@Slf4j
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @ApiOperation(value = "上传excel", httpMethod = "POST")
    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), People.class, new PeopleDataListener()).sheet().doRead();
    }

    @GetMapping("/get")
    public List<String> list() {
        return excelService.list();
    }
}
