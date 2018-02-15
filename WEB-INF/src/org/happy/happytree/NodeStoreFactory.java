package org.happy.happytree;

import org.happy.happytree.NodeStore;
import org.happy.happytree.HashNodeStore; //FIXME: patatra! Il me faudra de l'injection

//==============================================================================
public class NodeStoreFactory{

  /* L'instance de NodeStore est créée dès la première utilisation de la classe
   * factory. Il est possible de faire du lazy loading mais il faut bien relire
   * littérature sur le sujet pour éviter les problèmes en d'accès concurrents*/
  static private NodeStore nodeStore = new HashNodeStore();
  
  public static NodeStore getStore(){
    return nodeStore;
  }
}//NodeStoreFactory
