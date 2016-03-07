package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenCountExp extends QGenExp{

    private int count;

    public QGenCountExp(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenCountExp(this,context);
    }

    @Override
    public String toString() {
        return "Count expression";
    }
}
