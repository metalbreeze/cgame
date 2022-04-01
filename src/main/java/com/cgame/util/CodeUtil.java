package com.cgame.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class CodeUtil {

	public static String stringToMd5(String str) {
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}

    public static byte[] byteToMd5(byte[] bytes) {
        return DigestUtils.md5Digest(bytes);
    }


}
