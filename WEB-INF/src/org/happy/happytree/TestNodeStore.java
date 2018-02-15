package org.happy.happytree;

import org.happy.happytree.NodeStore;

// Un gestionnaire maison de stockage des noeuds pour commencer sans dépendances.
//==============================================================================
public class TestNodeStore implements NodeStore{

  // le constructeur est privé parce qu'on veut que le singleton soit géré par
  // NodeStoreManager
  //--------------------------------------------------------
  private void HashNodeStore(){   
  }

  // le constructeur est privé parce qu'on veut que le singleton soit géré par
  // NodeStoreManager
  //--------------------------------------------------------
  private void HashNodeStore(String storeName){
  }

  //--------------------------------------------------------
  public String get(String nodeId){
    return nodeId + "content";
  }

  //--------------------------------------------------------
  public String put(String nodeContent){
    return "newNodeId";
  }

  // met à jour le contenu d'un node désigné par son id.
  // le store retourne une exception si l'id fourni n'existe pas dans le store.
  // FIXME:
  public void update(String nodeId, String nodeContent){
  }

  // supprime le node désigné par son id.
  // TODO:le store retourne une exception si l'id fourni n'existe pas dans le store.
  public void delete(String nodeId){
  }

}
