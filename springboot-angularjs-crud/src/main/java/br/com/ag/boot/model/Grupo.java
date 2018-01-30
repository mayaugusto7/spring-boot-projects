package br.com.ag.boot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ag.boot.model.base.Entidade;

@Entity
@Table(name="ap_grupo")
public class Grupo extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String nome;
	
	@Column(length=1)
	private Integer status;
	
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
	private List<GrupoEView> grupoEViewList;
	
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
	private List<UsuarioEGrupo> usuarioEGrupoList;
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<GrupoEView> getGrupoEViewList() {
		return grupoEViewList;
	}

	public void setGrupoEViewList(List<GrupoEView> grupoEViewList) {
		this.grupoEViewList = grupoEViewList;
	}

	public List<UsuarioEGrupo> getUsuarioEGrupoList() {
		return usuarioEGrupoList;
	}

	public void setUsuarioEGrupoList(List<UsuarioEGrupo> usuarioEGrupoList) {
		this.usuarioEGrupoList = usuarioEGrupoList;
	}
	
}