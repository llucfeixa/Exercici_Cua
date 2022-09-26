public class QueueImpl<E> implements Queue<E> {
    private static class QueueNode<E> {
        private E object;
        private QueueNode<E> next;

        public QueueNode(E e) {
            this.object = e;
        }
    }

    private QueueNode<E> first;
    private QueueNode<E> last;

    public void push(E e) throws FullQueueException {
        QueueNode<E> i = new QueueNode<E>(e);
        if (last != null) {
            last.next = i;
        }
        last = i;
        if (first == null) {
            first = last;
        }
    }

    public E pop() throws EmptyQueueException {
        //Checking if the Queue is empty.
        if (first == null) {
            throw new EmptyQueueException();
        }
        //Creating a new data object with the first element of the queue.
        E data = first.object;
        first = first.next;
        //If the first element is null, the last will also be null.
        if (first == null) {
            last = null;
        }
        return data;
    }

    public int size() {
        QueueNode<E> j = first;
        int size = 0;
        while (j != null) {
            size++;
            j = j.next;
        }
        return size;
    }
}
