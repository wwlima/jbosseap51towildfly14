package br.com.w2lima.richfacestestes.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.w2lima.richfacestestes.tests.JPAHibernateTestBase;

public class UsuarioTest extends JPAHibernateTestBase{

	@Test
    public void testPersist_success() {
		System.out.println("iniciando...");
        em.getTransaction().begin();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setLogin("Will");
        usuario.setNascimento(new Date());
        usuario.setSenha("123");
        usuario.setNome("William Lima");
        
        em.persist(usuario);
        em.getTransaction().commit();

        List<Usuario> usuarios = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
        for (Usuario usuario2 : usuarios) {
			System.out.println(usuario2.getLogin());
		}

        assertNotNull(usuarios);
        assertEquals(2, usuarios.size());
        
        session.close();
    	session.clear();
    	sessionFactory.close();
    }
}
