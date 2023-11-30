package main;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

@ManagedBean
@ViewScoped
public class FindAllController
{
	MAIN dao;
	private ArrayList<FindAll> findSubject;
	
	public void findSubject(FindAll search) throws Exception 
	{
		findSubject = dao.getFindSubject(search);
	}
}
