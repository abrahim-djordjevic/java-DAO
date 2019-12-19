/**
 * the Webcontroller class is a controller class for the java server and is used to launch the java web server.
 *  As well as define the web pages hosted on the server and their respective URLs
 *  @author Abrahim Djordjevic
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class WebController {
	public static void main(String[] args) throws Exception {
		//add usernames and passwords to system
		PasswordHash.signup("admin1", "kings123");
		PasswordHash.signup("admin2", "dummy098");
		//create server on port 8090
		Server server = new Server(8090);
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);
		handler.addServletWithMapping(BookServlet.class, "/");
		handler.addServletWithMapping(AdminWebPage.class, "/admin");
		handler.addServletWithMapping(NewBookServlet.class, "/add");
		handler.addServletWithMapping(DeleteBookServlet.class, "/delete");
		handler.addServletWithMapping(UpdateBookServlet.class, "/update");
		server.start();
		server.join();
	}
}
