package com.example.devops_tp1;

import com.example.devops_tp1.controller.HelloController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DevopsTp1ApplicationTests {

    @Autowired
    private HelloController helloController;

	@Test
	void contextLoads() {
        assertThat(helloController).isNotNull();
	}

    @Test
    void testHelloService() {
        String result = helloController.hello();
        assertThat(result).isEqualTo("hello");
    }
}
