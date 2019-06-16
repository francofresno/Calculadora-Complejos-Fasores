package controller;

import java.awt.event.ActionListener;
import model.ComplejoBinomica;
import model.ComplejoPolar;
import model.FlagSyntax;
import view.OpBasicasGUI;

// **ATENCION** Este controlador no se encuentra implementado en la solucion actual
// Se preve en futuras actualizaciones utilizar controladores para delegar el trabajo de la view a los mismos.
public class OpBasicasController implements ActionListener{
    OpBasicasGUI view;
    
    @Override
    public void actionPerformed (java.awt.event.ActionEvent e) {
        String num1,num2,resultado;
        view.jLabelOperator.setText("+");
        num1 = view.jTextFieldComplejo1.getText();
        num2 = view.jTextFieldComplejo2.getText();
        FlagSyntax flagSyntax = new FlagSyntax();
        switch (num1.charAt(0)){
            case '(' : {
                switch (num2.charAt(0)){
                    case '(' :{
                        ComplejoBinomica a,b,suma;            
                        a=getNumeroBinomicoDeTexto(num1,flagSyntax);
                        b=getNumeroBinomicoDeTexto(num2,flagSyntax);
                        if (flagSyntax.flag==1){
                            suma = a.suma(b);  
                            resultado = resultadoBinomica(suma);
                            view.jLabelResultado.setText(resultado);
                        }else{
                            view.jLabelResultado.setText("SYNTAX ERROR");
                        }
                         break;
                    }
                    case '[' : {
                        ComplejoBinomica a,suma,b=new ComplejoBinomica();
                        ComplejoPolar bp;
                        a=getNumeroBinomicoDeTexto(num1,flagSyntax);
                        bp=getNumeroPolarDeTexto(num2,flagSyntax);
                        b=b.polarABinomica(bp);
                        if (flagSyntax.flag==1){
                            suma = a.suma(b);  
                            resultado = resultadoBinomica(suma);
                            view.jLabelResultado.setText(resultado);
                        }else{
                            view.jLabelResultado.setText("SYNTAX ERROR");
                        }
                        break;
                    }
                    default : {
                        view.jLabelResultado.setText("SYNTAX ERROR");
                        break;
                    }
                }
                break;
            }
        case '[':{
                  switch(num2.charAt(0)){
                  case '(' :{
                        ComplejoPolar ap,sumaPolar= new ComplejoPolar();
                        ComplejoBinomica ab = new ComplejoBinomica(),bb,sumaBin;            
                        ap=getNumeroPolarDeTexto(num1,flagSyntax);
                        bb=getNumeroBinomicoDeTexto(num2,flagSyntax);
                        if (flagSyntax.flag==1){
                            ab=ab.polarABinomica(ap);
                            sumaBin = ab.suma(bb);  
                            sumaPolar = sumaPolar.binomicaAPolar(sumaBin);
                            resultado = resultadoPolar(sumaPolar);
                            view.jLabelResultado.setText(resultado);
                        }else{
                            view.jLabelResultado.setText("SYNTAX ERROR");
                        }
                        break;
                    }
                    case '[' : {
                        ComplejoPolar ap,bp,sumaPolar= new ComplejoPolar();
                        ComplejoBinomica ab = new ComplejoBinomica(),bb= new ComplejoBinomica(),sumaBin;            
                        ap=getNumeroPolarDeTexto(num1,flagSyntax);
                        bp=getNumeroPolarDeTexto(num2,flagSyntax);
                        if (flagSyntax.flag==1){
                            ab=ab.polarABinomica(ap);
                            bb=bb.polarABinomica(bp);
                            sumaBin = ab.suma(bb);  
                            sumaPolar = sumaPolar.binomicaAPolar(sumaBin);
                            resultado = resultadoPolar(sumaPolar);
                            view.jLabelResultado.setText(resultado);
                        }else{
                            view.jLabelResultado.setText("SYNTAX ERROR");
                        }
                        break;
                    }
                    default : {
                        view.jLabelResultado.setText("SYNTAX ERROR");
                        break;
                    }
                }
                break;    
        }
        default : view.jLabelResultado.setText("SYNTAX ERROR");
        }   
    }
    
    public void addView(OpBasicasGUI v){
	this.view = v;
    }
    
    private ComplejoPolar getNumeroPolarDeTexto (String textfield,FlagSyntax flagSyntax){
        ComplejoPolar numeroComplejo=new ComplejoPolar();
        String a="0",b="0";
        int comaPos=0;
        try{
            comaPos= textfield.indexOf(';');
            a=textfield.substring(1,comaPos);
            b=textfield.substring(comaPos+1, textfield.length()-1);
        }catch(StringIndexOutOfBoundsException  e){
            flagSyntax.flag=0;
        }        
        if (textfield.charAt(textfield.length()-1)!=']'){
            flagSyntax.flag=0;
        }
        try{
            numeroComplejo.modulo = Double.parseDouble(a);
            numeroComplejo.argumento = Double.parseDouble(b);
        }catch(NumberFormatException e){
            flagSyntax.flag=0;
        }
        return numeroComplejo;
    } 
    
    private ComplejoBinomica getNumeroBinomicoDeTexto (String textfield,FlagSyntax flagSyntax){
        ComplejoBinomica numeroComplejo=new ComplejoBinomica();
        String a="0",b="0";
        int comaPos=0;
        try{
            comaPos= textfield.indexOf(',');
            a=textfield.substring(1,comaPos);
            b=textfield.substring(comaPos+1, textfield.length()-1);
        }catch(StringIndexOutOfBoundsException  e){
            flagSyntax.flag=0;
        }        
        if (textfield.charAt(textfield.length()-1)!=')'){
           
        }
        try{
            numeroComplejo.componenteReal = Double.parseDouble(a);             
            numeroComplejo.componenteImaginaria = Double.parseDouble(b);
        }catch(NumberFormatException e){
             flagSyntax.flag=0;
        }
        return numeroComplejo;
    }
   
    private String resultadoBinomica (ComplejoBinomica resultado){
        String res="(",num;
        Double real = resultado.componenteReal,imaginaria=resultado.componenteImaginaria;
        num = real.toString();
        res=res.concat(num);
        res=res.concat(",");
        num=imaginaria.toString();
        res=res.concat(num);
        res=res.concat(")");
        return res;
    }
    
     private String resultadoPolar (ComplejoPolar resultado){
        String res="[",num;
        Double mod = resultado.modulo,arg=resultado.argumento;
        num = mod.toString();
        res=res.concat(num);
        res=res.concat(";");
        num=arg.toString();
        res=res.concat(num);
        res=res.concat("]");
        return res;
    }
}
