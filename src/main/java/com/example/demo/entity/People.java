package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class People {
    @ExcelProperty(value = "姓名", index = 0)
    @Size(min = 5)
    private String name;

    @ExcelProperty(value = "手机号", index = 1)
    private String phone;

    @ExcelProperty(value = "地址", index = 2)
    private String address;
}
