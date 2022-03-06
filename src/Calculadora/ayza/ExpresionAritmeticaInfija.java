/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora.ayza;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author beto
 */
//Es static porq puedo llamar directamente desde otra cosa
public class ExpresionAritmeticaInfija {
   
    private ArrayList<String> conjuntoOperadores;
    private ArrayList<String> alOperandos;    
    private ArrayList<String> operadoresRepetidos;
    private ArrayList<String> expresionesErroneas;    
    private String expresion;    
    private String resultadoParcial; 
    private String resultadoFinal;

    //Constructor
    public ExpresionAritmeticaInfija() {        
        //this.parentesisBalanceados=false;        
        this.resultadoParcial= "";      
        this.resultadoFinal= "a";
        
        this.conjuntoOperadores=new ArrayList<>();
        this.conjuntoOperadores.add("("); //0
        this.conjuntoOperadores.add(")"); //1
        this.conjuntoOperadores.add("!"); 
        this.conjuntoOperadores.add("*");//3
        this.conjuntoOperadores.add("/");
        this.conjuntoOperadores.add("%");        
        this.conjuntoOperadores.add("-");//6 //cambio orden '+,-' por '-,+' --> (por conveniencia)
        this.conjuntoOperadores.add("+");//7
        this.conjuntoOperadores.add("<");
        //this.conjuntoOperadores.add("<="); //9
        this.conjuntoOperadores.add(">");        
        //this.conjuntoOperadores.add(">="); //11
        this.conjuntoOperadores.add("==");
        //this.conjuntoOperadores.add("!=");
        this.conjuntoOperadores.add("&&");
        this.conjuntoOperadores.add("||");       
        
        this.alOperandos=new ArrayList<>();
        String operandoA="";
        String operandoB="";
        this.alOperandos.add(operandoA);
        this.alOperandos.add(operandoB);
        
        this.operadoresRepetidos=new ArrayList<>();
        this.operadoresRepetidos.add("**");
        this.operadoresRepetidos.add("++");
        //this.operadoresRepetidos.add("--");
        this.operadoresRepetidos.add("//");
        this.operadoresRepetidos.add(">>");
        this.operadoresRepetidos.add("<<");
        this.operadoresRepetidos.add(">=>=");
        this.operadoresRepetidos.add("<=<=");
        this.operadoresRepetidos.add("%%");      
        this.operadoresRepetidos.add("&&&&");
        this.operadoresRepetidos.add("====");
        
        this.expresionesErroneas=new ArrayList<>();
        this.expresionesErroneas.add("*/");
        this.expresionesErroneas.add(")(");
        this.expresionesErroneas.add("()");
        this.expresionesErroneas.add("/*");
        this.expresionesErroneas.add("<=>=");
        //this.expresionesErroneas.add("*+");        
        this.expresionesErroneas.add("-*");
        this.expresionesErroneas.add("+*");        
        this.expresionesErroneas.add("!/");
        this.expresionesErroneas.add("!*");
        this.expresionesErroneas.add("!+");
        this.expresionesErroneas.add("!-");
        this.expresionesErroneas.add("!<");
        this.expresionesErroneas.add("!>");
        this.expresionesErroneas.add("!>=");
        this.expresionesErroneas.add("!<=");        
        //los nros pegados a un parentesis desde el lado externo refieren a una expresión incorrecta
        this.expresionesErroneas.add(")0");
        this.expresionesErroneas.add(")1");
        this.expresionesErroneas.add(")2");
        this.expresionesErroneas.add(")3");
        this.expresionesErroneas.add(")4");
        this.expresionesErroneas.add(")5");
        this.expresionesErroneas.add(")6");
        this.expresionesErroneas.add(")7");
        this.expresionesErroneas.add(")8");
        this.expresionesErroneas.add(")9");
        this.expresionesErroneas.add("0(");
        this.expresionesErroneas.add("1(");
        this.expresionesErroneas.add("2(");
        this.expresionesErroneas.add("3(");
        this.expresionesErroneas.add("4(");
        this.expresionesErroneas.add("5(");
        this.expresionesErroneas.add("6(");
        this.expresionesErroneas.add("7(");
        this.expresionesErroneas.add("8(");
        this.expresionesErroneas.add("9(");
        this.expresionesErroneas.add("0!0");
        this.expresionesErroneas.add("0!1");
        this.expresionesErroneas.add("0!2");
        this.expresionesErroneas.add("0!3");
        this.expresionesErroneas.add("0!4");
        this.expresionesErroneas.add("0!5");
        this.expresionesErroneas.add("0!6");
        this.expresionesErroneas.add("0!7");
        this.expresionesErroneas.add("0!8");
        this.expresionesErroneas.add("0!9");      
        
        this.expresionesErroneas.add("1!0");
        this.expresionesErroneas.add("1!1");
        this.expresionesErroneas.add("1!2");
        this.expresionesErroneas.add("1!3");
        this.expresionesErroneas.add("1!4");
        this.expresionesErroneas.add("1!5");
        this.expresionesErroneas.add("1!6");
        this.expresionesErroneas.add("1!7");
        this.expresionesErroneas.add("1!8");
        this.expresionesErroneas.add("1!9");
        
        this.expresionesErroneas.add("2!0");
        this.expresionesErroneas.add("2!1");
        this.expresionesErroneas.add("2!2");
        this.expresionesErroneas.add("2!3");
        this.expresionesErroneas.add("2!4");
        this.expresionesErroneas.add("2!5");
        this.expresionesErroneas.add("2!6");
        this.expresionesErroneas.add("2!7");
        this.expresionesErroneas.add("2!8");
        this.expresionesErroneas.add("2!9");
        
        this.expresionesErroneas.add("3!0");
        this.expresionesErroneas.add("3!1");
        this.expresionesErroneas.add("3!2");
        this.expresionesErroneas.add("3!3");
        this.expresionesErroneas.add("3!4");
        this.expresionesErroneas.add("3!5");
        this.expresionesErroneas.add("3!6");
        this.expresionesErroneas.add("3!7");
        this.expresionesErroneas.add("3!8");
        this.expresionesErroneas.add("3!9");
        
        this.expresionesErroneas.add("4!0");
        this.expresionesErroneas.add("4!1");
        this.expresionesErroneas.add("4!2");
        this.expresionesErroneas.add("4!3");
        this.expresionesErroneas.add("4!4");
        this.expresionesErroneas.add("4!5");
        this.expresionesErroneas.add("4!6");
        this.expresionesErroneas.add("4!7");
        this.expresionesErroneas.add("4!8");
        this.expresionesErroneas.add("4!9");
        
        this.expresionesErroneas.add("5!0");
        this.expresionesErroneas.add("5!1");
        this.expresionesErroneas.add("5!2");
        this.expresionesErroneas.add("5!3");
        this.expresionesErroneas.add("5!4");
        this.expresionesErroneas.add("5!5");
        this.expresionesErroneas.add("5!6");
        this.expresionesErroneas.add("5!7");
        this.expresionesErroneas.add("5!8");
        this.expresionesErroneas.add("5!9");
        
        this.expresionesErroneas.add("6!0");
        this.expresionesErroneas.add("6!1");
        this.expresionesErroneas.add("6!2");
        this.expresionesErroneas.add("6!3");
        this.expresionesErroneas.add("6!4");
        this.expresionesErroneas.add("6!5");
        this.expresionesErroneas.add("6!6");
        this.expresionesErroneas.add("6!7");
        this.expresionesErroneas.add("6!8");
        this.expresionesErroneas.add("6!9");
        
        this.expresionesErroneas.add("7!0");
        this.expresionesErroneas.add("7!1");
        this.expresionesErroneas.add("7!2");
        this.expresionesErroneas.add("7!3");
        this.expresionesErroneas.add("7!4");
        this.expresionesErroneas.add("7!5");
        this.expresionesErroneas.add("7!6");
        this.expresionesErroneas.add("7!7");
        this.expresionesErroneas.add("7!8");
        this.expresionesErroneas.add("7!9");
        
        this.expresionesErroneas.add("8!0");
        this.expresionesErroneas.add("8!1");
        this.expresionesErroneas.add("8!2");
        this.expresionesErroneas.add("8!3");
        this.expresionesErroneas.add("8!4");
        this.expresionesErroneas.add("8!5");
        this.expresionesErroneas.add("8!6");
        this.expresionesErroneas.add("8!7");
        this.expresionesErroneas.add("8!8");
        this.expresionesErroneas.add("8!9");
        
        this.expresionesErroneas.add("9!0");
        this.expresionesErroneas.add("9!1");
        this.expresionesErroneas.add("9!2");
        this.expresionesErroneas.add("9!3");
        this.expresionesErroneas.add("9!4");
        this.expresionesErroneas.add("9!5");
        this.expresionesErroneas.add("9!6");
        this.expresionesErroneas.add("9!7");
        this.expresionesErroneas.add("9!8");
        this.expresionesErroneas.add("9!9");      
    }   
    //evaluar expresion
    public String evaluarExpresion(String expression){   
                    this.expresion=   expression;                    
                    if(this.verificarExpresionesErroneas(this.expresion) == false   ){
                        //Checkar posibles operadores repetidos 
                        if(this.verificarOperadoresRepetidos(this.expresion)==true  ){
                            //Simplificar
                            this.expresion=     this.simplificarOperadoresRepetidos(this.expresion);                        
                        }

                        //reemplazar casos como "--", "+-" y "-+"
                        this.expresion=     this.reemplazarOperadoresEquivalentes(this.expresion);

                        //Si contiene parentesis --> simplificar 
                        if(this.expresion.contains("(")==true       &&      this.expresion.contains(")")==true  ){
                            this.expresion=this.simplificarParentesis(this.expresion);  //Aca se analizan y eliminan todos los parentesis
                        }

                        //Si es una operacion de 'CAMBIO DE SIGNO' "+/-"
                        if (this.validarCambioSigno(this.expresion)==true   ) {
                            this.expresion = this.realizarCambioSigno(this.expresion);                        
                        }

                        //Si es una expresion booleana y contiene signos negativos --> suprimir los mismos
                        if(     (this.expresion.contains("&&")== true       ||        this.expresion.contains("!")== true          ||         this.expresion.contains("||")== true       )       &&        this.expresion.contains("-")==true       ){
                            this.expresion=     this.expresion.replace("-","");
                        }                    
                    }
                    //HAY QUE EVALUAR LA EXPRESION SI: 
                    //1)    Tiene () balanceados; 
                    //2)    No existe un operadorResultado erroneo; 
                    //3)    No hay espacios en blanco;
                    //4)    No hay un operador al final cadena
                    //5)    Ó si empieza por signo ("+" o "-")
                    //6)    Si no es un nro real
                            
                    if(this.verificarParentesisBalanceados(this.expresion)==true      &&      this.verificarOperadoresErroneos(this.expresion)==false       &&       this.verificarEspaciosEnBlanco(this.expresion)==false      &&      this.verificarUltimoCaracterOperador(this.expresion)==false        ){
                                
                                    String operadorSwitch=  "";  
                                    
                                    //AL auxiliar  para los 'boolean cases'
                                    ArrayList<String> operadoresBooleanosAux=   new ArrayList<>();
                                    operadoresBooleanosAux.add("<");
                                    operadoresBooleanosAux.add("<=");
                                    operadoresBooleanosAux.add(">");
                                    operadoresBooleanosAux.add(">=");
                                    operadoresBooleanosAux.add("==");
                                    operadoresBooleanosAux.add("!=");
                                    operadoresBooleanosAux.add("&&");
                                    operadoresBooleanosAux.add("||");
                                    
                                    //SI ES UNA EXPRESION BOOLEANA
                                    for(int i=0;    i<operadoresBooleanosAux.size();    i++){
                                        if(this.expresion.contains(operadoresBooleanosAux.get(i))==true     ){
                                             operadorSwitch=    operadoresBooleanosAux.get(i);
                                             break;
                                        }
                                    }
                                    //Si no hay operadores booleanos
                                    if(operadorSwitch.equals("")==true      ){
                                        //SI ES UNA EXPRESION CON SIGNO +,- (ej "-2", "+3") Y ADEMAS NO HAY UN MULTIPLICADOR [*]
                                        if(this.validarPrimerOperadorEsSigno(this.expresion)==true   &&   this.expresion.contains("*")==false    ){     //&&     this.validarQueEsUnNumeroReal(this.expresion.substring(1,  this.expresion.length() ) )==true  ){
                                            //Si es con SIGNO NEGATIVO
                                            if(String.valueOf(this.expresion.charAt(0)).equals("-")==true   ){
                                                    operadorSwitch=  "";                                            
                                            }else{                                            
                                                //Si es con SIGNO POSITIVO
                                                if(String.valueOf(this.expresion.charAt(0)).equals("+")==true   ){
                                                    this.expresion=     this.reemplazarPorModulo(this.expresion);
                                                    //si solo se trata de un nro real
                                                    if(this.validarQueEsUnNumeroReal(this.expresion)==true  ){
                                                        //primero le quitamos el signo
                                                        this.expresion=     this.expresion.replace("+",    "");
                                                        //mandamos a evaluar como nro real
                                                        operadorSwitch="";
                                                    }
                                                    else{
                                                        //si no se trata de un nro real (o sea, es una expresion comun)
                                                        operadorSwitch=   this.extraerOperadorPorPrivilegio(this.expresion);
                                                    }
                                                }
                                            }                                        
                                        }                                    
                                        //SI ES UNA EXPRESION "COMUN": Sin nada que ver con el signo                                 
                                        else{
                                            //Extraer operador por privilegio para el Switch
                                            operadorSwitch=    this.extraerOperadorPorPrivilegio(this.expresion); 
                                        }                                                       
                                    }//FIN IF NO HAY OPERADORES BOOLEANOS
                                int i, j;                                
                                float opA, opB; //operadores float para guardar resultados                                
                                
                                    switch(operadorSwitch){    //Solo entran expresiones sin parentesis        
                                            //OPERACIONES BOOLEANAS
                                            case "&&":
                                                    try{
                                                        int interruptorA=   0;                                                        
                                                        //OPERANDO A
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("&&")-1;    i>=0;    i--){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando A:      [operadorResultado-"&&"]
                                                                    this.alOperandos.set(0,     this.expresion.substring(i+1,     this.expresion.indexOf("&&")  )  );
                                                                    interruptorA=   1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorA==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                            //extraigo desde principio cadena
                                                            this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf("&&") ) );
                                                        }
                                                        
                                                        //OPERANDO B
                                                        int interruptorB=   0;
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("&&")+2;    i<this.expresion.length();    i++){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro un operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando B: 
                                                                    this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("&&")+2,       this.expresion.indexOf(operadoresBooleanosAux.get(j) ) ) );                                                                    
                                                                    interruptorB=   1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorB==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorB==0){ //o sea, final-cadena es un nro
                                                            //extraigo desde ["&&"+2] hasta finalcadena
                                                            this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("&&")+2,      this.expresion.length() ) );                                                            
                                                        }                                                    
                                                        
                                                        //Paso a float los operandos
                                                        opA=  Float.parseFloat(this.alOperandos.get(0));
                                                        opB=  Float.parseFloat(this.alOperandos.get(1));
                                                        
                                                        //si alguno de los operandos es "0" -->devuelve "0" (FALSE)
                                                        if(opA==0 || opB==0){
                                                            this.resultadoParcial="0";
                                                            JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                        }
                                                        //si no 
                                                        else{   
                                                            //devuelvo aleatorio entre 1-9 (TRUE)
                                                            Random rndm = new Random();
                                                            int nroAleatorio=rndm.nextInt(8)+1;
                                                            this.resultadoParcial=Integer.toString(nroAleatorio);
                                                            JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                        }
                                                        
                                                        //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                        this.expresion=    this.expresion.replace(this.alOperandos.get(0)+"&&"+this.alOperandos.get(1),   this.resultadoParcial    );
                                                        //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                        this.evaluarExpresion(this.expresion);                                                        
                                                        
                                                    }catch(NumberFormatException ex){
                                                        this.resultadoParcial="Sintaxis incoherente! [&&]";
                                                    }
                                                    break;
                                            case "||":
                                                    try{
                                                        int interruptorA=   0;                                                        
                                                        //OPERANDO A
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("||")-1;    i>=0;    i--){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro un operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando A:      [operadorResultado-"&&"]
                                                                    this.alOperandos.set(0,     this.expresion.substring(i+1,    this.expresion.indexOf("||")  )  );
                                                                    interruptorA=   1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorA==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                            //extraigo desde principio cadena
                                                            this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf("||")));
                                                        }
                                                        
                                                        //OPERANDO B
                                                        int interruptorB=   0;
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("||")+2;    i<this.expresion.length();    i++){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro un operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando B:      ["&&"-operadorResultado]
                                                                    this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("||")+2,       i  ) );                                                                    
                                                                    interruptorB=   1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorB==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorB==0){ //o sea, final-cadena es un nro
                                                            //extraigo desde ["&&"+2] hasta finalcadena
                                                            this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("||")+2,      this.expresion.length() ) );                                                            
                                                        }                                                    
                                                        
                                                        //Paso a float los operandos
                                                        opA=  Float.parseFloat(this.alOperandos.get(0));
                                                        opB=  Float.parseFloat(this.alOperandos.get(1));
                                                        
                                                        //si alguno de los operandos es positivo --> devuelve TRUE
                                                        if(opA>0 || opB>0){    
                                                            //devuelvo aleatorio entre 1-9 (TRUE)
                                                            Random rndm =  new Random();
                                                            int nroAleatorio=   rndm.nextInt(8)+1;
                                                            this.resultadoParcial=  Integer.toString(nroAleatorio); 
                                                            JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                        }
                                                        //si no 
                                                        else{   
                                                             this.resultadoParcial=  "0";  
                                                             JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                        }
                                                        
                                                       //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                        this.expresion=    this.expresion.replace(this.alOperandos.get(0)+"||"+this.alOperandos.get(1),   this.resultadoParcial    );
                                                        //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                        this.evaluarExpresion(this.expresion);
                                                        
                                                    }catch(NumberFormatException ex){
                                                        this.resultadoFinal=    "Sintaxis incoherente! [OR]";
                                                    }
                                                    break;
                                            case "==":
                                                    try{
                                                        int interruptorA=0;                                                        
                                                        //OPERANDO A
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("==")-1;    i>=0;    i--){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro un operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando A:      [operadorResultado-"&&"]
                                                                    this.alOperandos.set(0,     this.expresion.substring(i+1,    this.expresion.indexOf("==") ) );
                                                                    interruptorA=   1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorA==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                            //extraigo desde principio cadena
                                                            this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf("==") ) );
                                                        }
                                                        
                                                        //OPERANDO B
                                                        int interruptorB=   0;
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("==")+2;    i<this.expresion.length();    i++){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro un operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando B:      ["&&"-operadorResultado]
                                                                    this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("==")+2,       this.expresion.indexOf(operadoresBooleanosAux.get(j) ) ) );
                                                                    interruptorB=1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorB==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorB==0){ //o sea, final-cadena es un nro
                                                            //extraigo desde ["&&"+2] hasta finalcadena
                                                            this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("==")+2,      this.expresion.length() ) );                                                            
                                                        }                                                    
                                                        
                                                        //Paso a float los operandos
                                                        opA=  Float.parseFloat(this.alOperandos.get(0));
                                                        opB=  Float.parseFloat(this.alOperandos.get(1));
                                                        
                                                        //si A==B -->devuelve TRUE
                                                        if(opA==opB){ 
                                                            //devuelvo aleatorio entre 1-9 (TRUE)
                                                                Random rndm =  new Random();
                                                                int nroAleatorio=   rndm.nextInt(8)+1;
                                                                this.resultadoParcial=  Integer.toString(nroAleatorio);
                                                                JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                        }
                                                        //si no 
                                                        else{   
                                                            this.resultadoParcial="0";    
                                                            JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                        }
                                                        
                                                        //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                        this.expresion=    this.expresion.replace(this.alOperandos.get(0)+"=="+this.alOperandos.get(1),   this.resultadoParcial    );
                                                        //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                        this.evaluarExpresion(this.expresion);
                                                        
                                                    }catch(NumberFormatException ex){
                                                        this.resultadoFinal=    "Sintaxis incoherente! [==]";
                                                    }
                                                    break;
                                                    
                                            case "!=":
                                                    try{
                                                        int interruptorA=0;                                                        
                                                        //OPERANDO A
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("!=")-1;    i>=0;    i--){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro un operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando A:      [operadorResultado-"&&"]
                                                                    this.alOperandos.set(0,     this.expresion.substring(i+1,    this.expresion.indexOf("!=") ) );
                                                                    interruptorA=   1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorA==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                            //extraigo desde principio cadena
                                                            this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf("!=") ) );
                                                        }
                                                        
                                                        //OPERANDO B
                                                        int interruptorB=   0;
                                                        //recorro expresion
                                                        for(i=this.expresion.indexOf("!=")+2;    i<this.expresion.length();    i++){
                                                            //recorro operadores
                                                            for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                //si encuentro un operador booleano
                                                                if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operando B:      ["&&"-operadorResultado]
                                                                    this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("!=")+2,       this.expresion.indexOf(operadoresBooleanosAux.get(j) ) ) );
                                                                    interruptorB=1;
                                                                    break;
                                                                }                                                                
                                                            }
                                                            if(interruptorB==1)     break;
                                                        }
                                                        //si no encontro un operadorResultado
                                                        if(interruptorB==0){ //o sea, final-cadena es un nro
                                                            //extraigo desde ["&&"+2] hasta finalcadena
                                                            this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("!=")+2,      this.expresion.length() ) );                                                            
                                                        }                                                    
                                                        
                                                        //Paso a float los operandos
                                                        opA=  Float.parseFloat(this.alOperandos.get(0));
                                                        opB=  Float.parseFloat(this.alOperandos.get(1));
                                                        
                                                        //si A==B -->devuelve TRUE
                                                        if(opA!=opB){ 
                                                            //devuelvo aleatorio entre 1-9 (TRUE)
                                                                Random rndm =  new Random();
                                                                int nroAleatorio=   rndm.nextInt(8)+1;
                                                                this.resultadoParcial=  Integer.toString(nroAleatorio);
                                                                JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                        }
                                                        //si no 
                                                        else{   
                                                            this.resultadoParcial="0";    
                                                            JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                        }
                                                        
                                                        //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                        this.expresion=    this.expresion.replace(this.alOperandos.get(0)+"!="+this.alOperandos.get(1),   this.resultadoParcial    );
                                                        //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                        this.evaluarExpresion(this.expresion);
                                                        
                                                    }catch(NumberFormatException ex){
                                                        this.resultadoFinal=    "Sintaxis incoherente! [!=]";
                                                    }
                                                    break;
                                                    
                                            case ">":
                                                    try{
                                                        //1)     CHECKEAR QUE NO SEA ">="
                                                        if(String.valueOf(this.expresion.charAt(this.expresion.indexOf(">")+1)).equals("=")==true   ){ //si el siguiente a ">" es un "="
                                                                int interruptorA=   0;                                                        
                                                                //OPERANDO A
                                                                //recorro expresion
                                                                for(i=this.expresion.indexOf(">=")-1;    i>=0;    i--){
                                                                    //recorro operadores
                                                                    for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                        //si encuentro un operador booleano
                                                                        if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                            //extraigo operando A:
                                                                            this.alOperandos.set(0,     this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j) )+1,    this.expresion.indexOf(">=") ) );
                                                                            //si el operador era un "-" --> lo agrego como estaba
                                                                            if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                                this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j) )+1,    this.expresion.indexOf(">=") ) );
                                                                            }
                                                                            interruptorA=   1;
                                                                            break;
                                                                        }                                                                
                                                                    }
                                                                    if(interruptorA==1)     break;
                                                                }
                                                                //si no encontro un operadorResultado
                                                                if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                                    //extraigo desde principio cadena
                                                                    this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf(">=")));
                                                                }

                                                                //OPERANDO B
                                                                int interruptorB=   0;                                                                
                                                                //recorro expresion
                                                                for(i=this.expresion.indexOf(">=")+2;    i<this.expresion.length();    i++){
                                                                    //recorro operadores
                                                                    for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                        //si encuentro un operador booleano
                                                                        if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                            //extraigo operando B:      ["&&"-operadorResultado]
                                                                            this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf(">=")+2,       this.expresion.indexOf(operadoresBooleanosAux.get(j) ) ) );
                                                                            //si el operador era un "-" --> lo agrego como estaba
                                                                            if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                                this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j) )+1,    this.expresion.indexOf(">=") ) );
                                                                            }
                                                                            interruptorB=   1;                                                                            
                                                                            break;
                                                                        }                                                                
                                                                    }
                                                                    if(interruptorB==1)     break;
                                                                }
                                                                //si no encontro un operadorResultado
                                                                if(interruptorB==0){ //o sea, final-cadena es un nro
                                                                    //extraigo desde ["&&"+2] hasta finalcadena
                                                                    this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf(">=")+2,      this.expresion.length() ) );
                                                                }                                                    

                                                                //Paso a float los operandos
                                                                opA=  Float.parseFloat(this.alOperandos.get(0));
                                                                opB=  Float.parseFloat(this.alOperandos.get(1));

                                                                //si A!=B --> devuelve TRUE
                                                                if(opA>=opB){ 
                                                                    //devuelvo aleatorio entre 1-9 (TRUE)
                                                                        Random rndm =  new Random();
                                                                        int nroAleatorio=   rndm.nextInt(8)+1;
                                                                        this.resultadoParcial=  Integer.toString(nroAleatorio);
                                                                        JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                                }
                                                                //si no 
                                                                else{   
                                                                    this.resultadoParcial=  "0";          
                                                                    JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                                }
                                                                
                                                                //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                                this.expresion=    this.expresion.replace(this.alOperandos.get(0)+">="+this.alOperandos.get(1),   this.resultadoParcial    );
                                                                //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                                this.evaluarExpresion(this.expresion);
                                                                
                                                        }
                                                        //********SI SOLO ES ">"
                                                        else{                                                        
                                                            int interruptorA=   0;                                                        
                                                            //OPERANDO A
                                                            //recorro expresion
                                                            for(i=this.expresion.indexOf(">")-1;    i>=0;    i--){
                                                                //recorro operadores
                                                                for(j=0;    j<operadoresBooleanosAux.size();   j++){
                                                                    //si encuentro un "(" o un operadorResultado
                                                                    if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                        //extraigo operando A:      [operadorResultado-">"]
                                                                        this.alOperandos.set(0,     this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j) )+1,    this.expresion.indexOf(">")));
                                                                        //si el operador era un "-" --> lo agrego como estaba
                                                                        if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                            this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j) )+1,    this.expresion.indexOf(">=") ) );
                                                                        }
                                                                        interruptorA=   1;
                                                                        break;
                                                                    }                                                                
                                                                }
                                                                if(interruptorA==1)     break;
                                                            }
                                                            //si no encontro un operadorResultado
                                                            if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                                //extraigo desde principio cadena
                                                                this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf(">")));
                                                            }

                                                            //OPERANDO B
                                                            int interruptorB=   0;                                                            
                                                            //recorro expresion
                                                            for(i=this.expresion.indexOf(">")+1;    i<this.expresion.length();    i++){
                                                                //recorro operadores
                                                                for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                    //si encuentro un ")" o un operadorResultado
                                                                    if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                        //extraigo operando B:      [">"-operadorResultado]
                                                                        this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf(">")+1,       this.expresion.indexOf(operadoresBooleanosAux.get(j) ) ) );
                                                                        //si el operador era un "-" --> lo agrego como estaba
                                                                        if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                            this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j))+1,    this.expresion.indexOf(">=") ) );
                                                                        }
                                                                        interruptorB=   1;                                                                        
                                                                        break;
                                                                    }                                                                
                                                                }
                                                                if(interruptorB==1)     break;
                                                            }
                                                            //si no encontro un operadorResultado
                                                            if(interruptorB==0){ //o sea, final-cadena es un nro
                                                                //extraigo desde [">"+1] hasta finalcadena
                                                                this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf(">")+1,      this.expresion.length()));
                                                            }                                                    

                                                            //Paso a float los operandos
                                                            opA=  Float.parseFloat(this.alOperandos.get(0));
                                                            opB=  Float.parseFloat(this.alOperandos.get(1));

                                                            //si los operando A mayor que operando B
                                                            if(opA > opB){
                                                                    //devuelvo aleatorio entre 1-9 (TRUE)
                                                                    Random rndm =  new Random();
                                                                    int nroAleatorio=   rndm.nextInt(8)+1;
                                                                    this.resultadoParcial=  Integer.toString(nroAleatorio);
                                                                    JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                            }
                                                            //si no 
                                                            else{   
                                                                this.resultadoParcial="0";           
                                                                JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                            }
                                                            
                                                            //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                                this.expresion=    this.expresion.replace(this.alOperandos.get(0)+">"+this.alOperandos.get(1),   this.resultadoParcial    );
                                                                //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                                this.evaluarExpresion(this.expresion);
                                                        }
                                                    }catch(NumberFormatException ex){
                                                        this.resultadoFinal=   "Sintaxis incoherente!";
                                                    }                                                    
                                                    break;                                            
                                                    
                                            case "<":                                                    
                                                    try{
                                                        //1)     CHECKEAR QUE NO SEA "<="
                                                        if(String.valueOf(this.expresion.charAt(this.expresion.indexOf("<")+1)).equals("=")==true){ //si el siguiente a "<" es un "="
                                                                int interruptorA=   0;                                                        
                                                                //OPERANDO A
                                                                //recorro expresion
                                                                for(i=this.expresion.indexOf("<=")-1;    i>=0;    i--){
                                                                    //recorro operadores
                                                                    for(j=0;   j<operadoresBooleanosAux.size();    j++){
                                                                        //si encuentro un operador booleano
                                                                        if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene                                                                            //extraigo operando A:      [operadorResultado-"&&"]
                                                                            //operando A: desde dicho operador hasta "<="
                                                                            this.alOperandos.set(0,     this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j))+1,    this.expresion.indexOf("<="))  );
                                                                            //si el operador era un "-" --> lo agrego como estaba
                                                                            if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                                this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j))+1,    this.expresion.indexOf(">=") ) );
                                                                            }
                                                                            interruptorA=   1;
                                                                            break;
                                                                        }                                                                
                                                                    }
                                                                    if(interruptorA==1)     break;
                                                                }
                                                                //si no encontro un operadorResultado
                                                                if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                                    //extraigo desde principio cadena
                                                                    this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf("<=")));
                                                                }

                                                                //OPERANDO B
                                                                int interruptorB=   0;                                                                
                                                                //recorro expresion
                                                                for(i=this.expresion.indexOf("<=")+2;    i<this.expresion.length();    i++){
                                                                    //recorro operadores
                                                                    for(j=0;  j<operadoresBooleanosAux.size();   j++){
                                                                        //si encuentro un operador booleano
                                                                        if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                            //extraigo operando B hasta dicho operador
                                                                            this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("<=")+2,       this.expresion.indexOf(operadoresBooleanosAux.get(j) ) ) );
                                                                            //si el operador era un "-" --> lo agrego como estaba
                                                                            if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                                this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j))+1,    this.expresion.indexOf(">=") ) );
                                                                            }
                                                                            interruptorB=   1;                                                                            
                                                                            break;
                                                                        }                                                                
                                                                    }
                                                                    if(interruptorB==1)     break;
                                                                }
                                                                //si no encontro un operadorResultado
                                                                if(interruptorB==0){ //o sea, final-cadena es un nro
                                                                    //extraigo desde ["&&"+2] hasta finalcadena
                                                                    this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("<=")+2,      this.expresion.length() ) );
                                                                }                                                    

                                                                //Paso a float los operandos
                                                                opA=  Float.parseFloat(this.alOperandos.get(0));
                                                                opB=  Float.parseFloat(this.alOperandos.get(1));

                                                                //si A!=B --> devuelve TRUE
                                                                if(opA<=opB){ 
                                                                    //devuelvo aleatorio entre 1-9 (TRUE)
                                                                        Random rndm = new Random();
                                                                        int nroAleatorio=rndm.nextInt(8)+1;
                                                                        this.resultadoParcial=Integer.toString(nroAleatorio);
                                                                        JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                                }
                                                                //si no 
                                                                else{   
                                                                    this.resultadoParcial="0";  
                                                                    JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                                }
                                                                
                                                                //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                                this.expresion=    this.expresion.replace(this.alOperandos.get(0)+"<="+this.alOperandos.get(1),   this.resultadoParcial    );
                                                                //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                                this.evaluarExpresion(this.expresion);
                                                                
                                                        }
                                                        //********SI SOLO ES "<"
                                                        else{                                                        
                                                            int interruptorA=   0;                                                            
                                                            //OPERANDO A
                                                            //recorro expresion
                                                            for(i=this.expresion.indexOf("<")-1;    i>=0;    i--){
                                                                //recorro operadores
                                                                for(j=0;    j<operadoresBooleanosAux.size();   j++){
                                                                    //si encuentro un operador booleano
                                                                    if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                        //extraigo operando A desde dicho operador
                                                                        this.alOperandos.set(0,     this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j) )+1,    this.expresion.indexOf("<") ) );
                                                                        //si el operador era un "-" --> lo agrego como estaba
                                                                        if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                            this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j) )+1,    this.expresion.indexOf(">=") ) );
                                                                        }
                                                                        interruptorA=   1;
                                                                        break;
                                                                    }                                                                
                                                                }
                                                                if(interruptorA==1)     break;
                                                            }
                                                            //si no encontro un operadorResultado
                                                            if(interruptorA==0){ //o sea, principio-cadena es un nro
                                                                //extraigo desde principio cadena
                                                                this.alOperandos.set(0,     this.expresion.substring(0,      this.expresion.indexOf("<")));
                                                            }

                                                            //OPERANDO B
                                                            int interruptorB=   0;                                                            
                                                            //recorro expresion
                                                            for(i=this.expresion.indexOf("<")+1;    i<this.expresion.length();    i++){
                                                                //recorro operadores
                                                                for(j=0;   j<operadoresBooleanosAux.size();   j++){
                                                                    //si encuentro un operador booleano
                                                                    if(String.valueOf(this.expresion.charAt(i) ).equals(String.valueOf(operadoresBooleanosAux.get(j) ) ) ==true         ||         operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true       ){    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                        //extraigo operando B desde ["<"+1] hasta dicho operador
                                                                        this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("<")+1,       this.expresion.indexOf(operadoresBooleanosAux.get(j) ) ) );
                                                                        //si el operador era un "-" --> lo agrego como estaba
                                                                        if(String.valueOf(this.expresion.charAt(i)) .equals("-")==true     ){
                                                                            this.alOperandos.set(0,     "-"+this.expresion.substring(this.expresion.indexOf(operadoresBooleanosAux.get(j))+1,    this.expresion.indexOf(">=") ) );
                                                                        }
                                                                        interruptorB=   1;                                                                        
                                                                        break;
                                                                    }                                                                
                                                                }
                                                                if(interruptorB==1)     break;
                                                            }
                                                            //si no encontro un operadorResultado
                                                            if(interruptorB==0){ //o sea, final-cadena es un nro
                                                                //extraigo desde [">"+1] hasta finalcadena
                                                                this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("<")+1,      this.expresion.length() ) );
                                                            }                                                    

                                                            //Paso a float los operandos
                                                            opA=  Float.parseFloat(this.alOperandos.get(0));
                                                            opB=  Float.parseFloat(this.alOperandos.get(1));

                                                            //si los operando A mayor que operando B
                                                            if(opA < opB){
                                                                    //devuelvo aleatorio entre 1-9 (TRUE)
                                                                    Random rndm = new Random();
                                                                    int nroAleatorio=rndm.nextInt(8)+1;
                                                                    this.resultadoParcial=Integer.toString(nroAleatorio);
                                                                    JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                            }
                                                            //si no 
                                                            else{   
                                                                this.resultadoParcial="0";
                                                                JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                            }
                                                            
                                                            //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                            this.expresion=    this.expresion.replace(this.alOperandos.get(0)+"<"+this.alOperandos.get(1),   this.resultadoParcial    );
                                                            //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                            this.evaluarExpresion(this.expresion);
                                                        }
                                                    }catch(NumberFormatException ex){
                                                        this.resultadoFinal=     "Sintaxis incoherente!";
                                                    }                                                    
                                                    break;
                                            
                                            case "!":
                                                    try{                                                                     
                                                        int interruptor = 0;

                                                        //OPERANDO UNICO                                                         
                                                        //recorro expresion
                                                        for (i = this.expresion.indexOf("!") + 1; i < this.expresion.length(); i++) { //busco el primer operador que encuentre que NO sea "!"
                                                            //recorro operadores
                                                            for (j = 0; j < operadoresBooleanosAux.size(); j++) {
                                                                //si encuentro un operador booleano
                                                                if (String.valueOf(this.expresion.charAt(i)).equals(String.valueOf(operadoresBooleanosAux.get(j))) == true || operadoresBooleanosAux.get(j).contains(String.valueOf(this.expresion.charAt(i))) == true) {    //Si se topa con un operador booleano o este ultimo lo contiene
                                                                    //extraigo operandoUnico hasta dicho operador
                                                                    this.alOperandos.set(0, this.expresion.substring(this.expresion.indexOf("!") + 1, this.expresion.indexOf(String.valueOf(this.expresion.charAt(i)))));
                                                                    //guardo posicion de primer aparicion de algun operando
                                                                    interruptor = 1;
                                                                    break;
                                                                }
                                                            }
                                                            if (interruptor == 1) {
                                                                break;
                                                            }
                                                        }

                                                        //si no encontro ningun operador
                                                        if (interruptor == 0) { //o sea, final-cadena es un nro
                                                            //extraigo desde ["!"+1] hasta finalcadena
                                                            this.alOperandos.set(0, this.expresion.substring(this.expresion.indexOf("!") + 1, this.expresion.length()));
                                                        }

                                                        //Paso a float el operandoUnico
                                                        float operandoUnico = Float.parseFloat(this.alOperandos.get(0));

                                                        //si el operandoUnico es "0" [FALSO]
                                                        if (operandoUnico == 0) {
                                                            //devuelvo aleatorio entre 1-9 (TRUE)
                                                            Random rndm = new Random();
                                                            int nroAleatorio = rndm.nextInt(8) + 1;
                                                            this.resultadoParcial = Integer.toString(nroAleatorio);
                                                            JOptionPane.showMessageDialog(null, "La operacion devuelve TRUE");
                                                        } //si no 
                                                        else {
                                                            this.resultadoParcial = "0";
                                                            JOptionPane.showMessageDialog(null, "La operacion devuelve FALSE");
                                                        }

                                                        //Actualizo expresion y reevaluo por si es mas compleja                                                                
                                                        this.expresion = this.expresion.replace("!" + this.alOperandos.get(0), this.resultadoParcial);
                                                        //Re-evaluo hasta que quede un nro el cual se va a mandar por [case ("")] y ahi da el resultadoParcial
                                                        this.evaluarExpresion(this.expresion);

                                                    } catch (NumberFormatException ex) {
                                                        this.resultadoFinal = "Sintaxis incoherente!";
                                                    }
                                                break;
                                            //OPERACIONES ARITMETICAS
                                            case "%":
                                                    try{
                                                        //OPERANDO A: parto del primer ["+"-1] a izq. 
                                                        int interruptorA = 0;
                                                        for (i = this.expresion.indexOf("%") - 1; i >= 0; i--) {
                                                            //for para recorrer conjuntoOperadores
                                                            for (j = 0; j < this.conjuntoOperadores.size(); j++) {
                                                                //si encuentra un operador
                                                                if (this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i))) == true || this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i))) == true) {
                                                                    this.alOperandos.set(0,     this.expresion.substring(i + 1, this.expresion.indexOf("%")));
                                                                    //en el caso dicho operador  era un "-"
                                                                    if(this.conjuntoOperadores.get(j).equals("-")==true     ){
                                                                        //concateno el operador "-" a lo substraido
                                                                        this.alOperandos.set(0,     "-"+this.expresion.substring(i + 1, this.expresion.indexOf("%") ) );
                                                                    }
                                                                    interruptorA = 1;
                                                                    break;
                                                                }
                                                            }//fin for conjuntoOperadores        
                                                            if (interruptorA == 1) {
                                                                break;
                                                            }
                                                        }//cierra for expresion
                                                            
                                                        if (interruptorA == 0) {
                                                          //si encuentra principio cadena y es un nro
                                                          this.alOperandos.set(0, this.expresion.substring(0,   this.expresion.indexOf("%")));
                                                        }                                                            
                                                            //OPERANDO B: parto del primer ["+"+1] a derecha
                                                            int interruptorB=   0;                                                                                                                      
                                                            //recorro expresion
                                                            for(i= this.expresion.indexOf("%")+1;    i<this.expresion.length();    i++){   
                                                                //recorro operadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){
                                                                    //SI SE TOPA CON CUALQUIER OPERADOR, cerrar operando B, salvo que sea signo [-] al comienzo del mismo
                                                                    if(this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )      &&       this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i) ) )==true        &&      (i!=this.expresion.indexOf("%")+1)      ){
                                                                        //1)  Si encuentra operador cierra operando B
                                                                        this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("%")+1,     i   )  );
                                                                        interruptorB=   1;
                                                                        break;                                                                                                                                                
                                                                    }                                                                    
                                                                }//cierre FOR operadores 
                                                                if(interruptorB==1){    
                                                                   break;
                                                                }
                                                            }//cierra FOR de la expresion
                                                                         
                                                            //2) Si no encuentra ningun operador (o sea, llega a final cadena)
                                                            if(interruptorB==0){  
                                                                //Operando B: del [%] hasta final cadena
                                                                this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("%")+1,     this.expresion.length()  )  );
                                                            }

                                                            //1)    RESULTADO DE LA OPERACION
                                                            opA=     (Float.parseFloat(this.alOperandos.get(0)));
                                                            opB=      (Float.parseFloat(this.alOperandos.get(1)));                                                            
                                                            this.resultadoParcial=    Float.toString(opA % opB);

                                                            //2)    REEMPLAZO LA OPERACION POR EL RESULTADO --> ACTUALIZO                                                   
                                                            this.expresion=    this.expresion.replace(this.alOperandos.get(0)+ "%" +this.alOperandos.get(1),    this.resultadoParcial);

                                                            //3)   RE-ANALIZO
                                                            this.evaluarExpresion(this.expresion);

                                                    }catch(NumberFormatException ex){
                                                         this.resultadoFinal=    "Sintaxis incoherente!     [%]";
                                                    }
                                                    break;
                                            case "*":
                                                    try{
                                                        //OPERANDO A: parto del primer ["+"-1] a izq. 
                                                        int interruptorA = 0;
                                                        for (i = this.expresion.indexOf("*") - 1; i >= 0; i--) {
                                                            //for para recorrer conjuntoOperadores
                                                            for (j = 0; j < this.conjuntoOperadores.size(); j++) {
                                                                //si encuentra un operador
                                                                if (this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i))) == true    ||      this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i))) == true) {
                                                                    this.alOperandos.set(0,     this.expresion.substring(i + 1, this.expresion.indexOf("*")));
                                                                    //en el caso dicho operador  era un "-"
                                                                    if(this.conjuntoOperadores.get(j).equals("-")==true     ){
                                                                        //concateno el operador "-" a lo substraido
                                                                        this.alOperandos.set(0,     "-"+this.expresion.substring(i + 1, this.expresion.indexOf("*") ) );
                                                                    }
                                                                    interruptorA = 1;
                                                                    break;
                                                                }
                                                            }//fin for conjuntoOperadores        
                                                            if (interruptorA == 1) {
                                                                break;
                                                            }
                                                        }//cierra for expresion
                                                            
                                                        if (interruptorA == 0) {
                                                          //si encuentra principio cadena y es un nro
                                                          this.alOperandos.set(0, this.expresion.substring(0,   this.expresion.indexOf("*")));
                                                        }                                                            
                                                            //OPERANDO B: parto del primer ["+"+1] a derecha
                                                            int interruptorB=   0;                                                                                                                      
                                                            //recorro expresion
                                                            for(i= this.expresion.indexOf("*")+1;    i<this.expresion.length();    i++){   
                                                                //recorro operadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){
                                                                    //SI SE TOPA CON CUALQUIER OPERADOR, cerrar operando B, salvo que sea signo [-] al comienzo del mismo
                                                                    if(this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )      &&       this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i) ) )==true        &&      (i!=this.expresion.indexOf("*")+1)      ){
                                                                        //1)  Si encuentra operador cierra operando B
                                                                        this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("*")+1,     i   )  );
                                                                        interruptorB=   1;
                                                                        break;                                                                                                                                                
                                                                    }                                                                    
                                                                }//cierre FOR operadores 
                                                                if(interruptorB==1){    
                                                                   break;
                                                                }
                                                            }//cierra FOR de la expresion
                                                                         
                                                            //2) Si no encuentra ningun operador (o sea, llega a final cadena)
                                                            if(interruptorB==0){  
                                                                //Operando B: del [%] hasta final cadena
                                                                this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("*")+1,     this.expresion.length()  )  );
                                                            }

                                                            //1)    RESULTADO DE LA OPERACION
                                                            opA=     (Float.parseFloat(this.alOperandos.get(0)));
                                                            opB=      (Float.parseFloat(this.alOperandos.get(1)));                                                            
                                                            this.resultadoParcial=    Float.toString(opA * opB);

                                                            //2)    REEMPLAZO LA OPERACION POR EL RESULTADO --> ACTUALIZO                                                   
                                                            this.expresion=    this.expresion.replace(this.alOperandos.get(0)+ "*" +this.alOperandos.get(1),    this.resultadoParcial);

                                                            //3)   RE-ANALIZO
                                                            this.evaluarExpresion(this.expresion);

                                                    }catch(NumberFormatException ex){
                                                      this.resultadoFinal=   "Sintaxis incoherente!     [*]";
                                                    }
                                                    break;
                                            case "+":                                                                                      
                                                    try{                                                
                                                        //OPERANDO A: parto del primer ["+"-1] a izq. 
                                                            int interruptorA=0;
                                                            for(i=this.expresion.indexOf("+")-1;     i>=0;   i--){  
                                                                //for para recorrer conjuntoOperadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){                                                        
                                                                    //si encuentra un operador
                                                                    if(this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true      ||      this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i) ) )==true    ){
                                                                        this.alOperandos.set(0,     this.expresion.substring(i+1,   this.expresion.indexOf("+") ) );
                                                                        interruptorA=1;
                                                                        break;
                                                                    }
                                                                }//fin for conjuntoOperadores    
                                                                if(interruptorA==1)     break;
                                                            }//cierra for operando A
                                                            
                                                            if(interruptorA==0){
                                                                //si encuentra principio cadena y es un nro
                                                                this.alOperandos.set(0,     this.expresion.substring(0,   this.expresion.indexOf("+") ) );
                                                            }
                                                            
                                                            int interruptorB=0; 
                                                            //OPERANDO B: parto del primer ["+"+1] a derecha
                                                            for(i= this.expresion.indexOf("+")+1;    i<this.expresion.length();    i++){   
                                                                //for para conjuntoOperadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){
                                                                    //SI SE TOPA CON CUALQUIER OPERADOR
                                                                    if(this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i))) || this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i) ) ) ){
                                                                        //Operando B es igual a "*" hasta dicho operador
                                                                        this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("+")+1, i)  );  
                                                                        interruptorB=1;
                                                                        break;
                                                                    }                                                                    
                                                                }//cierre FOR conjuntoOperadores 
                                                                if(interruptorB==1)     break;
                                                            }//cierra FOR operando B
                                                                         
                                                            if(interruptorB==0){  
                                                                //Operando B: va del "*" a final cadena
                                                                this.alOperandos.set(1,     expresion.substring(expresion.indexOf("+")+1, expresion.length()));
                                                            }

                                                            //1)    RESULTADO DE LA SUMA
                                                            float resultadoTmp1=     Float.parseFloat(this.alOperandos.get(0)) + Float.parseFloat(this.alOperandos.get(1));                                            
                                                            this.resultadoParcial=    Float.toString(resultadoTmp1);

                                                            //2)    REEMPLAZO LA OPERACION POR EL RESULTADO --> ACTUALIZO                                                   
                                                            this.expresion=    this.expresion.replace(this.alOperandos.get(0)+ "+" +this.alOperandos.get(1),    this.resultadoParcial);

                                                            //3)   RE-ANALIZO
                                                            this.evaluarExpresion(this.expresion);                                                            
                                                    }catch(NumberFormatException ex){
                                                      this.resultadoFinal=     "Sintaxis incoherente! [+]";
                                                    }
                                                    break;
                                            case "-":                                                    
                                                    try{                                                                                                             int interruptorA=0;
                                                            
                                                            //CASO QUE EMPIECE CON "-"                                                            
                                                            if(String.valueOf(this.expresion.charAt(0)).equals("-")==true   ){
                                                                //operandoA va desde i=0 hasta siguiente operador
                                                                
                                                            }
                                                            //CASO QUE NO EMPIECE CON "-"
                                                            for(i=this.expresion.indexOf("-")-1;     i>=0;   i--){  
                                                                //for para recorrer conjuntoOperadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){                                                        
                                                                    //si encuentra un operador
                                                                    if(this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )==true      ||      this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i) ) )==true    ){
                                                                        this.alOperandos.set(0,     this.expresion.substring(i+1,   this.expresion.indexOf("-") ) );
                                                                        interruptorA=1;
                                                                        break;
                                                                    }
                                                                }//fin for conjuntoOperadores                                                                                                                  
                                                            }//cierra for operando A
                                                            
                                                            if(interruptorA==0){
                                                                
                                                                //si encuentra principio cadena y es un nro
                                                                this.alOperandos.set(0,     this.expresion.substring(0,   this.expresion.indexOf("-") ) );
                                                            }
                                                            
                                                            int interruptorB=0; 
                                                            //OPERANDO B: parto del primer ["+"+1] a derecha
                                                            for(i= this.expresion.indexOf("-")+1;    i<this.expresion.length();    i++){   
                                                                //for para conjuntoOperadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){
                                                                    //SI SE TOPA CON CUALQUIER OPERADOR
                                                                    if(this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )       ||      this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i) ) ) ){
                                                                        //Operando B es igual a "*" hasta dicho operador
                                                                        this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("-")+1,     i)  );  
                                                                        interruptorB=1;
                                                                        break;
                                                                    }                                                                    
                                                                }//cierre FOR conjuntoOperadores 
                                                                if(interruptorB==1)     break;
                                                            }//cierra FOR operando B
                                                                         
                                                            if(interruptorB==0){  
                                                                //Operando B: va del "*" a final cadena
                                                                this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("-")+1,      this.expresion.length() ) );
                                                            }

                                                            //1)    RESULTADO DE LA SUMA
                                                            float resultadoTmp1=     Float.parseFloat(this.alOperandos.get(0)) - Float.parseFloat(this.alOperandos.get(1));                                            
                                                            this.resultadoParcial=    Float.toString(resultadoTmp1);

                                                            //2)    REEMPLAZO LA OPERACION POR EL RESULTADO --> ACTUALIZO                                                   
                                                            this.expresion=    this.expresion.replace(this.alOperandos.get(0)+ "-" +this.alOperandos.get(1),    this.resultadoParcial );

                                                            //3)   RE-ANALIZO
                                                            this.evaluarExpresion(this.expresion); 

                                                    }catch(NumberFormatException ex){
                                                       this.resultadoFinal=     "Sintaxis incoherente! [-] ";
                                                    }
                                                    break;
                                            case "/":
                                                    try{
                                                        //OPERANDO A: parto del primer ["+"-1] a izq. 
                                                            int interruptorA=0;
                                                            for(i=this.expresion.indexOf("/")-1;     i>=0;   i--){  
                                                                //for para recorrer conjuntoOperadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){                                                        
                                                                    //si encuentra un operador
                                                                    if (this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i))) == true || this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i))) == true) {
                                                                        this.alOperandos.set(0,     this.expresion.substring(i+1,   this.expresion.indexOf("/") ) );
                                                                        interruptorA=1;
                                                                        break;
                                                                    }
                                                                }//fin for conjuntoOperadores
                                                                if(interruptorA==1)     break;
                                                            }//cierra for operando A
                                                            
                                                            if(interruptorA==0){
                                                                //si encuentra principio cadena y es un nro
                                                                this.alOperandos.set(0,     this.expresion.substring(0,   this.expresion.indexOf("/") ) );
                                                            }
                                                            
                                                            int interruptorB=0; 
                                                            //OPERANDO B: parto del primer ["+"+1] a derecha
                                                            for(i= this.expresion.indexOf("/")+2;    i<this.expresion.length();    i++){   
                                                                //for para conjuntoOperadores
                                                                for(j=0;    j<this.conjuntoOperadores.size();    j++){
                                                                    //SI SE TOPA CON CUALQUIER OPERADOR
                                                                    if(this.conjuntoOperadores.get(j).contains(String.valueOf(this.expresion.charAt(i) ) )      &&       this.conjuntoOperadores.get(j).equals(String.valueOf(this.expresion.charAt(i) ) )==true        &&      (i!=this.expresion.indexOf("%")+1)      ){
                                                                        //Operando B es igual a "*" hasta dicho operador
                                                                        this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("/")+1, i)  );  
                                                                        interruptorB=   1;
                                                                        break;
                                                                    }                                                                    
                                                                }//cierre FOR conjuntoOperadores 
                                                                if(interruptorB==1)     break;
                                                            }//cierra FOR operando B
                                                                         
                                                            if(interruptorB==0){  
                                                                //Operando B: va del "*" a final cadena
                                                                this.alOperandos.set(1,     this.expresion.substring(this.expresion.indexOf("/")+1,   this.expresion.length()));
                                                            }

                                                            //1)    RESULTADO DE LA SUMA
                                                            float resultadoTmp1=     Float.parseFloat(this.alOperandos.get(0)) / Float.parseFloat(this.alOperandos.get(1));                                            
                                                            this.resultadoParcial=    Float.toString(resultadoTmp1);

                                                            //2)    REEMPLAZO LA OPERACION POR EL RESULTADO --> ACTUALIZO                                                   
                                                            this.expresion=    this.expresion.replace(this.alOperandos.get(0)+ "/" +this.alOperandos.get(1),    this.resultadoParcial );

                                                            //3)   RE-ANALIZO
                                                            this.evaluarExpresion(this.expresion);

                                                    }catch(NumberFormatException ex){
                                                       this.resultadoFinal=    "Sintaxis incoherente!   [/]";
                                                    }
                                                    break;
                                            
                                            case "":
                                                    //Si NO hay operadorResultado:
                                                    //1)    Si viene un nro entre parentesis
                                                    //2)    Empieza por "-"
                                                    //3)    Si viene un nro solo
                                                    
                                                    try{
                                                        //1)    SI VIENE NRO ENTRE PARENTESIS
                                                        if(this.expresion.contains("(")==true   &&   this.expresion.contains(")")==true  ){
                                                            this.resultadoFinal=     this.simplificarParentesis(this.expresion);                                                            
                                                        }
                                                        else{
                                                            //2)    SI EMPIEZA POR SIGNO NEGATIVO                                                            
                                                            //extraemos operador siguiente o final cadena 
                                                            ArrayList<Integer> conjuntoPosicionesOperadores=     new ArrayList<>();
                                                            conjuntoPosicionesOperadores=   this.extraerSiguientesOperadores(this.expresion);   
                                                            //Si: 
                                                            //1)    Comienza con signo [-]
                                                            //2)    Es una expresion aritmetica (NO un nro real)
                                                            if(String.valueOf(this.expresion.charAt(0)).equals("-")==true      &&       this.validarQueEsUnNumeroReal(this.expresion)==false     ){ 
                                                                //OPERANDO A
                                                                this.alOperandos.set(0,     this.expresion.substring(0,    conjuntoPosicionesOperadores.get(1)   )  );
                                                                //OPERANDO B: 
                                                                if(conjuntoPosicionesOperadores.size() > 3  ){                        
                                                                    //1)    caso que se extraiga hasta siguiente operador
                                                                    this.alOperandos.set(1,     this.expresion.substring(conjuntoPosicionesOperadores.get(1) +1,     conjuntoPosicionesOperadores.get(2)   )  );
                                                                }
                                                                else{
                                                                    //2)    caso que se extraiga hasta final cadena
                                                                    if(conjuntoPosicionesOperadores.size() <= 3  ){ 
                                                                        JOptionPane.showMessageDialog(null, "a");
                                                                        this.alOperandos.set(1,     this.expresion.substring(conjuntoPosicionesOperadores.get(1) +1,     conjuntoPosicionesOperadores.get(2)  )  );
                                                                    }
                                                                }
                                                                //Pasar operandos a float
                                                                opA = Float.parseFloat(this.alOperandos.get(0));
                                                                opB = Float.parseFloat(this.alOperandos.get(1));
                                                                //si el siguiente operador es un "+"
                                                                if (String.valueOf(this.expresion.charAt(conjuntoPosicionesOperadores.get(1))).equals("+")==true   ) {
                                                                    //guardo la operacion
                                                                        this.resultadoParcial=  Float.toString(opA + opB);
                                                                        //reemplazo en la expresion
                                                                        this.expresion=     this.expresion.replace(this.alOperandos.get(0)+"+"+this.alOperandos.get(1),       this.resultadoParcial     );
                                                                        //reevaluo en caso de que this.expresion fuera mas extensa
                                                                        this.evaluarExpresion(this.expresion);                                                                        
                                                                } 
                                                                else {
                                                                    //si el siguiente operador es un "-"
                                                                    if (String.valueOf(this.expresion.charAt(conjuntoPosicionesOperadores.get(1))).equals("-")==true   ) {
                                                                        //guardo la operacion
                                                                        this.resultadoParcial=  Float.toString(opA - opB);
                                                                        //reemplazo en la expresion
                                                                        this.expresion=     this.expresion.replace(this.alOperandos.get(0)+"-"+this.alOperandos.get(1),       this.resultadoParcial);
                                                                        //reevaluo en caso de que this.expresion fuera mas extensa
                                                                        this.evaluarExpresion(this.expresion);
                                                                    }
                                                                    else{
                                                                        //si el siguiente operador es "/"
                                                                        if(String.valueOf(this.expresion.charAt(conjuntoPosicionesOperadores.get(1))).equals("/")==true   ){
                                                                            //guardo la operacion
                                                                            this.resultadoParcial=  Float.toString(opA / opB);
                                                                            //reemplazo en la expresion
                                                                            this.expresion=     this.expresion.replace(this.alOperandos.get(0)+"/"+this.alOperandos.get(1),       this.resultadoParcial);
                                                                            //reevaluo en caso de que this.expresion fuera mas extensa
                                                                            this.evaluarExpresion(this.expresion);
                                                                        }
                                                                        else{
                                                                            //si el siguiente operador es "*"
                                                                            if(String.valueOf(this.expresion.charAt(conjuntoPosicionesOperadores.get(1))).equals("*")==true   ){
                                                                                //guardo la operacion
                                                                                this.resultadoParcial=  Float.toString(opA * opB);
                                                                                //reemplazo en la expresion
                                                                                this.expresion=     this.expresion.replace(this.alOperandos.get(0)+"*"+this.alOperandos.get(1),       this.resultadoParcial);
                                                                                //reevaluo en caso de que this.expresion fuera mas extensa
                                                                                this.evaluarExpresion(this.expresion);
                                                                            }
                                                                            else{
                                                                                //si el siguiente operador es "%"
                                                                                if (String.valueOf(this.expresion.charAt(conjuntoPosicionesOperadores.get(1))).equals("%") == true   ) {
                                                                                    //guardo la operacion
                                                                                    this.resultadoParcial = Float.toString(opA % opB);
                                                                                    //reemplazo en la expresion
                                                                                    this.expresion = this.expresion.replace(this.alOperandos.get(0) + "%" + this.alOperandos.get(1), this.resultadoParcial);
                                                                                    //reevaluo en caso de que this.expresion fuera mas extensa
                                                                                    this.evaluarExpresion(this.expresion);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }else{
                                                                //3)    SI VIENE NRO SOLO
                                                                if(this.expresion.contains("(")==false      &&      this.expresion.contains(")")==false    &&      this.validarQueEsUnNumeroReal(this.expresion)==true  ){
                                                                    //le damos formato de 2 decimales
                                                                    float resultadoAux=     (float )Float.parseFloat(this.expresion);
                                                                    this.resultadoFinal=     this.expresion;
                                                                }
                                                            }
                                                        }
                                                    }catch(NumberFormatException ex){
                                                        this.resultadoFinal=    "Sintaxis incoherente!  [case('')]";
                                                    }
                                                    break;

                                    }//Cierra SWITCH               
                    }//Cierra IF PRINCIPAL
            
                    //******SI NO HAY QUE EVALUAR LA EXPRESION 
                    else{                       
                        //1)    SI LA EXPRESION ES VACIA
                        if(this.expresion.equals("")==true){
                            this.resultadoFinal=     "Debe ingresar algo!";
                        }
                        //2)    SI ESTA MAL LA SINTAXIS (Ej. OperadoresErroneos, etc.)                
                        else{
                            this.resultadoFinal=     "Expresion incoherente!";
                        }                        
                    }                    
                    
    return resultadoFinal; //Resultado definitivo
    //float a=Float.parseFloat("1+1");
    //return Float.toString(a); //da error poque "a" debe representar un nro directamente, no una operacion
}//CIERRA METODO EVALUAR EXPRESION  
    
    
//************************************
    
    //EVALUAR PARENTESIS BALANCEADOS
    private boolean verificarParentesisBalanceados(String expression) {//sin parentesis tmb es considerado 'balanceado'
        boolean checador=false;
        try{
            int cantParentesisAbiertos=0; 
            int cantParentesisCerrados=0; 
            //extraer ambos, recorriendo
            for(int i=0;    i<expression.length();   i++){
                if(String.valueOf(expression.charAt(i)).equals("(")==true   ){
                    cantParentesisAbiertos++;                
                }            
            }
            for(int i=0;    i<expression.length();   i++){
                if(String.valueOf(expression.charAt(i)).equals(")")==true   ){
                    cantParentesisCerrados++;                
                }
            }        
            //si hay la misma cantidad de '(' que de ')'
            if(cantParentesisAbiertos==cantParentesisCerrados){
                checador=true;            
            }
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "Error en el metodo 'evaluarParentesisBalanceados()'");
        }
        return checador;
    }
    
    //SIMPLIFICAR OPERADORES REPETIDOS
    public String simplificarOperadoresRepetidos(String expression){           
        try{
            //primero reemplazo casos como "--" o "+-" y "-+"
            expression=     this.reemplazarOperadoresEquivalentes(expression);
            //recorremos operadosRepetidos
            for(int i=0;    i<this.operadoresRepetidos.size();   i++){
                //si expression contiene el operadorRepetido actual
                if(expression.contains(this.operadoresRepetidos.get(i))==true   ){
                    //reemplazar: actualizar expression
                    expression=      expression.replace(    this.operadoresRepetidos.get(i),   String.valueOf(this.operadoresRepetidos.get(i).charAt(0) )   ); //reemplaza el operadorResultado repetido por el primer caracter del mismo                
                }
            }        
        }catch(Exception ex){
            //mensaje error
            JOptionPane.showMessageDialog(null, "Error en el metodo 'simplificarOperadoresRepetidos()'");        
        }
        return expression;
    }
    
    //EVALUAR OPERADORES ERRONEOS
    public boolean verificarOperadoresErroneos(String expression){        
        boolean checador=false;
        try{
            //recorrer expression
            for(int j=0;    j<this.expresionesErroneas.size();   j++){ //recorrer operadoresRepetidos               
                //si expresion contiene alguna expresion erronea
                if(expression.contains(this.expresionesErroneas.get(j))==true   ){
                    checador=true;
                    break;
                }
            }    
        }catch(Exception ex){
            //mensaje error
            JOptionPane.showMessageDialog(null, "Error en el metodo 'evaluarOperadoresErroneos()'");
        }
        return checador;
    }

    //CHECKEAR SI EXPRESION ES NRO. REAL
    public boolean validarQueEsUnNumeroReal(String expression){        
        boolean checador=false;
        try{
            //SI VIENE SIN PARENTESIS
            if(expression.contains("(")==false      &&      expression.contains(")")==false    ){
                float nro=    Float.parseFloat(expression);
                checador=true;
            }
            else{
                //SI VIENE CON PARENTESIS (balanceados)
                if(expression.contains("(")==true     &&      expression.contains(")")==true    ){
                    //Simplificar y actualizar
                    String expressionActualizada=     this.simplificarParentesis(expression); //simplificarParentesis es recursiva
                    //Verificar si es o no un nro                   
                    checador=      this.validarQueEsUnNumeroReal(expressionActualizada);                   
               }                
            }
        }catch(NumberFormatException ex){  
            //emitir error
            JOptionPane.showMessageDialog(null, "La expresion NO es un numero real, prosiguiendo... ");            
        }
        return checador;
    }
    
    //VALIDAR SI ENCUENTRA ALGUN ESPACIO EN BLANCO
    private boolean verificarEspaciosEnBlanco(String expression) {
        boolean checador=false;
        try{
            //si hay coincidencia
            if(expression.contains(" ")==true   ){
                checador=true;
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en el metodo 'evaluarEspaciosEnBlanco()'");
        }
        return checador;
    }
    
    //ANALIZA EL INTERIOR DE LOS PARENTESIS (SIMPLES) QUE VA ENCONTRANDO. EMPLEA RECURSIVIDAD
    public String simplificarParentesis(String expression){     //(expression ya viene balanceada)        
        
        String expressionActualizada=   expression; //  (1<=1)&&(2||2)
                       
        try{
            //Si viene con parentesis (balanceados)
            if(expression.contains("(")==true     &&     expression.contains(")")==true    &&    this.verificarParentesisBalanceados(expression)==true    ){
                
                //1)    guardar interior de los primeros parentesis
                String interiorParentesis=     expression.substring(expression.indexOf("(")+1 ,   expression.indexOf(")")   );
                
                //2)    evaluo lo que esta dentro este primer par
                String resultadoInteriorParentesis=     this.evaluarExpresion(interiorParentesis);

                //3)    Reemplazo en la expression 
                expressionActualizada=    expression.replace("("+interiorParentesis+")",     resultadoInteriorParentesis   );

                //4)    Actualizo expression con una llamada recursiva hasta simplificar todos los parentesis (simples) que tenga la expression
                expressionActualizada=      this.simplificarParentesis(expressionActualizada);            
            }            
        }catch(Exception ex){
            //mensaje error
           JOptionPane.showMessageDialog(null, "Error en el metodo 'simplificarParentesis()'");
        }
        //Devuelve la expresion "limpia" (default)
        return expressionActualizada;
    }
    
//BUSCAR OPERADOR POR PRIVILEGIO
public String extraerOperadorPorPrivilegio(String expression){
    String operadorResultado="";        
    //recorro operadores
    for(int i=0;    i<this.conjuntoOperadores.size();   i++){
        //si expression contiene algun operador (por prioridad) y no es un parentesis
        if(expression.contains(this.conjuntoOperadores.get(i) )==true   &&    this.conjuntoOperadores.get(i).equals("(")==false    &&     this.conjuntoOperadores.get(i).equals(")")==false   ){
            operadorResultado=    this.conjuntoOperadores.get(i);   
            break;
        }
    }
    return operadorResultado;
}

//CHECKEAR QUE EL ULTIMO CARACTER NO SEA UN OPERADOR
public boolean verificarUltimoCaracterOperador(String expression){
    boolean checador=false;
    for(int i=0;    i<this.conjuntoOperadores.size();   i++){
        //si el ultimo caracter es un operador
        if(String.valueOf(expression.charAt(expression.length()-1)).equals(this.conjuntoOperadores.get(i))==true    ){
            checador=true;
        }    
    }
    return checador;
}    

//VALIDAR OPERADORES REPETIDOS
private boolean verificarOperadoresRepetidos(String expression) {
    boolean checador=false;
    try{
        //recorro conjunto operadores repetidos
        for(int i=0;    i<this.operadoresRepetidos.size();   i++){
            //si expression contiene algun operador
            if(expression.contains(this.operadoresRepetidos.get(i) )==true  ){
                checador=true;
                break;
            }
        }     
    }catch(Exception ex){            
        JOptionPane.showMessageDialog(null, "Error en el metodo 'verificarOperadoresRepetidos()'");
    }
    return checador;
}

//VALIDAR 'OPERADOR' CAMBIO DE SIGNO
public boolean validarCambioSigno(String expression){
    boolean checador=  false;
    //Si contiene la cadena "+/-" es una operacion de cambio de signo
    if(expression.contains("+/-")==true    ){
        checador= true;
    }
    return checador;
}

//REALIZAR OPERACION CAMBIO SIGNO
public String realizarCambioSigno(String expression){
    //1) Si empieza con signo negativo
    if(String.valueOf(expression.charAt(0)).equals("-")==true   ){
        //remover el "+/-"
        expression=     expression.replace("+/-",   "");
        //suprimir el 1 caracter: "-"
        expression=     expression.replaceFirst("-",    "");        
    }    
    //2) Si empieza con signo "+" o sin signo
    else{
        if(String.valueOf(expression.charAt(0)).equals("+")==true      ){
            //remover el "+/-"
            expression=     expression.replace("+/-",   "");
            //cambiar el signo "+" por "-"
            expression=     expression.replace("+",    "-");            
        }
        //si empieza sin signo (o sea el primer caracter es un nro)
        else{
            if(this.validarQueEsUnNumeroReal(String.valueOf(expression.charAt(0) ) )==true    ){
                //remover el "+/-"
                expression=     expression.replace("+/-",   "");
                //agregar signo negativo
                expression=     "-" + expression;
            }
        }
    }
    return expression;
}

//VALIDAR QUE PRIMER OPERADOR SEA UN "+" o "-"    (al momento de llamar a esta funcion la expression ya viene sin parentesis)
public boolean validarPrimerOperadorEsSigno(String expression){
    boolean checador=false;
    for(int i=0;    i<this.conjuntoOperadores.size();   i++){
        if(String.valueOf(expression.charAt(0)).equals("+")== true      ||      String.valueOf(expression.charAt(0)).equals("-")== true     ){
            checador=true;
            break;
        }
    }
    return checador;
}      

//REEMPLAZAR "+NRO" POR [NRO] (MODULO)
public String reemplazarPorModulo(String expression){    
    //recorro expression
    for(int i=1;    i<this.expresion.length();   i++){
        //recorro conjuntoOperadores
        for(int j=0;    j<this.conjuntoOperadores.size();  j++){
            //Si encuentra un operador, modulo va "-" hasta este
            if(String.valueOf(this.expresion.charAt(i)) .equals(String.valueOf(this.conjuntoOperadores.get(j)))==true     ||      String.valueOf(this.expresion.charAt(i)).equals("&")==true     ||      String.valueOf(this.expresion.charAt(i)).equals("|")==true     ||      String.valueOf(this.expresion.charAt(i)).equals("&")==true    ){    //Si el caracter actual es igual a algun operador de conjuntoOperadores Ó si es iguala "&", "|" o "="
                //reemplazo desde char (0) hasta [proximo operador-1]
                expression=     expression.replace(expression.substring(0,   i),  expression.substring(1,  i)  );
                break;
            }
        }
    }  
    return expression;
}

//CHECAR SI EL PRIMER OPERADOR ES "-"
public boolean verificarPrimerOperadorEsNegativo(String expression){
    boolean checador=false;
    //Si el primer operador vale "-"
    if(String.valueOf(expression.charAt(0)).equals("-")==true    ){          
        checador=true;
    }
    return checador;
}

//EXTRAER OPERADOR POR PRIVILEGIO CASO QUE EXPRESION VENGA CON SIGNO NEGATIVO
    public String extraerOperadorPorPrivilegioCasoSignoNegativo(String expression) {
        String operadorResultado="";        
        //recorro expression (comienzo desde i=1)
        for(int i=1;    i<expression.length();   i++){
            //recorro operadores
            for(int j=0;    j<this.conjuntoOperadores.size();   j++){
                //si el char actual de expression coincide con algun operador (por prioridad) (no parentesis)                 
                if(String.valueOf(expression.charAt(i)).equals(this.conjuntoOperadores.get(j) )==true      ||     this.conjuntoOperadores.get(j).contains(String.valueOf(expression.charAt(i)))==true      ){
                    //guarda el operador que encontra
                    operadorResultado=    this.conjuntoOperadores.get(j);
                    break;
                }
            }
        }
    return operadorResultado;        
    }

//REEMPLAZAR OPERADORES EQUIVALENTES (EJ. "--" por "+" o "+-" o "-+" por "-")
public String reemplazarOperadoresEquivalentes(String expression){
    //si encuentra "--"
    if(expression.contains("--")==true  ){
        //reemplaza todos los "--" por "+"
        expression=     expression.replace("--",    "+");   
    }
    else{//si encuentra "+-"
        if(expression.contains("+-")==true  ){
                expression=     expression.replace("+-",    "-");  
        }
        else{
            if(expression.contains("-+")==true  ){
                //Si escuentra "-+"
                expression=     expression.replace("-+",    "-"); 
            }
        }
    }
    return expression;
}

//DEVUELVE LOS SIGUIENTES OPERADORES EN CASO DE QUE EXPRESSION COMIENCE CON SIGNO NEGATIVO [-]
public ArrayList<Integer> extraerSiguientesOperadores(String expression){    
    //Creo un AL que vaya guardando los caracteres de los operadores que va encontradndo
    ArrayList<Integer> alPosicionesOperadores=new ArrayList<>();
    int i= 0;
    alPosicionesOperadores.add(i); //el primer elemento es el signo "-" de la expresion
    //recorro expression desde [i=1].  Posicion [0] es el signo con el que viene
    for (i=1;   i<expression.length();  i++) {
        //si el char actual de expression coincide con algun operador (por prioridad) (no parentesis)                 
        if (String.valueOf(expression.charAt(i)).equals("+")==true  ){
            //guarda posicion operador "+"
            alPosicionesOperadores.add(i);            
        } 
        else {
            //caso encuentre "-"
            if (String.valueOf(expression.charAt(i)).equals("-")==true  ){
                //guarda posicion operador "-"
                alPosicionesOperadores.add(i);                
            }
            else{
                //caso encuentre "*"
                if (String.valueOf(expression.charAt(i)).equals("*")==true  ){
                    //guarda posicion operador "*"
                    alPosicionesOperadores.add(i);                    
                }
                else{
                    //caso encuentre "/"
                    if (String.valueOf(expression.charAt(i)).equals("/")==true  ){
                        //guarda posicion operador "/"
                        alPosicionesOperadores.add(i);                        
                    }
                    else{
                        //caso encuentre "%"
                        if (String.valueOf(expression.charAt(i)).equals("%")==true  ){
                            //guarda posicion operador "%"
                            alPosicionesOperadores.add(i);                        
                        }
                    }
                }
            }
        }
    }
    alPosicionesOperadores.add(expression.length() ); //agrega al final el tam de la cadena para luego usar "substring()"
    return alPosicionesOperadores;
}

//FUNCION CUENTA OPERADORES
public int cuentaOperadores(String expression){
    int cont=   0;
    //recorro conjuntoOperadores
    for(int j=0;    j<this.conjuntoOperadores.size();   j++){
        //si la expression contiene algun operador --> contador++
        if(expression.contains(this.conjuntoOperadores.get(j) )==true    ) {
            cont++;
        }
    }    
    return cont;
}

    private boolean verificarExpresionesErroneas(String expression) {
        boolean verificador = false;
        //recorro expresion en busca de expresiones erroneas
        for(String exp : this.expresionesErroneas){
            if(expression.contains(exp)){
                verificador = true;
            }
        }
        return verificador;
    }
     
 
 
}//FIN CLASE     
  
//1)    Si se produce un error de calculo/sintaxis emitir un mensaje error con Manejo-Excepciones    
//2)    Si se ingresa una expresión con errores de sintaxis se emitirá un mensaje de error en
//3)    El visor 2 con manejo de excepciones.
//4)    Si se ingresara más de 1 operadorResultado seguido, por ejemplo **, la calculadora toma
//...solamente un operadorResultado.    
