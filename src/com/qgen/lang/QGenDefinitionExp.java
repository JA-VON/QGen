package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenDefinitionExp extends QGenExp{

    private String identifier;
    private String value; //temp value for now as string

    public QGenDefinitionExp(String identifier, String value) {
        this.identifier = identifier;
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenDefinitionExp(this,context);
    }

    @Override
    public String toString() {
        return "Definition expression";
    }
}
