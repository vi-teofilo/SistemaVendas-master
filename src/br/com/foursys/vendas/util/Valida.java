package br.com.foursys.vendas.util;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.ie.IESaoPauloValidator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsável por fazer as validações dos campos do projeto sistema de
 * vendas.
 *
 * @author pbido
 * @since 11/03/2020
 * @version 0.1
 */
public class Valida {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean verificarVazio(String text) {
        text = text.replace("-", "");
        text = text.replace(".", "");
        text = text.replace("/", "");
        text = text.trim();
        return text.equals("");
    }

    public static boolean verificarCombo(int index) {
        return index <= 0;
    }

    public static boolean validarCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        return erros.size() <= 0;
    }

    public static boolean validarCnpj(String cnpj) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        try {
            cnpjValidator.assertValid(cnpj);
            return true;
        } catch (InvalidStateException e) {
            System.out.println(e.getInvalidMessages());
            return false;
        }
    }

    public static boolean validarInscricaoEstadual(String ie) {
        IESaoPauloValidator ieValidator = new IESaoPauloValidator();
        try {
            ieValidator.assertValid(ie);
            return true;
        } catch (InvalidStateException e) {
            System.out.println(e.getInvalidMessages());
            return false;
        }
    }

    public static boolean validarRg(String rg) {
        return rg.equals("00.000.000");
    }

    public static boolean validarData(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//Formata a data
            sdf.setLenient(false);//Seta para que não seja estranha ex:31/02/2019
            sdf.parse(data);//Tenta colocar a string data num objeto date
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVerificada = LocalDate.parse(data, dtf);//Tenta colocar a string data formatada num objeto datetime 
            LocalDate hoje = LocalDate.now();//Verifica se a data é menor que a data atual
            return dataVerificada.compareTo(hoje) <= 0;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean validarNome(String nome) {
        nome = nome.replace(" ", "");
        for (int i = 0; i < nome.length(); i++) {
            return !Character.isAlphabetic((nome.charAt(i)));
        }
        return false;
    }

    public static boolean validarRazaoSocial(String razaoSocial) {
        razaoSocial = razaoSocial.replace(" ", "");
        return razaoSocial.matches("^[a-zA-Z0-9]+$");
    }

    public static boolean validarNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean validarEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean vereficaNaoZero(String total) {
        if (total.equals(0.00)) {
            return false;
        }
        return true;
    }

}
