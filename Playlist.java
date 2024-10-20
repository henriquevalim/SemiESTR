
public class Playlist {
    private class Node {
        Music data;
        Node next;
        Node prev;

        Node(Music data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private Node current;

    public void addFirst(Music music) {
        Node newNode = new Node(music);
        if (head == null) {
            head = tail = current = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Music music) {
        Node newNode = new Node(music);
        if (tail == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAt(int position, Music music) {
        if (position <= 0) {
            addFirst(music);
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addLast(music);
        } else {
            Node newNode = new Node(music);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    public void remove(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.getTitle().equalsIgnoreCase(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                break;
            }
            temp = temp.next;
        }
    }

    public void playCurrent() {
        if (current != null) {
            System.out.println("Playing: " + current.data);
        } else {
            System.out.println("No music to play.");
        }
    }

    public void next() {
        if (current != null && current.next != null) {
            current = current.next;
            playCurrent();
        } else {
            System.out.println("You're at the end of the playlist.");
        }
    }

    public void previous() {
        if (current != null && current.prev != null) {
            current = current.prev;
            playCurrent();
        } else {
            System.out.println("You're at the beginning of the playlist.");
        }
    }

    public void listAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
