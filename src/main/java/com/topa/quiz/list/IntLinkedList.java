package com.topa.quiz.list;

public class IntLinkedList {

    /**
     * pointer to first element
     */
    private Element first;

    /**
     * pointer to last element
     */
    private Element last;

    /**
     * list size
     */
    private int size = 0;

    /**
     * Adds value as last element of the list
     * @param value
     */
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

    /**
     * Gets value by its index in list
     * @param index of the element
     * @return found int value
     * @throws IndexOutOfBoundsException if element with such index was not found
     */
    public int get(int index) {
        return getElementAt(index).getValue();
    }

    /**
     * Removes last value in list
     * @return value of the removed element
     * @throws IndexOutOfBoundsException if no elements found in list
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * removes value by index
     * @param index index of the element to be removed
     * @return value of the deleted element
     * @throws IndexOutOfBoundsException if element with such index was not found
     */
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

    /**
     * Removes elements from the list which are greater than a passed value
     * @param value value to compare with list elements
     * @return number of removed elements
     */
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


    /**
     *
     *  @return size of the list
     *
     */
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
