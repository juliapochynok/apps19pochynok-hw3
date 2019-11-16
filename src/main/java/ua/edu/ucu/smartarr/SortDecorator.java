package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
        // compare();
    }

    private Object[] compare() {
        Object[] newArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        Arrays.sort(newArray, comparator);
        return newArray;
    }

    @Override
    public Object[] toArray() // return array with SmartArray elements
    {
        return compare();
    }

    // return current operation name applied to SmartArray
    @Override
    public String operationDescription()
    {
        return "Sort Decorator, sorts elements using MyComparator";
    }

    @Override
    public int size() // return SmartArray size
    {
        return compare().length;
    }

}

