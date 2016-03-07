package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenStringExp  extends QGenExp{

    private String string;

    public QGenStringExp(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenStringExp(this,context);
    }

    @Override
    public String toString() {
        return "String expression";
    }
}
