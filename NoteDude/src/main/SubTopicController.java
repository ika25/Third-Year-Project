package main;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class SubTopicController 
{
	private ArrayList<SubTopics> subTopic;
	MAIN dao;
	
	public SubTopicController() throws Exception
	{
		try 
		{
			dao = new MAIN();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<SubTopics> getSubTopics() 
	{
		return subTopic;
	}
	//load subject_topics
	public void loadSubTopics() throws Exception 
	{
		subTopic = dao.getSubTopicDetails();
	}
	//add subject_topics
	public String addSubTopics(SubTopics subTopic) throws Exception
	{
		try
		{
			dao.addSubTopics(subTopic);
			return "Notes";
		}
		catch (Exception e) 
		{
			FacesMessage message =  new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}
	}
}
