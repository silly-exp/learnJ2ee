package org.happy.happytree;


// l'interface NodeStore
//==============================================================================
public interface NodeStore {
  // retourne le contenu du node désigné par son id.
  // si le store ne contient pas le node recherché: retourne null
  public String get(String nodeId);

  // insere un node dans le store.
  // le store retourne l'id qu'il a affecté au node.
  public String put(String nodeContent);

  // met à jour le contenu d'un node désigné par son id.
  // le store retourne une exception si l'id fourni n'existe pas dans le store. FIXME: vraiment?
  public void update(String nodeId, String nodeContent);

  // supprime le node désigné par son id.
  // le store retourne une exception si l'id fourni n'existe pas dans le store. FIXME: vraiment?
  public void delete(String nodeId);
}
