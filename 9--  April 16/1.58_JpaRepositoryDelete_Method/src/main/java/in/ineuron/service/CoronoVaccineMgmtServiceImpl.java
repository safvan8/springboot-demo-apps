package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService
{

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public String removeVaccinesByRegNo(Iterable<Long> regNo)
	{

		List<CoronaVaccine> listEntities = repo.findAllById(regNo);

		// size of input arrayList and retrieved need to be same to delete here
		// deletion will happen if all the objects are avaialble in DB , otherwise
		// deletion will not happen.
		/*
		 * delete from corona_vaccine where reg_no in ( ? , ? , ? ) all are deleted
		 * using a single query
		 */
		if (listEntities.size() != 0)
		{
			repo.deleteAllByIdInBatch(regNo);
			return listEntities.size() + "  no of records deleted";
		}
		return "record not found for deletion";
	}

	/**
	 * The "removeVaccinesByRegNo" method is used to delete multiple records from
	 * the database by their registration numbers. It takes an Iterable of type Long
	 * which contains the registration numbers to be deleted.
	 * 
	 * The method first finds all the vaccine records corresponding to the
	 * registration numbers by using the "findAllById" method of the repository. It
	 * checks whether any records are returned or not.
	 * 
	 * If records are found, it deletes all the records using the
	 * "deleteAllByIdInBatch" method of the repository and returns the count of
	 * records deleted as a String.
	 * 
	 * If no records are found, it returns a message saying "record not found for
	 * deletion".
	 */

}
