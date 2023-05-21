package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> listTax = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int number = sc.nextInt();

		for (int i = 1; i <= number; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			if (type == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditur = sc.nextDouble();
				listTax.add(new Individual(name, anualIncome, healthExpenditur));
			} else {
				System.out.print("Number of employees: ");
				int numberemployees = sc.nextInt();
				listTax.add(new Company(name, anualIncome, numberemployees));
			}

			System.out.println();
		}

		System.out.println("TAXES PAID:");
		double sum = 0.0;
		for (TaxPayer obj : listTax) {
			System.out.println(obj.getName() + String.format(" $ %.2f", obj.tax()));
			sum += obj.tax();
		}
		System.out.print(String.format("TOTAL TAXES: $ %.2f", sum));
		sc.close();
	}

}
