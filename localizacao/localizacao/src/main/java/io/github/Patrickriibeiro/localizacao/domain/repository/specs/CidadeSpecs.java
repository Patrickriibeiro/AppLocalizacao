package io.github.Patrickriibeiro.localizacao.domain.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import io.github.Patrickriibeiro.localizacao.domain.entity.Cidade;

public abstract class CidadeSpecs {

	public static Specification<Cidade> propertyEqual(String prop, Object value) {
		return (root, query, cb) -> cb.equal(root.get("prop"), value);

	}

	public static Specification<Cidade> idEqual(String id) {
		return (root, query, cb) -> cb.equal(root.get("id"), id);

	}

	public static Specification<Cidade> nomeEqual(String nome) {
		return (root, query, cb) -> cb.equal(root.get("nome"), nome);

	}

	public static Specification<Cidade> habitantesGreaterThan(Integer value) {
		return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), value);

	}

}
