package br.com.terezinha.imobiliaria.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.terezinha.imobiliaria.model.Bairro;
import br.com.terezinha.imobiliaria.model.Cidade;

public class OneToManyLocalidade {
	public static void main(String[] args) {

		Cidade cidade1 = new Cidade();

		cidade1.setNome("Recife");

		Bairro bairro1 = new Bairro();
		bairro1.setNome("boa viagem");
		bairro1.setCidade(cidade1);



		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ImobiliariaPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = null;

		try {
			trx = manager.getTransaction();
			trx.begin();
			manager.persist(cidade1);
			manager.persist(bairro1);
			trx.commit();
		} catch (RuntimeException e) {
			if (trx.isActive())
				trx.rollback();
			throw e;

		}

	}

}
