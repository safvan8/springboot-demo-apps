package in.ineuron.service;

public interface ICoronaVaccineMgmtService
{
	public String removeVaccinesByRegNo(Iterable<Long> regNo);
}
