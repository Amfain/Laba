package Labs.lab4_1;

class Node {
    final int value;
    final int minSoFar;
    final Node next;

    Node(int value, int minSoFar, Node next) {
        this.value = value;
        this.minSoFar = minSoFar;
        this.next = next;
    }
}