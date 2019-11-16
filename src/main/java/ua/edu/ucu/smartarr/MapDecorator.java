package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private MyFunction function;
    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    private Object[] map() {
        Object[] newArray = Arrays.copyOf(smartArray.toArray(),
                smartArray.size());
        for (int i = 0; i < newArray.length; i++) {
                newArray[i] = function.apply(newArray[i]);
            }
        return newArray;
        }

    @Override
    public Object[] toArray() // return array with SmartArray elements
    {
        return map();
    }

    // return current operation name applied to SmartArray
    @Override
    public String operationDescription()
    {
        return "Map Decorator, Map every element to another object";
    }

    @Override
    public int size() // return SmartArray size
    {
        return map().length;
    }
}

