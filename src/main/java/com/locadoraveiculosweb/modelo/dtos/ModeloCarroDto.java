package com.locadoraveiculosweb.modelo.dtos;

import java.io.Serializable;

import com.locadoraveiculosweb.modelo.Categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModeloCarroDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String descricao;
	private FabricanteDto fabricante;
	private Categoria categoria;
	
}
