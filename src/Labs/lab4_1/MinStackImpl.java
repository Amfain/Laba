package Labs.lab4_1;

public class MinStackImpl implements MinStack<Integer> {
    private Node head;

    @Override
    public void push(Integer value) {
        int newMin = value;

        if (head != null) {
            newMin = Math.min(value, head.minSoFar);
        }

        head = new Node(value, newMin, head);
    }

    @Override
    public Integer pop() {
        int removedValue = head.value;
        head = head.next;
        return removedValue;
    }

    @Override
    public Integer top() {
        return head.value;
    }

    @Override
    public Integer min() {
        return head.minSoFar;
    }
}