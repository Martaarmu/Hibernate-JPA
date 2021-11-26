import java.util.List;

import model.Autor;
import model.DAO.AutorDAO;

public class testAutor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Autor> autores =AutorDAO.selectByName("Marta");
		for(Autor a:autores) {
			System.out.println(a);
		}
	}

}
