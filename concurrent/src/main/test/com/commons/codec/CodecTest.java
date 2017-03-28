package com.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class CodecTest {
	@Test
	public void md5Test(){
		System.out.println(DigestUtils.md5Hex("测试使用"));
	}
}
