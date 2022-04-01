package com.cgame.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
	@NotNull(message = "平台Id不能为空")
	@Range(min = 1, max = 9999,message = "平台id不符合规范")
	@ApiModelProperty(example = "1000",value = "平台id")
	private Long platformId;//平台id
	
	@NotBlank(message = "签名不能为空")
	@Length(min = 32, max = 32, message = "签名必须为32位")
	@ApiModelProperty(example = "ASDFWEWRTERTFGSDFGSDFGD", value = "签名:平台key + msgId + 当前毫秒数,做MD5，32,小写")
	private String token;//签名； MD5(平台key + 手机号 + 当前毫秒数),32,小写
	
	@NotNull(message = "毫秒数不能为空")
	@ApiModelProperty(example = "1648056198000", value = "毫秒数")
	private Long timestamp;
	
	@NotBlank(message = "消息编码不能为空")
	@Length(min = 20,message = "消息编码不符合规范,小于20位")
	@ApiModelProperty(example = "UUID-234ADF234EWR",value = "消息UUID ,随机生成")
	private String msgId;//消息编码
	
	@NotBlank(message = "短信消息不能为空")
	@ApiModelProperty(example = "test",value = "短信消息")
	private String msg;//短信消息[]， !&间隔
}
