package br.com.abreutech.sgc.modelo;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "tb_perfil")
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_perfil",
			sequenceName = "sq_tb_perfil_cd_seq_perfil",
			allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_perfil")
	@Column(name = "cd_seq_perfil")
	private Long id;

	@Column(name = "no_perfil")
	private String nome;

	@Override
	public String getAuthority() {
		return nome;
	}

}
