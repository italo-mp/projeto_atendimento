package br.indra.atendimento.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "senha")
	private long senha;

	@Column(name = "tipo_atendimento")
	private Character tipoAtendimento;

	@Column(name = "data_hora")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;

	@Column(name = "status_atendimento")
	private Character statusAtendimento;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

}
