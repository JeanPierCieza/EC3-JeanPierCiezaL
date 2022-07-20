package com.idat.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen.dto.ClienteDTORequest;
import com.idat.examen.dto.ClienteDTOResponse;
import com.idat.examen.model.Cliente;
import com.idat.examen.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		c.setNombre(cliente.getNombreCliente());
		c.setCelular(cliente.getCelularCliente());
		repository.save(c);

	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		c.setNombre(cliente.getNombreCliente());
		c.setCelular(cliente.getCelularCliente());
		repository.saveAndFlush(c);

	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		
        List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> c = repository.findAll();
		
		for (Cliente cliente : c) {
			
			dto = new ClienteDTOResponse();
			
			dto.setNombreCliente(cliente.getNombre());
			dto.setCelularCliente(cliente.getCelular());
			dto.setId(cliente.getIdCliente());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto.setNombreCliente(cliente.getNombre());
		dto.setCelularCliente(cliente.getCelular());
		dto.setId(cliente.getIdCliente());
		
		return dto;
	}

}
