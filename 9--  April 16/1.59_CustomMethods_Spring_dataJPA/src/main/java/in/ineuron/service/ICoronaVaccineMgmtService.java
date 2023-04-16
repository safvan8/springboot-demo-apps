package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public List<CoronaVaccine> fetchVaccineByCompany(String company);

}
