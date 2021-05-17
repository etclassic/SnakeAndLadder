package com.deserve.SnakeAndLadder.Service;

import com.deserve.SnakeAndLadder.model.DiceType;
import com.deserve.SnakeAndLadder.service.DiceService;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class DiceServiceTest{

    @Test
    public void testRoll() {
        List<Integer> normalDice = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> crookedDice = Arrays.asList(2,4,6);

        // Normal dice range should be in between 1-6
        assertThat(normalDice, hasItems(DiceService.roll(DiceType.NORMAL_DICE)));

        // Crooked dice should have values {2,4,6}
        assertThat(crookedDice, hasItems(DiceService.roll(DiceType.CROOKED_DICE)));
    }
}