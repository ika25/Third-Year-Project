package main;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class TopicController 
{
	private ArrayList<Topics> topic;
	MAIN dao;
	
	public TopicController() throws Exception
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
	
	public ArrayList<Topics> getTopics() 
	{
		return topic;
	}
	//load topic
	public void loadTopics() throws Exception 
	{
		topic = dao.getTopicDetails();
	}
	//update topic
	public String updateTopic(Topics topic) throws Exception 
	{
		try 
		{
			dao.updateTopic(topic);
			return "topics";
		}
		catch (Exception e) 
		{
			FacesMessage message =  new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}
	}
	//add topic
	public String addTopic(Topics topic) throws Exception
	{
		try
		{
			dao.addTopic(topic);
			return "Notes";
		}
		catch (Exception e) 
		{
			FacesMessage message =  new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}
	}
	//delete topic
	public String deleteTopic(Topics topic) throws Exception
	{
		try
		{
			dao.deleteTopic(topic);
			return "Notes";
		}
		catch (Exception e) 
		{
			FacesMessage message = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}
	}
	
	
}
