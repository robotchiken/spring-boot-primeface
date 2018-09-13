package com.takuba;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
        System.out.println("current date : " + localDate);

        localDate = localDate.with(new NextChristmas());
        System.out.println("Next Christmas : " + localDate);

	}

}
