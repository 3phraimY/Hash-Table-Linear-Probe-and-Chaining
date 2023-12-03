
public class HashTableChaining extends HashTable {
	
	public Chain[] Table;
	public int Size;
	
	
	public HashTableChaining(int size)
	{
		this.Size = size;
		this.Table = new Chain[this.Size];
		for(int i = 0; i<Size; i++)
		{
			this.Table[i] = new Chain();
		}
	}
	
	
	
	//hashing is the process to translate a key into a value for indexing/searching
	private int Hashing(int key)
	{
		//use modulo for the hashing
		int result = key%this.Size;
		return result;
	}
	
	@Override
	public void HashInsert(int key, int value) {
		// TODO Auto-generated method stub
		//look for the index based on the key
		int index = Hashing(key);
		Chain target = Table[index];
		//look on the chain to find the node with the key
		Node targetNode = target.SearchNodeByKey(key);
		if (targetNode != null) 
		{
			targetNode.value = value;
		} else {
			target.insertNode(key, value);
		}
	}

	@Override
	public boolean HashSearch(int key) {
		//look for index based on the key
		int index = Hashing(key);
		Chain target = Table[index];
		
		//look on the chain/linked list and search for the key
		return target.SearchByKey(key);
	}

	@Override
	public void HashDelete(int key) {
		//1 using hashing function to get the index of the key
		int index = Hashing(key);
		//2 perform delete on linked list
		Table[index].DeleteByKey(key);
	}
	@Override
	public String toString()
	{
		String answer  = "";
		for(int i =0; i<this.Size; i++)
		{
			answer += "[" + i + "]: " + this.Table[i].toString() + "\n";
		}
		return answer;
	}
}
