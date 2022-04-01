package com.cgame.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgame.dto.ResultDTO;
import com.cgame.entity.Platform;
import com.cgame.form.LoginForm;
import com.cgame.repository.PlatformRepository;
import com.cgame.util.CodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "ccnu Game interface")
@RestController
@RequestMapping("/v1")
@Slf4j
public class ApiController {

	@Autowired
	private PlatformRepository platformRepository;

	@ApiOperation(value = "发送消息", httpMethod = "POST", notes = "可以任意，可以用来验证连通性", response = ResultDTO.class)
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "platformId", value = "平台id", example = "1000", required = true, dataTypeClass = Long.class, paramType = "query"),
//			@ApiImplicitParam(name = "timestamp", value = "毫秒数", example = "1648056198000", required = true, dataTypeClass = Long.class, paramType = "query"),
//			@ApiImplicitParam(name = "token", value = "签名:平台key + msgId + 当前毫秒数,做MD5，32,小写", example = "ASDFWEWRTERTFGSDFGSDFGD", required = true, dataTypeClass = String.class, paramType = "query"),
//			@ApiImplicitParam(name = "msgId", value = "消息UUID ,随机生成", example = "UUID-234ADF234EWR", required = true, dataTypeClass = String.class, paramType = "query"),
//			@ApiImplicitParam(name = "msg", value = "短信消息", dataTypeClass = String.class, paramType = "query") })
	@PostMapping(value = "/login", produces = "application/json;charset=utf-8")
	public ResultDTO messages(@Valid @RequestBody LoginForm sendSmsForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultDTO.fail_binding;
		}
		if (!isValidSign(sendSmsForm)) {
			return ResultDTO.fail_platform;
		}
		return ResultDTO.success;
	}

	private boolean isValidSign(LoginForm r) {
		Long id = r.getPlatformId();
		String msgId = r.getMsgId();
		String token = r.getToken();
		Long timestamp = r.getTimestamp();
		Platform p = platformRepository.getById(id);
		if (null == p) {
			log.info("平台id不匹配.id={}", id);
			return false;
		}
		String realSign = CodeUtil.stringToMd5(p.getMasterSecret() + msgId + timestamp);
		if (!token.equals(realSign)) {
			log.info("签名不匹配.currentSign={}", token);
			return false;
		}
		log.debug("isValidSign realSign{}", realSign);
		return true;
	}
}
