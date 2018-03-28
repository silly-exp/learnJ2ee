package org.happy.happytree;

import org.happy.happytree.NodeStoreFactory;
import org.happy.happytree.NodeStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Map;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** this servlet is responsible for the Node CRUD
*/
public class NodeServlet extends HttpServlet{

	NodeStore nodeStore = new TestNodeStore();
    private static final Logger LOGGER = LogManager.getLogger(NodeServlet.class.getName());


//------------------------------------------------------------------------------
	/** get an existing Node
	   @param in request:
	   nodeId : l'id of the node to get. If this id doesn't exist, return 404.
	   @return: the the json node content
	*/
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	               throws ServletException, IOException{

		// FIXME: controler vraiment les paramètres

	    String nodeId = (String) request.getParameter("nodeId");
		if (nodeId == null) {
			LOGGER.debug("pas de nodeId passé");
			response.setStatus(404);
			return;
		}
		String nodeContent = this.nodeStore.get(nodeId);
		if (nodeContent == null){
			LOGGER.debug("nodeId sans réponse:" +nodeId);
			response.setStatus(404);
			return;
		}
		LOGGER.debug("nodeId avec reponse:" +nodeId + "=>"+ nodeContent);
		response.setContentType("application/json"); 
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.println(nodeContent); // FIXME: faire un vrai json...
		out.close();
	}
//------------------------------------------------------------------------------
	/** @action: create a new Node
	 * @param in request:
	   nodeContent : the content of the node to create.
	   Si nodeContent n'est pas fourni, return 404 FIXME: voir les bonnes pratiques
	   @return: the nodeId created for this new node.
	*/
	protected void doPost(HttpServletRequest request,
	                     HttpServletResponse response)
	               throws ServletException, IOException{

		// FIXME: contrôle des paramètres à faire
		String nodeContent="contenu du node alpha";

		String nodeId = this.nodeStore.put(nodeContent); //FIXME controler le retour ok
		// si oui on stocke le nouveau noeud
		response.setContentType("application/json"); //FIXME check that this typemime is correct.
		PrintWriter out = response.getWriter();
		out.println("nodeId:" + nodeId); //FIXME syntaxe json à corriger
		out.close();
	}
}
