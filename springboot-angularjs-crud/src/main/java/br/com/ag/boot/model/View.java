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
@Table(name="ap_view")
public class View extends Entidade implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String nome;
	
	private String descricao;
	
	@Column(nullable=false, length=1)
	private Integer visualizar;
	
	@Column(nullable=false, length=1)
	private Integer salvar;
	
	@Column(nullable=false, length=1)
	private Integer atualizar;
	
	@Column(nullable=false, length=1)
	private Integer excluir;
	
	@OneToMany(mappedBy = "view", cascade = CascadeType.ALL)
	private List<GrupoEView> grupoEViewList;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Integer visualizar) {
		this.visualizar = visualizar;
	}

	public Integer getSalvar() {
		return salvar;
	}

	public void setSalvar(Integer salvar) {
		this.salvar = salvar;
	}

	public Integer getAtualizar() {
		return atualizar;
	}

	public void setAtualizar(Integer atualizar) {
		this.atualizar = atualizar;
	}

	public Integer getExcluir() {
		return excluir;
	}

	public void setExcluir(Integer excluir) {
		this.excluir = excluir;
	}

	public List<GrupoEView> getGrupoEViewList() {
		return grupoEViewList;
	}

	public void setGrupoEViewList(List<GrupoEView> grupoEViewList) {
		this.grupoEViewList = grupoEViewList;
	}
	
}
