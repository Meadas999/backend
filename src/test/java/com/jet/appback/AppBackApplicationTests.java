package com.jet.appback;

import com.jet.appback.services.NuserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppBackApplicationTests {

	@Test
	void contextLoads() {
		NuserService nuserService = new NuserService();
	}

	@Test
	void LoadUserwithemail()
	{

	}

}
