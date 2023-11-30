package main;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class SubjectController implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Subject> subjects;
	MAIN dao;
	
	public SubjectController() throws Exception
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
	
	public ArrayList<Subject> getSubjects() 
	{
		return subjects;
	}

	public void loadSubjects() throws Exception 
	{
		subjects = dao.getSubjectDetails();
	}
	
	//add subject
	public String addSubject(Subject subjects) throws Exception
	{
		try
		{
			dao.addSubject(subjects);
			return "subjects";
		}
		catch (Exception e) 
		{
			FacesMessage message =  new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}
	}
	
	//delete subject
	public String deleteSubject(Subject subjects) throws Exception
	{
		try
		{
			dao.deleteSubject(subjects);
			return "subjects";
		}
		catch (Exception e) 
		{
			FacesMessage message = new FacesMessage("Error: " + e);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return e.toString();
		}
	}
	
}
