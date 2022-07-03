package model.repository;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Receita;

public class ReceitaRepository extends PersistenceConfig
{
	public static boolean cadastrarReceita(Receita receita) {
		boolean resultado = true;
		EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
		
		try
		{
			transaction.begin();
			PersistenceConfig.getEntityManager().persist(receita);
			transaction.commit();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar cadastrar uma nova receita! " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public static Receita recuperarReceitaPorId(int id)
	{
		Receita resultado = null;
		
		try
		{
			resultado = PersistenceConfig.getEntityManager().find(Receita.class, id);
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar a receita! " + e.getMessage());
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<Receita> recuperarReceitas()
	{
		Collection<Receita> resultado = null;
		
		try
		{
			// HQL: "FROM ContaComum"
			resultado = PersistenceConfig.getEntityManager()
					.createQuery("FROM " + Receita.class.getName())
					.getResultList();
		}
		catch (Exception e)
		{
			System.out.println(
					"Erro ao tentar recuperar as receitas cadastradas! " + e.getMessage());
			e.printStackTrace();
			resultado = null;
		}
		
		return resultado;
	}
	
	public static boolean atualizarReceita(Receita receita) {
		return true;
	}
}