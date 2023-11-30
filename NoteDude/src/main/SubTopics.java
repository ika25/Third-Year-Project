package main;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SubTopics 
{
	private String subID;
	private String topID;
	
	public SubTopics()
	{
		//null
	}
	
	public SubTopics(String subID, String topID)
	{
		this.subID = subID;
		this.topID = topID;
	}

	public String getSubID() 
	{
		return subID;
	}
	public void setSubID(String subID) 
	{
		this.subID = subID;
	}
	public String getTopID() 
	{
		return topID;
	}

	public void setTopID(String topID)
	{
		this.topID = topID;
	}
}
