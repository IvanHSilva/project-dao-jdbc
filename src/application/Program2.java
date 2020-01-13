package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		//Department obj = new Department(1, "Books");
		//Department department = new Department(1, "João", "joao@gmail.com", new Date(), 3000.00, obj);
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("--- Teste 1: departamento findById -----");
		Department department = departmentDao.findById(2);
		
		//System.out.println(obj);
		System.out.println(department);
		
		System.out.println("\n--- Teste 2: departamento findAll -----");
		List<Department> list = departmentDao.findAll();
		for (Department dep: list) {
			System.out.println(dep);
		}

		System.out.println("\n--- Teste 3: departamento insert -----");
		Department newDepartment = new Department(null, "Teste");
		departmentDao.insert(newDepartment);
		System.out.println("Novo departamento cadastrado! Id: " + newDepartment.getId());

		System.out.println("\n--- Teste 4: departamento update -----");
		department = departmentDao.findById(newDepartment.getId());
		department.setName("Indefinido");
		departmentDao.update(department);
		System.out.println("Departamento alterado!");

		System.out.println("\n--- Teste 5: departamento delete -----");
		System.out.print("Digite o id do departamento a ser excluído: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Departamento excluído!");
		sc.close();
	}
}
