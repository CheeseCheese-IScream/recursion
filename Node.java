package interview.recursion;

public class Node
{
	// 避免用户在创建value之后去修改
	private final int value;
	private Node next;// 链表：不断更新，可以改变

	public Node(int value)// value在构造函数里给出以后就不能再动了
	{
		this.value = value;
		this.next = null;// 在构造函数理默认指向null:所有建立的node都是非常干净的单点node
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public Node getNext()
	{
		return next;
	}

	public int getValue()// 没有setValue()：节点的value是多少就一直是多少
	{
		return value;
	}

	public static void printLinkedList(Node head)// 打印linked list
	{
		while (head != null)
		{
			System.out.print(head.getValue());
			System.out.print(" ");
			head = head.getNext();	
		}
		System.out.println();
	}

}
