package in.ineuron.service;

import javax.transaction.Transactional;

@Transactional
public interface ICoronaVaccineMgmtService
{

	public void deleteVaccineByName(String name);

	public long CountNumOfCountries(String country);

	public boolean isCompanyExist(String companyName);
	
}
