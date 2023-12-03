
public class Node {
	public int key;
	public int value;
	public Node nextNode;
	
	public Node(int key, int value)
	{
		this.key = key;
		this.value = value;
		this.nextNode = null;
	}
	
	@Override
	public String toString()
	{
		return "{" + this.key + ":" + this.value + "}";
	}
}
