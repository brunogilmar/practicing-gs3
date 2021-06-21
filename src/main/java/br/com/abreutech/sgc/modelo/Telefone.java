package br.com.abreutech.sgc.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_telefone")
public class Telefone {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_telefone",
			sequenceName = "sq_tb_telefone_cd_seq_telefone",
			allocationSize = 1
	)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_telefone")
	@Column(name = "cd_seq_telefone")
	private Long id;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fk_tp_telefone", referencedColumnName = "cd_tipo_telefone")
	private TipoTelefone tipo;

	@NotEmpty
	@Size(min = 10, max = 11)
	@Column(name = "nu_telefone")
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "fk_cliente", referencedColumnName = "cd_seq_cliente")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
