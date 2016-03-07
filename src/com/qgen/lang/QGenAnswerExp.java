package com.qgen.lang;

import com.qgen.sys.QGenException;

import java.util.ArrayList;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenAnswerExp extends QGenExp{

    private ArrayList<QGenExp> expList;

    public QGenAnswerExp(ArrayList<QGenExp> expList) {
        this.expList = expList;
    }

    public ArrayList<QGenExp> getExpList() {
        return expList;
    }

    public void setExpList(ArrayList<QGenExp> expList) {
        this.expList = expList;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenAnsExp(this,context);
    }

    @Override
    public String toString() {
        return "Answer Expression";
    }
}
