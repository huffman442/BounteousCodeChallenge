package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

public class avgCalc {
    private int min;
    private int max;
    private BigDecimal mean;
    private BigDecimal median;
    private int count;
    private boolean isEven;
    private boolean isEmpty;
    private int sum = 0;

    public avgCalc(List<Integer> calcList) {
        int first = 0;
        int last = calcList.size() - 1;

        count = calcList.size();

        if(!calcList.isEmpty()) {
            Collections.sort(calcList);
            min = calcList.get(first);
            max = calcList.get(last);
            for (Integer num : calcList) {
                sum += num;
            }
            checkEven();
            setMean();
            setMedian(calcList);
            isEmpty = false;
        } else {
            isEmpty = true;
        }
    }

    private void checkEven() { if(count % 2 == 0) isEven = true; }

    public int getMin(){ return min; }

    public int getMax(){ return max; }

    public int getCount() { return count; }

    private void setMean() {
        BigDecimal bdSum = BigDecimal.valueOf(sum);
        BigDecimal bdCount = BigDecimal.valueOf(count);
        mean = bdSum.divide(bdCount, 2, RoundingMode.CEILING);
    }


    public BigDecimal getMean() { return mean; }

    private void setMedian(List<Integer> medianList) {
        int middle = count/2;
        int middlePair = count/2 - 1;
        if(isEven) {
            int quickSum = medianList.get(middle) + medianList.get(middlePair);
            median = BigDecimal.valueOf(quickSum).divide(BigDecimal.valueOf(2.0),2, RoundingMode.CEILING);
        } else {
            median = BigDecimal.valueOf(medianList.get(middle)).setScale(2, RoundingMode.CEILING);
        }
    }
    public BigDecimal getMedian() { return median; }

    public boolean getIsEmpty() {
        return isEmpty;
    }
}
