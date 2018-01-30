package br.com.ag.boot.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.ag.boot.model.base.Entidade;

@Entity
@Table(name="ap_usuario")
public class Usuario extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	private String sobrenome;
	
	@Column(nullable=false)
	private String senha;
	
	@Transient
	private String confirmarSenha;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private Calendar dataNascimento;
	
	@Column(nullable=false)
	private Calendar dataCriacao;
	
	@Column(nullable=false)
	private Integer ativo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="usuario")
	private List<UsuarioEGrupo> UsaurioEGrupoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public List<UsuarioEGrupo> getUsaurioEGrupoList() {
		return UsaurioEGrupoList;
	}

	public void setUsaurioEGrupoList(List<UsuarioEGrupo> usaurioEGrupoList) {
		UsaurioEGrupoList = usaurioEGrupoList;
	}
	
}
