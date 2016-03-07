package com.qgen.lang;

import com.qgen.sys.QGenException;

import java.util.ArrayList;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenProgram extends QGenExp {

    private QGenTitleExp titleExp;
    private QGenTypeExp typeExp;
    private QGenCountExp countExp;
    private ArrayList<QGenDefinitionExp> definitionList;
    private QGenBodyExp bodyExp;
    private ArrayList<QGenAnswerExp> answerList;

    public QGenProgram(QGenTitleExp titleExp, QGenTypeExp typeExp, QGenCountExp countExp, ArrayList<QGenDefinitionExp> definitionList, QGenBodyExp bodyExp, ArrayList<QGenAnswerExp> answerList) {
        this.titleExp = titleExp;
        this.typeExp = typeExp;
        this.countExp = countExp;
        this.definitionList = definitionList;
        this.bodyExp = bodyExp;
        this.answerList = answerList;
    }

    public QGenTitleExp getTitleExp() {
        return titleExp;
    }

    public void setTitleExp(QGenTitleExp titleExp) {
        this.titleExp = titleExp;
    }

    public QGenCountExp getCountExp() {
        return countExp;
    }

    public void setCountExp(QGenCountExp countExp) {
        this.countExp = countExp;
    }

    public ArrayList<QGenDefinitionExp> getDefinitionList() {
        return definitionList;
    }

    public void setDefinitionList(ArrayList<QGenDefinitionExp> definitionList) {
        this.definitionList = definitionList;
    }

    public QGenBodyExp getBodyExp() {
        return bodyExp;
    }

    public void setBodyExp(QGenBodyExp bodyExp) {
        this.bodyExp = bodyExp;
    }

    public ArrayList<QGenAnswerExp> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<QGenAnswerExp> answerList) {
        this.answerList = answerList;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenProgram(this,context);
    }

    @Override
    public String toString() {
        return "Program expression";
    }

    public QGenTypeExp getTypeExp() {
        return typeExp;
    }

    public void setTypeExp(QGenTypeExp typeExp) {
        this.typeExp = typeExp;
    }
}
