package com.qgen.lang;

import com.qgen.sys.QGenException;

import java.util.ArrayList;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenTitleExp extends QGenExp{

    private ArrayList<String> title;

    public QGenTitleExp(ArrayList<String> title) {
        StringBuilder sb = new StringBuilder();
        for (String s : title)
            sb.append(s + " ");

        System.out.println("Title:" + sb.toString());
        this.title = title;
    }

    public ArrayList<String> getTitle() {
        return title;
    }

    @Override
    public <S, T> T visit(QGenVisitor<S, T> v, S context) throws QGenException {
        return v.visitQGenTitleExp(this,context);
    }

    @Override
    public String toString() {
        return "Title Expression";
    }
}
