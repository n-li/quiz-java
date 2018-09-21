package com.topa.quiz.list;

public class IntLinkedList {

    private Element first;
    private Element last;

    private int size = 0;

    public void add(int value) {
        if (first == null) {
            first = new Element(value);
            last = first;
            size = 1;
        } else {
            Element newElement = new Element(value);
            last.setNextElement(newElement);
            last = newElement;
            size ++;
        }
    }

    public int get(int index) {
        return getElementAt(index).getValue();
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Size: " + size + ", index: " + index);
        }
        Element prevElement = null;
        Element currentElement = first;
        int i = 0;
        while (i < index) {
            prevElement = currentElement;
            currentElement = currentElement.getNextElement();
            i ++;
        }
        if (currentElement == last) {
            last = prevElement;
        }
        remove(currentElement, prevElement);
        return currentElement.getValue();
    }

    public int removeGreaterThan(int value) {
        int removedCount = 0;

        if (first == null) {
            return removedCount;
        }

        Element prevElement = null;
        Element currentElement = first;
        while (currentElement != null) {
            if (currentElement.getValue() > value) {
                Element nextElement = currentElement.getNextElement();
                remove(currentElement, prevElement);
                currentElement = nextElement;
                removedCount ++;
            } else {
                prevElement = currentElement;
                currentElement = currentElement.getNextElement();
            }
        }
        return removedCount;
    }


    public int size() {
        return size;
    }

    private void remove(Element element, Element prevElement) {
        if (prevElement != null) {
            prevElement.setNextElement(element.getNextElement());
            element.setNextElement(null);
        } else {
            first = element.getNextElement();
            element.setNextElement(null);
        }
        size --;
    }

    private Element getElementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Size: " + size + ", index: " + index);
        }
        int i = 0;
        Element currentElement = first;
        while (i < index) {
            if (currentElement.getNextElement() == null) {
                throw new RuntimeException("Element with index " + i + " has no linked element");
            }
            currentElement = currentElement.getNextElement();
            i ++;
        }
        return currentElement;
    }
}
