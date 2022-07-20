package com.idat.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.examen.dto.HospitalDTORequest;
import com.idat.examen.dto.HospitalDTOResponse;
import com.idat.examen.model.Hospital;
import com.idat.examen.repository.HospitalRepository;





@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	
	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		Hospital h = new Hospital();
		h.setNombre(hospital.getNombreHospital());
		h.setDescripcion(hospital.getDescripcionHospital());
		h.setDistrito(hospital.getDistritoHospital());
		repository.save(h);

	}

	@Override
	public void actualizarHospital(HospitalDTORequest hospital) {
		
		Hospital h = new Hospital();
		h.setNombre(hospital.getNombreHospital());
		h.setDescripcion(hospital.getDescripcionHospital());
		h.setDistrito(hospital.getDistritoHospital());
		
		repository.saveAndFlush(h);

	}

	@Override
	public void eliminarHospital(Integer id) {
		
		repository.deleteById(id);

	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
        List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> h = repository.findAll();
		
		for (Hospital hospital : h) {
			
			dto = new HospitalDTOResponse();
			
			dto.setNombreHospital(hospital.getDescripcion());
			dto.setDescripcionHospital(hospital.getDescripcion());
			dto.setDistritoHospital(hospital.getDistrito());
			dto.setId(hospital.getIdHospital());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		
		
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setNombreHospital(hospital.getDescripcion());
		dto.setDescripcionHospital(hospital.getDescripcion());
		dto.setDistritoHospital(hospital.getDistrito());
		dto.setId(hospital.getIdHospital());
		
		return dto;
	}

}
