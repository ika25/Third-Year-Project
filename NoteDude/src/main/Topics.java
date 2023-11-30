package main;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Topics 
{
	//manages both subject_topics
	// and topics tables
	private String subjectID;
	private String topicID;
	private String topicName;
	private String details;
	
	public Topics()
	{
		//null
	}

	public Topics(String subjectID, String topicID, String topicName, String details) 
	{
		this.subjectID = subjectID;
		this.topicID = topicID;
		this.topicName = topicName;
		this.details = details;
	}
	
	public Topics(String topicID, String topicName, String details)
	{
		this.topicID = topicID;
		this.topicName = topicName;
		this.details = details;
	}

	public String getSubjectID() 
	{
		return subjectID;
	}

	public void setSubjectID(String subjectID)
	{
		this.subjectID = subjectID;
	}

	public String getTopicID() 
	{
		return topicID;
	}

	public void setTopicID(String topicID) 
	{
		this.topicID = topicID;
	}

	public String getTopicName()
	{
		return topicName;
	}

	public void setTopicName(String topicName) 
	{
		this.topicName = topicName;
	}

	public String getDetails() 
	{
		return details;
	}

	public void setDetails(String details) 
	{
		this.details = details;
	}
	
}
