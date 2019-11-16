package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    private Object[] filter() {
        Object[] newArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        Object[] finalArray = new Object[smartArray.size()];
        int currIndex = 0;

        for (int i = 0; i < newArray.length; i++) {
            if (predicate.test(newArray[i])) {
                finalArray[currIndex] = newArray[i];
                currIndex++;
            }
        }
        return Arrays.copyOf(finalArray, currIndex);
    }

    @Override
    public Object[] toArray() //return array with SmartArray elements
    {
        return filter();
    }

    // return current operation name applied to SmartArray
    @Override
    public String operationDescription()
    {
        return "Filter Decorator, removes element if" +
                " it doesn't satisfy predicate";
    }

    @Override
    public int size() // return SmartArray size
    {
        return filter().length;
    }
}
