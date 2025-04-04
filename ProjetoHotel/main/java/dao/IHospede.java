package dao;

import java.util.List;
import model.Hospede;

public interface IHospede extends IConexao{
	public void create(Hospede h);

	public void delete(Hospede h);    

	public List<Hospede> getAll();

	public Hospede queryHospede(Hospede h);
}
