
public class Chain {
	public Node header;
	public int size;
	
	public Chain()
	{
		this.header = null;
		this.size = 0;
	}

	@Override
	public String toString()
	{
		Node temp = this.header;
		String output = "";
		while(temp!=null)
		{
			output = output + temp.toString() + " ";
			temp = temp.nextNode;
		}
		return output;
	}
	//compare every node with its key and input. When there is an item has the key, return true, otherwise return false
	public boolean SearchByKey(int key)
	{
		Node temp = this.header;
		while(temp != null)
		{
			if(temp.key == key)
			{
				return true;
			}
			temp = temp.nextNode;
		}
		return false;
	}
	public void DeleteByKey(int key)
	{
		Node curr = this.header;
		Node prev = null;
		if(curr == null)
		{
			return;
		}
		if(curr.nextNode == null)
		{
			this.header = null;
			return;
		}
		while(curr != null && curr.key != key)
		{
			prev = curr;
			curr = curr.nextNode;
		}
		if(curr == null)
		{
			return;
		}
		else
		{
			prev.nextNode = curr.nextNode;
			curr.nextNode = null;
			return;
		}
	}
	public Node SearchNodeByKey(int key)
	{
		Node temp = this.header;
		while(temp != null)
		{
			if(temp.key == key)
			{
				return temp;
			}
			temp = temp.nextNode;
		}
		return null;
	}
	public void insertNode(int key, int value)
	{
		Node temp = this.header;
		if(temp == null)
		{
			this.header = new Node(key,value);
			this.size++;
		}
		else
		{
			while(temp.nextNode != null)
			{
				temp = temp.nextNode;
			}
			temp.nextNode = new Node(key,value);
			this.size++;
		}
	}
}
