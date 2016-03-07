package com.qgen.lang;

import com.qgen.sys.MoodleXMLBuilder;
import com.qgen.sys.QGenContext;
import com.qgen.sys.QGenException;
import com.qgen.values.QGenValue;

import java.util.List;
import java.util.Random;

/**
 * Created by javon on 06/03/2016.
 */
public class QGenEvaluator implements QGenVisitor<QGenContext,QGenValue> {

    public QGenEvaluator()
    {

    }
    @Override
    public QGenValue visitQGenProgram(QGenProgram program, QGenContext context) throws QGenException {
        QGenTitleExp titleExp = program.getTitleExp();
        QGenTypeExp typeExp = program.getTypeExp();
        QGenCountExp countExp = program.getCountExp();
        List<QGenDefinitionExp> definitionList = program.getDefinitionList();
        QGenBodyExp bodyExp = program.getBodyExp();
        List<QGenAnswerExp> answerList = program.getAnswerList();

        QGenValue titleResult = titleExp.visit(this,context);
        QGenValue typeResult = typeExp.visit(this,context);
        QGenValue countResult = countExp.visit(this,context);

        String title = (String) titleResult.getVal();
        String type = (String) typeResult.getVal();
        int count = (int) countResult.getVal();

        MoodleXMLBuilder builder = new MoodleXMLBuilder();

        for(int i = 0; i <count; i++) {
            //define variables
            for (QGenDefinitionExp definition : definitionList) {
                definition.visit(this, context);
            }

            QGenValue bodyResult = bodyExp.visit(this,context);
            String body = (String) bodyResult.getVal();

            MoodleXMLBuilder.MoodleXMLQuestion question = new MoodleXMLBuilder.MoodleXMLQuestion(title,body,type);

            for(QGenAnswerExp answerExp: answerList)
            {
                QGenValue answerResult = answerExp.visit(this,context);
                MoodleXMLBuilder.MoodleXMLAnswer answer = new MoodleXMLBuilder.MoodleXMLAnswer((String) answerResult.getVal());
                question.addAnswer(answer);
            }
            builder.addQuestion(question);
        }

        QGenValue<String> result = new QGenValue<>(builder.toString());
        return result;
    }

    @Override
    public QGenValue visitQGenTitleExp(QGenTitleExp expTitle, QGenContext context) throws QGenException {
        String title = expTitle.getTitle();
        QGenValue<String> result = new QGenValue<>(title);
        return result;
    }

    @Override
    public QGenValue visitQGenTypeExp(QGenTypeExp expType, QGenContext context) throws QGenException {
        String type = expType.getType();
        QGenValue<String> result = new QGenValue<>(type);
        return result;
    }

    @Override
    public QGenValue visitQGenCountExp(QGenCountExp expCount, QGenContext context) throws QGenException {
        int count = expCount.getCount();
        QGenValue<Integer> result = new QGenValue<>(count);
        return result;
    }

    @Override
    public QGenValue visitQGenDefinitionExp(QGenDefinitionExp expDef, QGenContext context) throws QGenException {
        String name = expDef.getIdentifier();
        QGenExp exp = expDef.getValue();

        QGenValue value = exp.visit(this,context);
        context.getValueEnvironment().put(name,value);

        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenBodyExp(QGenBodyExp expBody, QGenContext context) throws QGenException {
        List<QGenExp> expList = expBody.getExpList();

        //TODO - abstract away
        StringBuilder builder = new StringBuilder();
        for(QGenExp exp: expList)
        {
            builder.append(exp.visit(this,context).getVal()+" ");
        }
        QGenValue<String> result = new QGenValue<>(builder.toString());
        return result;
    }

    @Override
    public QGenValue visitQGenAnsExp(QGenAnswerExp expAns, QGenContext context) throws QGenException {
        List<QGenExp> expList = expAns.getExpList();

        //TODO - abstract away
        StringBuilder builder = new StringBuilder();
        for(QGenExp exp: expList)
        {
            builder.append(exp.visit(this,context).getVal()+" ");
        }
        QGenValue<String> result = new QGenValue<>(builder.toString());
        return result;
    }

    @Override
    public QGenValue visitQGenFunctionCallExp(QGenFunctionCallExp expFunCall, QGenContext context) throws QGenException {
        String name = expFunCall.getName();

        //buitins can go here
        switch (name)
        {
            case "$random":
                int max = 100;
                int min = 1;
                int randomNumber = new Random()
                        .nextInt(max - min + 1) + min;
                QGenValue<Integer> result =  new QGenValue<>(randomNumber);
                return result;
        }
        return QGenValue.NO_RESULT;
    }

    @Override
    public QGenValue visitQGenLookupExp(QGenLookupExp expLookup, QGenContext context) throws QGenException {
        QGenValue result = context.getValueEnvironment().get(expLookup.getIdentifier());
        return result;
    }

    @Override
    public QGenValue visitQGenStringExp(QGenStringExp expString, QGenContext context) throws QGenException {
        String string = expString.getString();
        QGenValue<String> result = new QGenValue<>(string);
        return result;
    }
}
