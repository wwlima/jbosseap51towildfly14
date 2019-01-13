package br.com.w2lima.richfacestestes.entity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.h2.tools.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteBase {
	
	EntityManagerFactory sessionFactory;
	Server server ;

	
	@Before
	public void setUp() throws Exception {
		//server = Server.createWebServer("-trace").start();
		//server = Server.createTcpServer("-tcpAllowOthers").start();
			 
		
		sessionFactory = Persistence.createEntityManagerFactory("primario");
	}

	@After
	public void tearDown() throws Exception {
		server.createTcpServer("-tcpAllowOthers").stop();
	}

	@Test
	public void test() {
		EntityManager em = sessionFactory.createEntityManager();
		Usuario usuario = new Usuario();
		
		usuario.setLogin("will");
		usuario.setNascimento(new Date());
		usuario.setNome("William");
		usuario.setSenha("123");
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

}
