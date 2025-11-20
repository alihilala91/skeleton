package com.ali.skeletonV1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
class SkeletonV1ApplicationTests {

	@Test
	void contextLoads() {
	}

}
