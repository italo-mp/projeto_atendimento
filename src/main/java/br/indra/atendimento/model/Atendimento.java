package br.indra.atendimento.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "senha", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long senha;

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

	public Atendimento() {
	}

	public Atendimento(Pessoa pessoa, Long idFuncionario, Character statusAtendimento, Character tipoAtendimento) {
		Funcionario f = new Funcionario();
		f.setId(idFuncionario);
		this.funcionario = f;
		this.pessoa = pessoa;
		this.statusAtendimento = statusAtendimento;
		this.tipoAtendimento = tipoAtendimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenha() {
		return senha;
	}

	public void setSenha(Long senha) {
		this.senha = senha;
	}

	public Character getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(Character tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Character getStatusAtendimento() {
		return statusAtendimento;
	}

	public void setStatusAtendimento(Character statusAtendimento) {
		this.statusAtendimento = statusAtendimento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
