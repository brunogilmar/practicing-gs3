package br.com.abreutech.sgc.repository;

import br.com.abreutech.sgc.modelo.Cliente;

public interface ClienteRepository extends JpaBaseRepository<Cliente, Long> {

    Long countAllByCpfAndAtivo(
            String nuCpf, Boolean ativo);

    Long countAllByIdNotAndCpfAndAtivo(
            Long id, String nuCpf, Boolean ativo);

}
