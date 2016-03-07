package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 07/03/2016.
 */
public class QGenFunctionCallExp extends QGenExp{

    private String name;

    public QGenFunctionCallExp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenFunctionCallExp(this,context);
    }

    public String toString()
    {
        return "Function call expression";
    }
}
