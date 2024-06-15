/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

/**
 *
 * @author Wesley
 */
public class Validacao {   

    public static boolean validaCPF(String cpf){        
        if(cpf.length() != 11){
            return false;
        }
        int somaCpf9Digitos = 0;
        int somaCpf10Digitos = 0;
        int digitoVerificadorUm = Integer.parseInt(cpf.substring(9, 10));
        int digitoVerificadorDois = Integer.parseInt(cpf.substring(10));
        int digitoVerificadorUmEncontrado = 0;
        int digitoVerificadorDoisEncontrado = 0;
        
        //convertendo a atring em um array de char
        char[] cpfChar = cpf.toCharArray();
        //converte cada char em int
        int[] cpfInt = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfInt[i] = Integer.parseInt(String.valueOf(cpfChar[i]));
        }
        for(int i = 0, j=10; i < 9; i++, j--){
            
            somaCpf9Digitos+= (cpfInt[i]*j);
        }
        
        //calcula digito verificador 1
        if((somaCpf9Digitos%11) < 2 ){
            digitoVerificadorUmEncontrado = 0;
        }else{
            digitoVerificadorUmEncontrado = 11 - (somaCpf9Digitos%11);
        }
        
        if(digitoVerificadorUmEncontrado != digitoVerificadorUm ){
            return false;
        }else{
            //calcula o digito verificador 2
            for(int i = 0, j=11; i < 10; i++, j--){
                //os 9 primeiros digitos
                if (i < 9)
                somaCpf10Digitos+= (cpfInt[i]*j);
                else
                    somaCpf10Digitos+=digitoVerificadorUmEncontrado*j;
            }
            
            //calcula digito verificador 2
            if( (somaCpf10Digitos%11) < 2 ){
                digitoVerificadorDoisEncontrado = 0;
            }else{
                digitoVerificadorDoisEncontrado = 11 - (somaCpf10Digitos%11);
            }
            
            if(digitoVerificadorDoisEncontrado != digitoVerificadorDois ){
                return false;
            }            
            else{
                return true;
            } 
        }    
    }  
    
    
    public static String textoSemAcentuacaoEallUpperCase(String palavra, String letrasARemover){        
  
       if(palavra.length() > 0 && letrasARemover.contains(palavra.toUpperCase().substring(palavra.length()-1))){
           return palavra.substring(0, palavra.length()-1).toUpperCase();
       }
       return palavra.toUpperCase();
    }
    
    public static String ValidaCEP(char ch, String txt){
        
        return "";
    }
    
    
    public static boolean checkFieldsFormFinanciamento(String[] fields){
        for(String field: fields){
            if( field.isBlank() ){
                return false;
            }
        
        }
        return true;
    }
    
}

