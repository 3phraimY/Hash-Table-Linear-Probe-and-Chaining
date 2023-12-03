import java.util.Random;
public class main {

	public static void main(String[] args) {
		HashTableLinearProbe hashLinear = new HashTableLinearProbe(10);
		HashTableChaining hashChain = new HashTableChaining(10);
		Random r = new Random();
		for(int i =0; i<20; i++)
		{
			int temp = Math.abs(r.nextInt());
			if(i<10)
			{
				hashLinear.HashInsert(temp, temp);
			}
			hashChain.HashInsert(temp, temp);
		}
		
		System.out.println(hashLinear);
		System.out.println(hashChain);
	}

}
