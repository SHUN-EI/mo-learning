package com.mo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mo on 2023/11/24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptLogDTO {

    private String requestIp; //操作IP
    private String type; //日志类型 LogType{OPT:操作类型;EX:异常类型}
    private String userName; //操作人
    private String description; //操作描述
}
