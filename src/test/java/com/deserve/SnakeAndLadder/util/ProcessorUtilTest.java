package com.deserve.SnakeAndLadder.util;

import com.deserve.SnakeAndLadder.model.Snake;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ProcessorUtilTest extends TestCase {

    List<Snake> snakes = new ArrayList<>();
    @Override
    protected void setUp() throws Exception {
        snakes.add(new Snake(12,6));
        snakes.add(new Snake(20,16));
    }

    public void testSnakeCheck() {
        assertEquals(6, ProcessorUtil.snakeCheck(12, snakes));
        assertEquals(16, ProcessorUtil.snakeCheck(20, snakes));
    }
}