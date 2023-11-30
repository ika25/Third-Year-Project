package main;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class FindAll 
{
	private int Sub_ID;
	private String Sub_Name;
	private int Topic_ID;
	private String Topic_Name;
	private String Topic_Details;
	private int SubTop_subID;
	private int SubTop_topID;

	
	// Main constructor
	public FindAll(int sub_ID, String sub_Name, int topic_ID, String topic_Name, String topic_Details, int subTop_subID, int subTop_topID) 
	{
		super();
		this.Sub_ID = sub_ID;
		this.Sub_Name = sub_Name;
		this.Topic_ID = topic_ID;
		this.Topic_Name = topic_Name;
		this.Topic_Details = topic_Details;
		this.SubTop_subID = subTop_subID;
		this.SubTop_topID = subTop_topID;
	}

	
	public FindAll(String Sub_Name, int Topic_ID, String Topic_Name, String Topic_Details) 
	{
		this.Sub_Name = Sub_Name;
		this.Topic_ID = Topic_ID;
		this.Topic_Name = Topic_Name;
		this.Topic_Details = Topic_Details;
	}

	//getters and setters
	public int getSub_ID() 
	{
		return Sub_ID;
	}

	public void setSub_ID(int sub_ID) 
	{
		Sub_ID = sub_ID;
	}

	public String getSub_Name() 
	{
		return Sub_Name;
	}

	public void setSub_Name(String sub_Name) 
	{
		Sub_Name = sub_Name;
	}

	public int getTopic_ID() 
	{
		return Topic_ID;
	}

	public void setTopic_ID(int topic_ID) 
	{
		Topic_ID = topic_ID;
	}

	public String getTopic_Name() 
	{
		return Topic_Name;
	}

	public void setTopic_Name(String topic_Name) 
	{
		Topic_Name = topic_Name;
	}

	public String getTopic_Details() 
	{
		return Topic_Details;
	}

	public void setTopic_Details(String topic_Details) 
	{
		Topic_Details = topic_Details;
	}

	public int getSubTop_subID() 
	{
		return SubTop_subID;
	}

	public void setSubTop_subID(int subTop_subID) 
	{
		SubTop_subID = subTop_subID;
	}

	public int getSubTop_topID() 
	{
		return SubTop_topID;
	}

	public void setSubTop_topID(int subTop_topID) 
	{
		SubTop_topID = subTop_topID;
	}
		
}