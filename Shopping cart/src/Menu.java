import java.util.Set;

public class Menu {
	public int availableItems( int available,int required)throws RuntimeException
	{
		if(required<available)
		{
			available=available-required;
			return available;
					
		}
		else
		{
			throw new RuntimeException();
		}
		
	}
	public String requiredItem(Set<String> items,String requiredItem)
	{
		if(items.contains(requiredItem))
		{
			return requiredItem;
		}
		else
		{
			throw new RuntimeException();
		}
	}

}
