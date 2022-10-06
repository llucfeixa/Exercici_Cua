public class QueueImpl<E> implements Queue<E> {
    int len;
    public QueueImpl (int length) {
        this.len = length;
    }
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
        if (size() == len) {
            throw new FullQueueException();
        }
        if (last != null) {
            last.next = i;
        }
        last = i;
        if (first == null) {
            first = last;
        }
    }

    public E pop() throws EmptyQueueException {
        if (first == null) {
            throw new EmptyQueueException();
        }
        E data = first.object;
        first = first.next;
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
