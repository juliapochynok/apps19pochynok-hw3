package ua.edu.ucu.smartarr;

public interface SmartArray {

    Object[] toArray(); // return array with SmartArray elements

    // return current operation name applied to SmartArray
    String operationDescription();
    
    int size(); // return SmartArray size
   
}
