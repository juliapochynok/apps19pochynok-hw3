package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        makeDistinct();
    }

    private Object[] makeDistinct() {
        Object[] finalArray = new Object[smartArray.size()];
        int currIndex = 0;
        Object[] newArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        for (Object o : newArray) {
            if (!includes(finalArray, o)) {
                finalArray[currIndex] = o;
                currIndex++;
            }
        }
        return Arrays.copyOf(finalArray, currIndex);
    }

    private boolean includes(Object[] array, Object value) {
        for (Object el: array) {
            if (el != null && value.toString().equals(el.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() // return array with SmartArray elements
    {
        return makeDistinct();
    }

    // return current operation name applied to SmartArray
    @Override
    public String operationDescription()
    {
        return "Distinct Decorator";
    }

    @Override
    public int size() // return SmartArray size
    {
        return makeDistinct().length;
    }

}
