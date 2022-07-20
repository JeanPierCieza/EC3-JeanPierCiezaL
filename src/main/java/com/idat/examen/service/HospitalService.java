package com.idat.examen.service;

import java.util.List;

import com.idat.examen.dto.HospitalDTORequest;
import com.idat.examen.dto.HospitalDTOResponse;



public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest hospital);
	void actualizarHospital(HospitalDTORequest hospital);
	void eliminarHospital(Integer id);
	List<HospitalDTOResponse> listarHospital();
	HospitalDTOResponse obtenerHospitalId(Integer id);

}
