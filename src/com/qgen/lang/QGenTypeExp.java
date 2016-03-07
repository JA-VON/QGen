package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenTypeExp extends QGenExp{

    private String type;

    public QGenTypeExp(String type) {
        System.out.println("Type:"+type);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenTypeExp(this,context);
    }

    @Override
    public String toString() {
        return "Type expression";
    }
}
