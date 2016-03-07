package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenLookupExp extends QGenExp{
    private String identifier;

    public QGenLookupExp(String identifier) {
        System.out.println("lookup:"+identifier);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenLookupExp(this,context);
    }

    @Override
    public String toString() {
        return "Lookup expression";
    }
}
