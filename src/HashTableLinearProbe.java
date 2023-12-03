
public class HashTableLinearProbe{

	public int[] Table;
	public int Size;
	private int EmptySinceStart = -1;
	private int Empty = -2;
	
	//hashing is the process to translate a key into a value for indexing/searching
	public HashTableLinearProbe(int Size)
	{
		this.Size = Size;
		this.Table = new int[Size];
		for(int i = 0; i<this.Size; i++)
		{
			Table[i] = this.EmptySinceStart;
		}
	}
	private int NextIndex(int index)
	{
		index++;
		index = index%this.Size;
		return index;
	}
	
	private int Hashing(int key)
		{
			//use modulo for the hashing
			int result = key%this.Size;
			return result;
		}
	
	public void HashInsert(int key, int value) {
		int index = Hashing(key);
		if(this.Table[index] == this.EmptySinceStart)
		{
			this.Table[index] = value;
			return;
		}
		while(this.Table[index] != (this.EmptySinceStart | this.Empty))
		{
			index = NextIndex(index);
		}
		this.Table[index] = value;
		return;
	}

	public int HashSearchReturnIndex(int key, int value)
	{
		int index = Hashing(key);
		while(this.Table[index] != this.EmptySinceStart)
		{
			if(Table[index] == value)
			{
				return index;
			}
			index = NextIndex(index);
		}
		return -1;
	}
	
	public void HashDelete(int key, int value) 
	{
		int index = HashSearchReturnIndex(key,value);
		if(index == -1)
		{
			return;
		}
		this.Table[index] = this.Empty;
	}
	
	@Override
	public String toString()
	{
		String answer  = "";
		for(int i =0; i<this.Size; i++)
		{
			answer += "[" + i + "]: " + this.Table[i] + "\n";
		}
		return answer;
	}
}
