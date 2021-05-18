package com.deserve.SnakeAndLadder.util;

import com.deserve.SnakeAndLadder.model.Snake;
import com.deserve.SnakeAndLadder.model.SnakeType;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ProcessorUtilTest extends TestCase {

    List<Snake> snakes = new ArrayList<>();
    @Override
    protected void setUp() throws Exception {
        snakes.add(new Snake(12,6, SnakeType.NORMAL));
        snakes.add(new Snake(20,16, SnakeType.ONE_BITE_SNAKE));
    }

    public void testSnakeCheck() {
        assertEquals(6, ProcessorUtil.snakeCheck(12, snakes));
        assertEquals(16, ProcessorUtil.snakeCheck(20, snakes));
    }
}