package ua.edu.ucu.smartarr;

import java.util.Arrays;


// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] myArray;

    public BaseArray(Object[] arr) {
        this.myArray = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public Object[] toArray() // return array with SmartArray elements
    {
        return Arrays.copyOf(myArray, myArray.length);
    }

    @Override
    public String operationDescription() // return current operation name applied to SmartArray
    {
        return "BaseArray";
    }

    @Override
    public int size() // return SmartArray size
    {
        return myArray.length;
    }
}
