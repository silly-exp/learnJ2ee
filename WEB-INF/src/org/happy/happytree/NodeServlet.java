package org.happy.happytree;

import org.happy.happytree.NodeStoreFactory;
import org.happy.happytree.NodeStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;


/** this servlet is responsible for the Node CRUD
*/
public class NodeServlet extends HttpServlet{

	NodeStore nodeStore;

//------------------------------------------------------------------------------
	public void NodeServlet(){
		//System.out.println("NodeServletConstructor");
		//this.nodeStore = NodeStoreFactory.getStore();
		this.nodeStore = new TestNodeStore();
		System.out.println(this.nodeStore.toString());
	}

//------------------------------------------------------------------------------
	/** get an existing Node
	   @param in request:
	   nodeId : l'id of the node to get. If this id doesn't exist, return 404.
	   @return: the the json node content
	*/
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	               throws ServletException, IOException{

		// FIXME: recupérer et controler les paramètres
		// si non => 404
		String nodeId = "alpha";
		String nodeContent = this.nodeStore.get(nodeId);
		if (nodeContent == null){
			// FIXME: return 404
		}
		response.setContentType("application/json"); //FIXME check that this typemime is correct.
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
