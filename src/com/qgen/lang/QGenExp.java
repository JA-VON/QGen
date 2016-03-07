package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public abstract class QGenExp {
    public abstract <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException;

    public abstract String toString();
}
