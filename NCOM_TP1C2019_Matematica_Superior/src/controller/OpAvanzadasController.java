
package controller;

import java.awt.event.*;
import model.ComplejoBinomica;
import model.ComplejoPolar;
import model.FlagSyntax;
import view.OpAvanzadasGUI;



public class OpAvanzadasController {
    private ComplejoPolar m_model;
    private OpAvanzadasGUI m_view;
    
    OpAvanzadasController ( ComplejoPolar model, OpAvanzadasGUI view) {
        this.m_model = model;
        this.m_view = view;
        
        view.addPotenciaListener(new PotenciaListener());             
    }
    
    class PotenciaListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String complejoInput = "";
            String indiceInput = "";
            String resultado;

            try {
                complejoInput = m_view.jTextFieldComplejo.getText();
                indiceInput = m_view.jTextFieldIndice.getText();
                FlagSyntax flagSyntax = new FlagSyntax();

                switch (complejoInput.charAt(0)) {
                    case '(' : {
                        ComplejoBinomica cb;
                        int indice;
                        
                        cb = getNumeroBinomicoDeTexto(complejoInput,flagSyntax);
                        indice = getIndiceDeTexto(indiceInput,flagSyntax);
                        
                        if ( flagSyntax.flag == 0 || indice <= 0 ) {
                            m_view.jLabelResultado.setText("SYNTAX ERROR");
                        } else {
                            ComplejoPolar cp = new ComplejoPolar();
                            cp.binomicaAPolar(cb);
                            cp.potenciaNatural(indice);
                            resultado = resultadoPolar(cp);
                            m_view.jLabelResultado.setText(resultado);
                        }
                    }
                    case '[' : {
                        ComplejoPolar cp;
                        int indice;
                        
                        cp = getNumeroPolarDeTexto(complejoInput,flagSyntax);
                        indice = getIndiceDeTexto(indiceInput,flagSyntax);                  
                    
                        if ( flagSyntax.flag == 0 || indice <= 0 ) {
                            m_view.jLabelResultado.setText("SYNTAX ERROR");
                        } else {
                            cp.potenciaNatural(indice);
                            resultado = resultadoPolar(cp);
                            m_view.jLabelResultado.setText(resultado);
                        }
                    }
                }
            } catch (NumberFormatException nfex) {
                m_view.jLabelResultado.setText("SYNTAX ERROR");
            }
        }   
    }
    
    private ComplejoBinomica getNumeroBinomicoDeTexto (String textfield,FlagSyntax flagSyntax){
        ComplejoBinomica numeroComplejo = new ComplejoBinomica();
        String a="0",b="0";
        int comaPos;
        try{
            comaPos= textfield.indexOf(',');
            a=textfield.substring(1,comaPos);
            b=textfield.substring(comaPos+1, textfield.length()-1);
        }catch(StringIndexOutOfBoundsException  e){
            flagSyntax.flag = 0;
        }        
        if (textfield.charAt(textfield.length()-1)!=')'){
           flagSyntax.flag = 0;
        }
        try{
            numeroComplejo.componenteReal = Double.parseDouble(a);             
            numeroComplejo.componenteImaginaria = Double.parseDouble(b);
        }catch(NumberFormatException e){
            flagSyntax.flag = 0;
        }
        return numeroComplejo;
    }
    
    private ComplejoPolar getNumeroPolarDeTexto (String textfield,FlagSyntax flagSyntax){
        ComplejoPolar numeroComplejo = new ComplejoPolar();
        String a="0",b="0";
        int comaPos;
        try{
            comaPos= textfield.indexOf(',');
            a=textfield.substring(1,comaPos);
            b=textfield.substring(comaPos+1, textfield.length()-1);
        }catch(StringIndexOutOfBoundsException  e){
            flagSyntax.flag = 0;
        }        
        if (textfield.charAt(textfield.length()-1)!=']'){
           flagSyntax.flag = 0;
        }
        try{
            numeroComplejo.modulo = Double.parseDouble(a);             
            numeroComplejo.argumento = Double.parseDouble(b);
        }catch(NumberFormatException e){
            flagSyntax.flag = 0;
        }
        return numeroComplejo;
    }    
    
    private int getIndiceDeTexto ( String textfield,FlagSyntax flagSyntax ) {
        int indice = -1;
        try{
            indice = Integer.parseInt(textfield);
        }catch(StringIndexOutOfBoundsException  e){
            flagSyntax.flag = 0;
        }        
        return indice;
    }
    
    private String resultadoPolar (ComplejoPolar resultado){
        String res="[",num;
        Double modulo = resultado.modulo, argumento = resultado.argumento;
        num = modulo.toString();
        res = res.concat(num);
        res = res.concat(",");
        num = argumento.toString();
        res = res.concat(num);
        res = res.concat("]");
        return res;
    }
    
}
