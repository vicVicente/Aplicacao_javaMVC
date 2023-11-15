package model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UniversidadeDao {
    
    //Executar operações no banco de dados (INSERT, UPDATE, DELETE...)
    private EntityManager manager;
    
    private void conectar(){
        manager = Persistence.createEntityManagerFactory("aula_2PU").createEntityManager();
    }

    public int salvarCurso(Curso curso) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(curso); //Insere no Banco de dados (gera um INSERT)
            manager.getTransaction().commit();
            return 1;
        } catch (Exception erro) {
            return 0;
        }
    }
    
}
