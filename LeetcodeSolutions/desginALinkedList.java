class MyLinkedList {

	class Node {
		int val;
		Node next, prev;

		Node(int val) {
			this.val = val;
		}
	}

	private Node head, tail;
	private int size;

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.val;
	}

	public void addAtHead(int val) {
		Node newNode = new Node(val);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	public void addAtTail(int val) {
		Node newNode = new Node(val);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addAtIndex(int index, int val) {
		if (index < 0 || index > size) {
			return;
		}
		if (index == 0) {
			addAtHead(val);
			return;
		}
		if (index == size) {
			addAtTail(val);
			return;
		}

		Node newNode = new Node(val);
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		newNode.next = current;
		newNode.prev = current.prev;
		current.prev.next = newNode;
		current.prev = newNode;
		size++;
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= size) {
			return;
		}

		if (index == 0) {
			if (size == 1) {
				head = tail = null;
			} else {
				head = head.next;
				head.prev = null;
			}
		} else if (index == size - 1) {
			tail = tail.prev;
			tail.next = null;
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
		size--;
	}
}
