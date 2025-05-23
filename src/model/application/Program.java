package model.application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller seller1 : list) {
            System.out.println(seller1);
        }

        System.out.println("=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();

        for (Seller seller1 : list) {
            System.out.println(seller1);
        }

        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Vittor Kucharski", "vittor@email.com", LocalDate.now(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("=== TEST 5: seller insert ===");
        seller = sellerDao.findById(1);
        seller.setName("Rafael Lanau");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("=== TEST 6: seller delete ===");
        System.out.print("Enter id for delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
    }
}
