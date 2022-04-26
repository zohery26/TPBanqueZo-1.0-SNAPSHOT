/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mg.zo.tpbanquezohery.ejb;

import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mg.zo.tpbanquezohery.entities.CompteBancaire;

/**
 *
 * @author acer
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root",
        password = "zoHery5122",
        databaseName = "banque",
        properties = {
          "useSSL=false",
          "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

  @PersistenceContext
  private EntityManager em;

  public void creerCompte(CompteBancaire compte) {
    em.persist(compte);
  }

  public List<CompteBancaire> getAllComptes() {
    TypedQuery query
            = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
    return query.getResultList();
  }

  public long nbComptes() {
    TypedQuery<Long> query
            = em.createQuery("select count(c) from CompteBancaire c", Long.class);
    return query.getSingleResult();
  }
}
