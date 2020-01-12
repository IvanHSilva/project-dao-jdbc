package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		//Department obj = new Department(1, "Books");
		//Seller seller = new Seller(1, "João", "joao@gmail.com", new Date(), 3000.00, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- Teste 1: vendedor findById -----");
		Seller seller = sellerDao.findById(3);
		
		//System.out.println(obj);
		System.out.println(seller);
		
		System.out.println("\n--- Teste 2: vendedor findByDepartment -----");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findbyDepartment(department);
		for (Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println("\n--- Teste 3: vendedor findAll -----");
		list = sellerDao.findAll();
		for (Seller sel : list) {
			System.out.println(sel);
		}

		System.out.println("\n--- Teste 4: vendedor insert -----");
		//Seller newSeller = new Seller(null, "Greg Black", "greg@gmail.com", new Date(), 4000.00, department);
		//sellerDao.insert(newSeller);
		//System.out.println("Novo vendedor cadastrado! Id: " + newSeller.getId());

		System.out.println("\n--- Teste 5: vendedor update -----");
		seller = sellerDao.findById(9);
		seller.setName("Greg Purple");
		sellerDao.update(seller);
		System.out.println("Vendedor alterado!");
	}
}
