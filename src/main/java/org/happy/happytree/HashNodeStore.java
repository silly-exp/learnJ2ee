package org.happy.happytree;

import org.happy.happytree.NodeStore;

import java.util.Map;
import java.util.Hashtable;


// Un gestionnaire maison de stockage des noeuds pour commencer sans dépendances.
//==============================================================================
public class HashNodeStore implements NodeStore{
  Integer idSequence;
  Map<String,String> store;
  String storeName;

  // le constructeur est privé parce qu'on veut que le singleton soit géré par
  // NodeStoreManager
  //--------------------------------------------------------
  private void HashNodeStore(){
    HashNodeStore("DEFAULTSTORE");
  }

  // le constructeur est privé parce qu'on veut que le singleton soit géré par
  // NodeStoreManager
  //--------------------------------------------------------
  private void HashNodeStore(String storeName){
    this.idSequence = 0;
    this.store = new Hashtable<String, String>();
    this.storeName = storeName;
    this.load();
  }

  // on persiste la base lors de la destruction du store
  // FIXME: est-ce une bonne pratique??
  //--------------------------------------------------------
  protected void finalise(){
    this.persist();
  }
  //--------------------------------------------------------
  public String get(String nodeId){
    return this.store.get(nodeId);
  }

  //--------------------------------------------------------
  public String put(String nodeContent){
    String nodeId;
    synchronized(this.idSequence){
      this.idSequence ++;
      nodeId = this.idSequence.toString();
    }
    this.store.put(nodeId, nodeContent);
    return nodeId;
  }

  // met à jour le contenu d'un node désigné par son id.
  // le store retourne une exception si l'id fourni n'existe pas dans le store.
  // FIXME:
  public void update(String nodeId, String nodeContent){
    this.store.replace(nodeId, nodeContent);
  }

  // supprime le node désigné par son id.
  // TODO:le store retourne une exception si l'id fourni n'existe pas dans le store.
  public void delete(String nodeId){
    this.store.remove(nodeId);
  }

  // TODO
  //--------------------------------------------------------
  public void persist(){}

  // TODO
  //--------------------------------------------------------
  public void load(){}

}
