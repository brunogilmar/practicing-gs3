package br.com.abreutech.sgc.repository.specification;

import br.com.abreutech.sgc.controller.filter.ClienteFilter;
import br.com.abreutech.sgc.modelo.Cliente;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public final class ClienteSpecification {
    
    public static Specification<Cliente> pesquisaDefault(ClienteFilter filtro) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(filtro.getNome() != null){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nome")),
                                    "%" + filtro.getNome().toLowerCase() + "%"
                        )
                );
            }

            if(filtro.getCpf() != null) {
                predicates.add(
                    criteriaBuilder.equal(root.get("cpf"), filtro.getCpf())
                );
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }

}




