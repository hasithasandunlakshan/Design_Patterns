package Behavioral.Iterator;

import java.util.Iterator;

// Aggregate Interface
interface NumberCollection {
    Iterator<Integer> createIterator();
}

// Concrete Aggregate
class NumberList implements NumberCollection {
    private int[] numbers;

    public NumberList(int[] numbers) {
        this.numbers = numbers;
    }

    public Iterator<Integer> createIterator() {
        return new NumberIterator();
    }

    // Concrete Iterator
    private class NumberIterator implements Iterator<Integer> {
        private int index;

        public NumberIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < numbers.length;
        }

        public Integer next() {
            if (this.hasNext()) {
                return numbers[index++];
            }
            return null;
        }
    }
}

// Client
public class main {
    public static void main(String[] args) {
        int[] numbersArray = { 1, 2, 3, 4, 5 };
        NumberCollection numberList = new NumberList(numbersArray);

        Iterator<Integer> iterator = numberList.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
