package main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//final year project
public class MAIN 
{	
	private DataSource mysqlDS;
	public MAIN() throws Exception 
	{
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/notedude";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	// Get info on Subject
	public ArrayList<Subject> getSubjectDetails() throws Exception 
	{
		ArrayList<Subject> subjects = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from subjects");
		ResultSet rs = myStmt.executeQuery();
		while (rs.next())
		{
			String id = rs.getString("id");
			String name = rs.getString("name");
			subjects.add(new Subject(id, name));
		}
		return subjects;
	}
		
	//view topics\notes other
	public ArrayList<Topics> getTopicDetails() throws Exception
	{
		ArrayList<Topics> topics = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select s.subjectID, s.topicID, t.topicName, t.details "
				+ "from subject_topics s join topics t on s.topicID = t.topicID");
		ResultSet rs = myStmt.executeQuery();
		while (rs.next())
		{
			String subjectID = rs.getString("subjectID");
			String topicID = rs.getString("topicID");
			String topicName = rs.getString("topicName");
			String details = rs.getString("details");
			topics.add(new Topics(subjectID,topicID, topicName, details));
		}
		return topics;
	}

	public void addTopic(Topics topic) throws SQLException
	{
		Connection conn = mysqlDS.getConnection();
	
		System.out.println(topic.toString());
		//PreparedStatement myStmt = conn.prepareStatement("Insert into subject_topics values(?,?), topics values(?,?,?)");
		PreparedStatement myStmt = conn.prepareStatement("insert into topics(topicID,topicName,details) values(?,?,?)");
		myStmt.setString(1, topic.getTopicID());
		myStmt.setString(2, topic.getTopicName());
		myStmt.setString(3, topic.getDetails());
		//System.out.println(myStmt);
		myStmt.executeUpdate();
	}
	
	public void updateTopic(Topics topic) throws SQLException 
	{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("update topics set topicID = ?, topicName = ?, details = ? where topicID = ?");
		myStmt.setString(1, topic.getTopicID());	
		myStmt.setString(2, topic.getTopicName());	
		myStmt.setString(3, topic.getDetails());
		myStmt.setString(4, topic.getTopicID());
		myStmt.executeUpdate();
		
	}
	
	public void deleteTopic(Topics topic) throws SQLException
	{
		Connection conn = mysqlDS.getConnection();
		
		PreparedStatement subjectTopicStmt = conn.prepareStatement("select * from subject_topics where topicID = ?");
		
		subjectTopicStmt.setString(1, topic.getTopicID());
		
		ResultSet rs = subjectTopicStmt.executeQuery();
		while (rs.next())
		{
			PreparedStatement myStmt = conn.prepareStatement("delete from subject_topics where topicID= ?");
			myStmt.setString(1, topic.getTopicID());
			myStmt.executeUpdate();
		}
		
		PreparedStatement myStmt = conn.prepareStatement("delete from topics where topicID= ?");
		myStmt.setString(1, topic.getTopicID());
		myStmt.executeUpdate();
	}	

	public ArrayList<SubTopics> getSubTopicDetails() throws SQLException 
	{
		ArrayList<SubTopics> subTopic = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from subject_topics");
		ResultSet rs = myStmt.executeQuery();
		while (rs.next())
		{
			String subID = rs.getString("subjectID");
			String topID = rs.getString("topicID");
			subTopic.add(new SubTopics(subID, topID));
		}
		return subTopic;
	}

	public void addSubTopics(SubTopics subTopic) throws SQLException 
	{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Insert into subject_topics values(?,?)");
		myStmt.setString(1, subTopic.getSubID());
		myStmt.setString(2, subTopic.getTopID());
		myStmt.executeUpdate();
	}
	
	//add Subject
	public void addSubject(Subject subjects) throws SQLException
	{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Insert into subjects values (?,?)");
		System.out.println(subjects.toString());
		myStmt.setString(1, subjects.getId());
		myStmt.setString(2, subjects.getName());
		System.out.println(myStmt);
		myStmt.executeUpdate();		
	}

	
	
	
	//search for all notes in one subject
	public ArrayList<FindAll> getFindSubject(FindAll search) throws SQLException 
	{
		ArrayList<FindAll> findSub = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("Select sub.name, t.topicID, t.topicName, t.details "
														+ "from subject_topics s join topics t on s.topicID = t.topicID join "
														+ "subjects sub on s.subjectID = sub.id where sub.name = ?");
		myStmt.setString(1, search.getSub_Name());
		ResultSet rs = myStmt.executeQuery();
		while(rs.next())
		{
			String Sub_Name = rs.getString("name");
			int Topic_ID = rs.getInt("topicID");
			String Topic_Name = rs.getString("topicName");
			String Topic_Details = rs.getString("details");
			findSub.add(new FindAll(Sub_Name, Topic_ID, Topic_Name, Topic_Details));
		}
		return findSub;
	}

	//delete subject
	public void deleteSubject(Subject subjects) throws SQLException
	{
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("delete from subjects where id= ?");
		myStmt.setString(1, subjects.getId());
		myStmt.executeUpdate();
	}

	
	
}