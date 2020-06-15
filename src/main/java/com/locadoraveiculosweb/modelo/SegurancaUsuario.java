package com.locadoraveiculosweb.modelo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries(value = {
		@NamedQuery(name = "SegurancaUsuario.findByCodigoUsuario", query = "select su from SegurancaUsuario su where su.usuario.codigo = :codigoUsuario")
})
public class SegurancaUsuario extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Basic
	@Getter @Setter
	Byte[] publicKeyUsusuario;
	
	@Basic
	@Getter @Setter
	Byte[] privateKeyUsuario;
	
	@Getter @Setter
	@OneToOne(mappedBy = "seguranca")
	Usuario usuario;
}
