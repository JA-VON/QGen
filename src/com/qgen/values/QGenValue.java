package com.qgen.values;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenValue<T> {

    public static QGenValue<String> NO_RESULT = new QGenValue<>("NO RESULT");

    private T val;

    public QGenValue() {
    }

    public QGenValue(T val)
    {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}
