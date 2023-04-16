package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronoVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService
{
	@Autowired
	private ICoronaVaccineRepo repo;

	// For single row insertion to DB
	@Override
	public String registerVacine(CoronaVaccine vaccine)
	{
		System.out.println("In Memory proxy class is :: " + repo.getClass().getName());

		CoronaVaccine saveVaccine = null;
		if (vaccine != null)
		{ // directly calling save() from repo interface.
			saveVaccine = repo.save(vaccine);
		}
		return saveVaccine != null ? "vaccine registered succesfully with " + saveVaccine.getRegNo()
				: "vaccine registration failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines)
	{
		if (vaccines != null)
			return repo.saveAll(vaccines); // saving arrayList of vaccines in one go
		else
			throw new IllegalArgumentException("batch insertion not done...");
	}

	@Override
	public Long getVaccineCount()
	{ // select count(*) from CoronaVaccine
		return repo.count();
	}

	@Override
	public boolean checkAvailablityByRegNo(Long regNo)
	{
		return repo.existsById(regNo);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails()
	{ // to get all records from DB as CoronaVaccine object.
		return repo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsByID(List<Long> ids)
	{
		return repo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fecthVaccineById(Long id)
	{
		return repo.findById(id);
	}

	@Override
	public String removeVaccineById(Long id)
	{
		Optional<CoronaVaccine> optional = repo.findById(id);
		// deleting only if record is present in db
		if (optional.isPresent())
		{ /**
			 * Deletes the entity with the given id. If the entity is not found in the
			 * persistence store it is silently ignored.
			 */
			repo.deleteById(id);
			return "record deleted having id:: " + id;
		} else
			return "record not avaialble for deletion with the id ::" + id;
	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vacine)
	{
		Optional<CoronaVaccine> optional = repo.findById(vacine.getRegNo());
		if (optional.isPresent())
		{ /**
			 * throw OptimisticLockingFailureException - when the entity uses optimistic
			 * locking and has a version attribute with a different value from that found in
			 * the persistence store. Also thrown if the entity is assumed to be present but
			 * does not exist in the database.
			 */
			/*
			 * only id need to be correct inside vacine object , all the values can be
			 * anything hibernate only checks id for deletion
			 */
			repo.delete(vacine);
			return "Record deleted with the given id:: " + vacine.getRegNo();
		}
		return "Record not available for deletion with the given id :: " + vacine.getRegNo();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String removeVaccinesById(List<Long> ids)
	{
		Iterable<CoronaVaccine> listEntities = repo.findAllById(ids);
		int count = ids.size();
		if (count == ((List) listEntities).size())
		{
			/**
			 * Deletes all instances of the type T with the given IDs. Entities that aren't
			 * found in the persistence store are silently ignored.
			 * Throws:IllegalArgumentException - in case the given ids or one of its
			 * elements is null.
			 */
			repo.deleteAllById(ids);
			return count + " no of ids are deleted....";
		}
		return "Problem in deleting records";
	}
}
