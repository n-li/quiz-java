package com.topa.quiz.list;

class Element {

    private int value;

    private Element nextElement;

    Element(int value) {
        this.value = value;
    }

    void setNextElement(Element nextElement) {
        this.nextElement = nextElement;
    }

    Element getNextElement() {
        return nextElement;
    }

    int getValue() {
        return value;
    }
}
