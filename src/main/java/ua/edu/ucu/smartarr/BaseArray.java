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

    // return current operation name applied to SmartArray
    @Override
    public String operationDescription()
    {
        return "BaseArray";
    }

    @Override
    public int size() // return SmartArray size
    {
        return myArray.length;
    }

    public void setValue(int index, Object value) { myArray[index] = value;}
}
