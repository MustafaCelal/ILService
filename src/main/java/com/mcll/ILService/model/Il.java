package com.mcll.ILService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Il {
    @Id
    private String id;
    private Date createDate=new Date();
    private String name;
}
