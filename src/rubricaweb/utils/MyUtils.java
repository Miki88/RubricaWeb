package rubricaweb.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	  
	    
	   // Store Connection in request attribute.
	   // (Information stored only exist during requests)
	   public static void storeConnection(ServletRequest request, Connection conn) {
	       request.setAttribute(ATT_NAME_CONNECTION, conn);
	   }
	 
	   // Get the Connection object has been stored in one attribute of the request.
	   public static Connection getStoredConnection(ServletRequest request) {
	       Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
	       return conn;
	   }
	   
		public static boolean verificaDati(String n, String c, String i, String t) {
			if (!verificaTel(t))	return false;
			if (n.equals("") || c.equals("") || i.equals("") || t.equals(""))	return false;
			return true;
		}

		private static boolean verificaTel(String x) {
			StringBuffer strbuf = new StringBuffer(x);
			for(int i=0;i<strbuf.length();i++){
				if(!Character.isDigit(strbuf.charAt(i))) return false;
			}
			return true;
		}
	   

}
