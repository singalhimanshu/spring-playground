package com.github.spring_playground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpelPlaygroundTest {
    @Autowired
    private SpelPlayground spelPlayground;

    @Test
    public void testRun() throws NoSuchMethodException {
        final List<Object> list = (List<Object>) spelPlayground.run();
        System.out.println(list);
    }
}