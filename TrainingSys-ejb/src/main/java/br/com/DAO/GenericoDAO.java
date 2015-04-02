package br.com.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import br.com.model.Entidade;

@SuppressWarnings("unchecked")
public abstract class GenericoDAO<T extends Entidade> {

	@PersistenceContext(unitName = "trainingsys")
	private EntityManager gerenciador;

	private static final Logger LOGGER = Logger.getLogger(GenericoDAO.class);

	public void salvar(T entidade) {
		getGerenciador().persist(entidade);
		getGerenciador().flush();
	}

	public T salvarERetornar(T entidade) {
		salvar(entidade);
		return entidade;
	}

	public void editar(T entidade) {
		getGerenciador().merge(entidade);
		getGerenciador().flush();
	}

	public void excluir(T entidade) {
		entidade = getGerenciador().merge(entidade);
		getGerenciador().remove(entidade);
		getGerenciador().flush();
	}

	public void excluir(Long id) {
		T entidade = buscar(id);
		excluir(entidade);
	}

	public T buscar(Long id) {
		return (T) getGerenciador().find(getTipoClasse(), id);
	}

	public T buscarPor(String atributo, Object valor) {
		Query query = criarQuerySelect(atributo, valor);
		try {
			return (T) query.getSingleResult();
		} catch (NoResultException nre) {
			LOGGER.error(nre);
			return null;
		}
	}

	public T detachar(Long id) {
		T entidade = buscar(id);
		getGerenciador().detach(entidade);
		return entidade;
	}

	public List<T> listar() {
		return getGerenciador().createQuery(
				"FROM" + getTipoClasse().getSimpleName() + "o").getResultList();
	}

	public List<T> listarPor(String atributo, Object valor) {
		Query query = criarQuerySelect(atributo, valor);
		return query.getResultList();
	}

	public List<T> listarPorLike(String atributo, Object valor) {
		List<String> atributos = new ArrayList<String>();
		atributos.add(atributo);
		return listarPorLike(atributos, valor);
	}

	public List<T> listarPorLike(List<String> atributos, Object valor) {
		StringBuilder queryStr = new StringBuilder();
		queryStr.append(" o WHERE (o.");
		for (Iterator<String> it = atributos.iterator(); it.hasNext();) {
			String atributo = it.next();
			if (!it.hasNext()) {
				queryStr.append("" + atributo + " like '%" + valor + "%')");
			} else {
				queryStr.append("" + atributo + " like '%" + valor + "%' OR o.");
			}
		}
		Query query = getGerenciador().createQuery(
				"FROM " + getTipoClasse().getSimpleName() + queryStr
						+ " AND o.ativo = true");
		return query.getResultList();
	}

	public T atachar(T entidade) {
		return (T) getGerenciador().getReference(getTipoClasse(),
				entidade.getId());
	}

	protected Query criarQuerySelect(String atributo, Object valor) {
		String sql = String.format("FROM %s o WHERE o.%s = :valor",
				getTipoClasse().getSimpleName(), atributo);
		Query querySQL = getGerenciador().createQuery(sql);
		querySQL.setParameter("valor", valor);
		return querySQL;
	}

	protected Query criarQuery(String query) {
		Query querySQL = getGerenciador().createQuery(query);
		return querySQL;
	}

	private Class<?> getTipoClasse() {
		return (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	// GETERS & SETERS
	public EntityManager getGerenciador() {
		if (gerenciador == null) {
			throw new IllegalStateException(
					"EntityManager não foi setado antes do uso neste DAO");
		}
		return gerenciador;
	}
}
