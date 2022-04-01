package com.cgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO<T> {
    public static final ResultDTO fail_binding = new ResultDTO("err-1","error in binding");
	public static final ResultDTO fail_platform = new ResultDTO("err-2","error in validation");
    public static final ResultDTO<String> success  =  new ResultDTO<String>(0,"成功");
    public static final ResultDTO<String> fail  =  new ResultDTO<String>(21,"失败");
    public static final ResultDTO<String> fail_unknown  =  new ResultDTO<String>(3,"未知异常");
	/**状态码*/
    private String code;
    /**消息*/
    private String message;
    /**数据*/
    private T data;

    public ResultDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public ResultDTO(int code, String message) {
        this.code = Integer.toString(code) ;
        this.message = message;
    }

}
