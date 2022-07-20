package com.idat.examen.service;

import java.util.List;

import com.idat.examen.dto.ClienteDTORequest;
import com.idat.examen.dto.ClienteDTOResponse;



public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
