package br.com.etrust.services;

import br.com.etrust.models.Date;

public class EtrustTest {

	public static void main(String[] args) {
		try {
			
			Date d1 = new Date(1981, 7, 31);
			Date d2 = new Date(2009, 2, 12);
			
			Date.getDiffBetweenDates(d1, d2);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
