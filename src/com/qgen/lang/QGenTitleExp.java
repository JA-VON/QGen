package com.qgen.lang;

import com.qgen.sys.QGenException;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenTitleExp extends QGenExp{

    private String title;

    public QGenTitleExp(String title) {
        System.out.println("Title:"+title);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenTitleExp(this,context);
    }

    @Override
    public String toString() {
        return "Title expression";
    }
}
