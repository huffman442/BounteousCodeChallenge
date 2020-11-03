package main;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class avgCalcTest {
    /* Testing the following cases:
        - Empty List
        - List with one item
        - Provided list(also odd)
        - Even-sized List
        - List with just zero
     */
    List<Integer> emptyList = new ArrayList<>();
    List<Integer> oneItemList = new ArrayList<>();
    List<Integer> exampleList = new ArrayList<>();
    List<Integer> evenCountList = new ArrayList<>();
    List<Integer> zeroList = new ArrayList<>();

    avgCalc oneItemCalc;
    avgCalc exampleCalc;
    avgCalc emptyListCalc;
    avgCalc zeroCalc;
    avgCalc evenCountCalc;

    public avgCalcTest(){
        oneItemList.add(5);
        oneItemCalc = new avgCalc(oneItemList);

        exampleList.add(3);
        exampleList.add(1);
        exampleList.add(100);
        exampleList.add(50);
        exampleList.add(7);

        exampleCalc = new avgCalc(exampleList);

        emptyListCalc = new avgCalc(emptyList);

        zeroList.add(0);
        zeroCalc = new avgCalc(zeroList);

        evenCountList.add(4);
        evenCountList.add(532);
        evenCountList.add(52);
        evenCountList.add(35);

        evenCountCalc = new avgCalc(evenCountList);
    }

    @Test
    void getMean() {
        assertEquals(null , emptyListCalc.getMean());
        assertEquals(BigDecimal.valueOf(5.00).setScale(2) , oneItemCalc.getMean());
        assertEquals(BigDecimal.valueOf(32.20).setScale(2) , exampleCalc.getMean());
        assertEquals(BigDecimal.valueOf(155.75).setScale(2) , evenCountCalc.getMean());
        assertEquals(BigDecimal.valueOf(0).setScale(2) , zeroCalc.getMean());
    }

    @Test
    void getMin() {
        assertEquals(0 , emptyListCalc.getMin());
        assertEquals(5 , oneItemCalc.getMin());
        assertEquals(1 , exampleCalc.getMin());
        assertEquals(4 , evenCountCalc.getMin());
        assertEquals(0 , zeroCalc.getMin());
    }

    @Test
    void getMax() {
        assertEquals(0 , emptyListCalc.getMax());
        assertEquals(5 , oneItemCalc.getMax());
        assertEquals(100, exampleCalc.getMax());
        assertEquals(532 , evenCountCalc.getMax());
        assertEquals(0, zeroCalc.getMax());
    }

    @Test
    void getCount() {
        assertEquals(0, emptyListCalc.getCount());
        assertEquals(oneItemList.size() , oneItemCalc.getCount());
        assertEquals(exampleList.size(), exampleCalc.getCount());
        assertEquals(evenCountList.size() , evenCountCalc.getCount());
        assertEquals(zeroList.size() , zeroCalc.getCount());
    }

    @Test
    void getMedian() {
        assertEquals(null , emptyListCalc.getMean());
        assertEquals(BigDecimal.valueOf(5).setScale(2) , oneItemCalc.getMedian());
        assertEquals(BigDecimal.valueOf(7).setScale(2) , exampleCalc.getMedian());
        assertEquals(BigDecimal.valueOf(43.5).setScale(2) , evenCountCalc.getMedian());
        assertEquals(BigDecimal.valueOf(0).setScale(2) , zeroCalc.getMedian());
    }
}