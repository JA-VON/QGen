package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public interface QGenVisitor<S, T> {

    //Top level
    T visitQGenProgram(QGenProgram program, S context) throws QGenException;

    // Template Components
    T visitQGenTitleExp(QGenTitleExp expTitle, S context) throws QGenException;
    T visitQGenTypeExp(QGenTypeExp expType, S context) throws QGenException;
    T visitQGenCountExp(QGenCountExp expCount, S context) throws QGenException;
    T visitQGenDefinitionExp(QGenDefinitionExp expDef, S context) throws QGenException;
    T visitQGenBodyExp(QGenBodyExp expBody, S context) throws QGenException;
    T visitQGenAnsExp(QGenAnswerExp expAns, S context) throws QGenException;

    T visitQGenLookupExp(QGenLookupExp expLookup, S context) throws QGenException;

    //Primitives
    T visitQGenStringExp(QGenStringExp expString, S context) throws QGenException;
}
