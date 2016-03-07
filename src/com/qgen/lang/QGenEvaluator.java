package com.qgen.lang;

import com.qgen.sys.QGenContext;
import com.qgen.sys.QGenException;
import com.qgen.values.QGenValue;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenEvaluator implements QGenVisitor<QGenContext,QGenValue> {

    public QGenEvaluator()
    {

    }
    @Override
    public QGenValue visitQGenProgram(QGenProgram program, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenTitleExp(QGenTitleExp expTitle, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenTypeExp(QGenTypeExp expType, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenCountExp(QGenCountExp expCount, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenDefinitionExp(QGenDefinitionExp expDef, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenBodyExp(QGenBodyExp expBody, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenAnsExp(QGenAnswerExp expAns, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenLookupExp(QGenLookupExp expLookup, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenStringExp(QGenStringExp expString, QGenContext context) throws QGenException {
        return QGenValue.NO_RESULT;
    }
}
