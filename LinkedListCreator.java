package interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//从数组构建LinkedList的函数
public class LinkedListCreator
{
	// 严格定义递归函数作用,包括参数,返回值,Side-effect
	/**
	 * Creates a linked list.
	 * 
	 * @param data
	 *            the data to create the list
	 * @return head of the linked list.The returned linked list ends with last node
	 *         with getNext() == null.【基准】
	 */
	public Node creatLinkedList(List<Integer> data)
	{
		// 2.再处理特殊情况——>相当于数学归纳法N=1的【特殊】情况

		// 针对Node firstNode = new Node(data.get(0));
		if (data.isEmpty())// data可能为空
		{
			// 把一个空的list建成一个linked list
			return null;// 返回一个null：一个节点都没有
		}

		/*
		 * 针对Node headOfSublist = creatLinkedList(data.subList(1, data.size()));
		 * 当data只有一个0号元素，没有1号元素。 
		 * 当把data的第1个元素拿走后(Node firstNode = new Node(data.get(0)))，剩下空的data，
		 * 这时候subList返回什么，能不能正确工作？返回null，能。
		 * 
		 * 对subList：Ctrl+鼠标左键 ：If fromIndex and toIndex are equal,the returned list is empty.
		 * 
		 * 分析:只有一个元素的data传进subList(1,data.size())=subList(1,1)
		 * data.size()=1(data只有一个元素)
		 * data.subList(1, data.size()返回null
		 * 调用creatLinkedList就会进入if语句
		 * 所以headOfSublist是空传
		 * firstNode指向headOfSublist(null)
		 * 因此data只有一个元素：函数还是对的！
		 */

		// 缩小问题的规模
		// 把data里的第【1】个数拿出来建一个node
		Node firstNode = new Node(data.get(0));// 1.先一般(先假设所有的get都能拿出数据)

		// 这个node的next指向null(在构造函数理默认指向null)

		// 每次问题规模缩小程度必须为1
		// Node secondNode = new Node(data.get(1))NO!!不能碰第2个结点

		// 递归调用
		Node headOfSublist = creatLinkedList(data.subList(1, data.size()));// 【N-1】的问题
		// (data从0开始)去掉第0个元素之后，剩下的所有元素去creat一个linked list，
		// 返回head of the linked list，并且getNext() == null

		// 把第1个结点的node指向headOfSublist
		firstNode.setNext(headOfSublist);

		// firstNode在这时候就是head of the linked list,
		// 假设headOfSublist指向null——>firstNode指向headOfSublist(即null)
		return firstNode;

	}

	public static void main(String[] args)
	{
		LinkedListCreator creator = new LinkedListCreator()	;
		
		// 建一个空传
		Node.printLinkedList(creator.creatLinkedList(new ArrayList<>()));
		// 建一个只有一个节点的传 
		Node.printLinkedList(creator.creatLinkedList(Arrays.asList(1)));
		// 建一个普通的
		Node.printLinkedList(creator.creatLinkedList(Arrays.asList(1,2,3,4,5)));
		// 打印linked list，见Node.java 
		
		
	}

}
