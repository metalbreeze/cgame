package com.cgame.util;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder ;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
	@Autowired
    private static PasswordEncoder passwordEncoder;

    private static final AtomicInteger sequence = new AtomicInteger(1);

    public static String generate() {
        String random = RandomUtil.generateRandomNumber(10) + System.currentTimeMillis();
        return passwordEncoder.encode(random);
    }

    public static String generateAppkey() {
    	return RandomUtil.generateRandomNumber(24);
    }
    
    public static String generateMasterSecret() {
    	return RandomUtil.generateRandomNumber(24);
    }
    /**
     * 生成唯一索引
     */
    public static Integer getSequenceId() {
        int sequenceId = sequence.getAndIncrement();
        //序列最大值,超过后,复位序列
        if (sequenceId > Integer.MAX_VALUE - 1000) {
            synchronized (sequence) {
                //其set()方法不是原子方法.
                sequence.set(1);
            }
        }

        return sequenceId;
    }

    public static void main(String[] args) {
        System.out.println(TokenUtil.generateAppkey());
        System.out.println(TokenUtil.generateMasterSecret());
    }
}
