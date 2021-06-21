package br.com.abreutech.sgc.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_email")
public class Email {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_email",
			sequenceName = "sq_tb_email_cd_seq_email",
			allocationSize = 1
	)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_email")
	@Column(name = "cd_seq_email")
	private Long id;

	@NotEmpty
	@Size(max = 100)
	@javax.validation.constraints.Email
	@Column(name = "ds_email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "fk_cliente", referencedColumnName = "cd_seq_cliente")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
