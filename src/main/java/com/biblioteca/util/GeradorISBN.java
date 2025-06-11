package com.biblioteca.util;

import java.util.Random;

public class GeradorISBN {

    public static int CalcularDigitoVerificador(String ISBN) {

        int total = 0;

        for (int i = 0; i < 12; i++) {
            int digito = Character.getNumericValue(ISBN.charAt(i));
            total += (i % 2 == 0) ? digito : digito * 3;
        }

        int resto = total % 10;
        return (resto == 0) ? 0 : (10 - resto);

    }

    public static String gerarISBN() {
        Random random = new Random();

        StringBuilder isbn = new StringBuilder("978");

        for (int i = 0; i < 9; i++) {
            isbn.append(random.nextInt(10));
        }

        int digitoVerificador = CalcularDigitoVerificador(isbn.toString());

        isbn.append(digitoVerificador);

        return isbn.toString();
    }
}