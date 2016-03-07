package com.qgen.sys;

import com.qgen.values.QGenValue;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenContext {

    protected QGenEnvironment<QGenValue> valueEnvironment;

    public QGenContext(QGenEnvironment<QGenValue> valueEnv)
    {
        valueEnvironment = valueEnv;
    }

    public QGenContext()
    {
        this(new QGenEnvironment<QGenValue>());
    }

    public QGenEnvironment<QGenValue> getValueEnvironment() {
        return valueEnvironment;
    }
}
