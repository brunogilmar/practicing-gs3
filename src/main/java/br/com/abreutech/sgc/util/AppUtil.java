package br.com.abreutech.sgc.util;

public final class AppUtil {

    public static String removeMascara(String campo) {
        if(campo != null) {
            campo = campo.replace('.',' ');
            campo = campo.replace('(',' ');
            campo = campo.replace(')',' ');
            campo = campo.replace(':',' ');
            campo = campo.replace('/',' ');
            campo = campo.replace('-',' ');
            campo = campo.replace('_',' ');
            campo = campo.replaceAll(" ","");
        }
        return campo ;
    }

}
