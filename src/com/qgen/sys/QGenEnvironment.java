package com.qgen.sys;

import java.util.HashMap;

/**
 * Created by javon on 07/03/2016.
 */
public class QGenEnvironment<T> {

    HashMap<String, T> dictionary;

    public QGenEnvironment() {
        dictionary = new HashMap<>();
    }

    public void put(String id, T value) {
        dictionary.put(id,value);
    }

    public T get(String id) throws QGenException {
        T result = dictionary.get(id);
        if(result == null)
        {
            throw new QGenException("Unbound variable "+id);
        }
        else
        {
            return result;
        }
    }

    /**
     * Create a string representation of this SMPL environment.
     *
     * @return a string of all the names bound in this environment.
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();

        for (String name : dictionary.keySet()) {
            result = result.append(name);
            result = result.append(" ");
        }
        return result.toString();
    }
}
