package in.ineuron.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class JDBCSelectApp
{
	private static Logger logger = Logger.getLogger(JDBCSelectApp.class);

	static
	{
		try
		{	
			// loads a configuration file and sets up the logging system based on the
			// configuration specified in the file.
			PropertyConfigurator.configure("src/main/java/in/ineuron/commons/log4j.properties");
		
			logger.info("in.ineuron.dao::JDBCSelectApp :: logger object ready");
			
		} catch (Exception e)
		{
			e.printStackTrace();
			logger.fatal("JDBCSelectApp:: Problem while setting up Log4J");
		}

	}

	public static void main(String[] args)
	{
		logger.debug("Start of main(-) method.");
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.debug("in.ineuron.dao.JDBCSelectApp:: Driver class loaded");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisejavabatch", "root",
					"Safvan@123");
			logger.info("in.ineuron.dao.JDBCSelectApp:: Database connection establised succefully..");

			st = connection.createStatement();
			logger.debug("in.ineuron.dao.JDBCSelectApp:: Statement object created ....");

			rs = st.executeQuery("SELECT * FROM Students");
			logger.debug("in.ineuron.dao.JDBCSelectApp:: Query Executed Successfullyy..");

			System.out.println("SID\tSNAME\tSAGE\tSADDRESS\n---------------------------------");
			while (rs.next())
			{
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				int sage = rs.getInt(3);
				String saddress = rs.getString(5);

				System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + saddress);
			}
			logger.warn("in.ineuron.dao.JDBCSelectApp:: Using Deprecated method getXXX(coulmnNumber) to retieve data from resultSet, Anytime this method can be removed");

		} catch (SQLException se)
		{
			se.printStackTrace();
			logger.error("in.ineuron.dao.JDBCSelectApp:: Know DB Problem.." + se.getMessage() + "--Error Code::"
					+ se.getErrorCode());

		} catch (Exception e)
		{
			e.printStackTrace();
			logger.fatal("in.ineuron.dao.JDBCSelectApp:: Unknown Issues, Don' know how to handle --" + e.getMessage());
		} finally
		{
			try
			{
				rs.close();
				st.close();
				connection.close();
				logger.debug("in.ineuron.dao.JDBCSelectApp:: resources closed successfully..........");
			} catch (Exception e)
			{
				e.printStackTrace();
				logger.error("in.ineuron.dao.JDBCSelectApp:: problem occured while closing resources....");
			}
		}
		logger.debug("end of main method");
	}
}
