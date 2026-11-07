package Application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main (String [] args){

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();


        System.out.println("=== TEST 1: seller finById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();

        System.out.println("=== TEST 2: seller finByIdDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findBYDepartment(department);
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: seller finByAll ====");
        list = sellerDao.findAll();
        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: seller finByAll ====");
        Seller newSeller = new Seller(4000.0, new Date(), department, "greg@gmail.com", 30,  "Greg");
        sellerDao.insert(newSeller);
        System.out.println ("Inserted! New id = " + newSeller.getId());

        System.out.println("=== TEST 5: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("=== TEST 6: seller delete ====");
        System.out.println("Enter id for delete teste: ");
        int id =  sc.nextInt();
        sellerDao.deleteByID(id);
        System.out.println("Delete completed");
        sc.close();
    }

}
