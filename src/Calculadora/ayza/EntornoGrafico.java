/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora.ayza;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author beto
 */
public class EntornoGrafico extends JFrame implements ActionListener{
    //Declaro componentes
    private JFrame jf;
    private JTextField jtfIngreso, jtfResultado;
    private JLabel labelExpr, labelIgual;
    private JButton jbMC, jbMR, jbMS, jbAND, jbOR, jbNOT, jbDistinto, jbMayorOIgual, jbMenorOIgual, jbIgual, jbMayor, jbMenor, jbCero, jbUno, jbDos, jbTres, jbCuatro, jbCinco, jbSeis, jbSiete, jbOcho, jbNueve, jbAbroParentesis, jbCierroParentesis, jbLimpiar, jbResultado, jbSuma, jbResta, jbMultiplicacion, jbDivision, jbMOD, jbCambioDeSigno;
    //debo crear 3 paneles: el principal, en el que van los JTFs y el de los botones (el Grid) 
    private JPanel jPanelPrincipal, jPanelJTFs, jPanelBotones;
    private String memoria;
    public EntornoGrafico() {
        //inicializo memoria
        this.memoria="";
        //instancio y configuro los paneles
        this.jPanelPrincipal=new JPanel(new GridLayout(2,1)); 
        this.jPanelJTFs=new JPanel(new GridLayout(2,2));
        this.jPanelBotones=new JPanel(new GridLayout(4,8));              
        //Inicializo labels
        this.labelExpr=new JLabel("Expr: ");
        this.labelIgual=new JLabel("=");
        //Inicializo botones y agrego los listeners
        this.jbCero=new JButton("0"); this.jbCero.addActionListener(this);
        this.jbUno=new JButton("1"); this.jbUno.addActionListener(this);
        this.jbDos=new JButton("2"); this.jbDos.addActionListener(this);
        this.jbTres=new JButton("3"); this.jbTres.addActionListener(this); 
        this.jbCuatro=new JButton("4"); this.jbCuatro.addActionListener(this);
        this.jbCinco=new JButton("5"); this.jbCinco.addActionListener(this);
        this.jbSeis=new JButton("6"); this.jbSeis.addActionListener(this);
        this.jbSiete=new JButton("7"); this.jbSiete.addActionListener(this);
        this.jbOcho=new JButton("8"); this.jbOcho.addActionListener(this);
        this.jbNueve=new JButton("9"); this.jbNueve.addActionListener(this);
        this.jbMC=new JButton("MC"); this.jbMC.setBackground(Color.BLACK); this.jbMC.setForeground(Color.WHITE); this.jbMC.addActionListener(this);
        this.jbMR=new JButton("MR"); this.jbMR.setBackground(Color.BLACK); this.jbMR.setForeground(Color.WHITE); this.jbMR.addActionListener(this);
        this.jbMS=new JButton("MS"); this.jbMS.setBackground(Color.BLACK); this.jbMS.setForeground(Color.WHITE); this.jbMS.addActionListener(this);
        this.jbAND=new JButton("AND"); this.jbAND.addActionListener(this);
        this.jbOR=new JButton("OR"); this.jbOR.addActionListener(this);
        this.jbNOT=new JButton("NOT"); this.jbNOT.addActionListener(this);
        this.jbMOD=new JButton("MOD"); this.jbMOD.addActionListener(this);
        this.jbCambioDeSigno=new JButton("+/-"); this.jbCambioDeSigno.addActionListener(this);
        this.jbMultiplicacion=new JButton("*"); this.jbMultiplicacion.addActionListener(this);
        this.jbDivision=new JButton("/"); this.jbDivision.addActionListener(this);
        this.jbSuma=new JButton("+"); this.jbSuma.addActionListener(this);
        this.jbResta=new JButton("-"); this.jbResta.addActionListener(this);
        this.jbAbroParentesis=new JButton("("); this.jbAbroParentesis.setBackground(Color.GRAY); this.jbAbroParentesis.setForeground(Color.WHITE); this.jbAbroParentesis.addActionListener(this);
        this.jbCierroParentesis=new JButton(")"); this.jbCierroParentesis.setBackground(Color.GRAY); this.jbCierroParentesis.setForeground(Color.WHITE); this.jbCierroParentesis.addActionListener(this);
        this.jbLimpiar=new JButton("C"); this.jbLimpiar.setBackground(Color.RED); this.jbLimpiar.addActionListener(this);
        this.jbResultado=new JButton("="); this.jbResultado.setBackground(Color.GREEN); this.jbResultado.addActionListener(this);//falta darle un color al borde
        this.jbDistinto=new JButton("!="); this.jbDistinto.addActionListener(this);
        this.jbMayorOIgual=new JButton(">="); this.jbMayorOIgual.addActionListener(this);
        this.jbMenorOIgual=new JButton("<="); this.jbMenorOIgual.addActionListener(this);
        this.jbIgual=new JButton("=="); this.jbIgual.addActionListener(this);
        this.jbMayor=new JButton(">"); this.jbMayor.addActionListener(this);
        this.jbMenor=new JButton("<"); this.jbMenor.addActionListener(this);
               
        //Inicializo los JTF
        this.jtfIngreso=new JTextField();
        this.jtfResultado=new JTextField("0");
        
        //agrego a los sub-paneles los componentes
        this.jPanelJTFs.add(labelExpr);
        this.jPanelJTFs.add(jtfIngreso);
        this.jPanelJTFs.add(jbIgual);
        this.jPanelJTFs.add(jtfResultado);
        
        this.jPanelBotones.add(jbMC);
        this.jPanelBotones.add(jbMR);
        this.jPanelBotones.add(jbMS);
        this.jPanelBotones.add(jbSiete);
        this.jPanelBotones.add(jbOcho);
        this.jPanelBotones.add(jbNueve);
        this.jPanelBotones.add(jbMOD);
        this.jPanelBotones.add(jbCambioDeSigno);
        
        this.jPanelBotones.add(jbAND);
        this.jPanelBotones.add(jbOR);
        this.jPanelBotones.add(jbNOT);
        this.jPanelBotones.add(jbCuatro);
        this.jPanelBotones.add(jbCinco);
        this.jPanelBotones.add(jbSeis);        
        this.jPanelBotones.add(jbMultiplicacion);
        this.jPanelBotones.add(jbDivision);
        
        this.jPanelBotones.add(jbDistinto);
        this.jPanelBotones.add(jbMayorOIgual);
        this.jPanelBotones.add(jbMenorOIgual);
        this.jPanelBotones.add(jbUno);
        this.jPanelBotones.add(jbDos);
        this.jPanelBotones.add(jbTres);
        this.jPanelBotones.add(jbSuma);
        this.jPanelBotones.add(jbResta);
        
        this.jPanelBotones.add(jbIgual);
        this.jPanelBotones.add(jbMayor);
        this.jPanelBotones.add(jbMenor);
        this.jPanelBotones.add(jbAbroParentesis);
        this.jPanelBotones.add(jbCero);
        this.jPanelBotones.add(jbCierroParentesis);
        this.jPanelBotones.add(jbLimpiar);
        this.jPanelBotones.add(jbResultado); 
        
        //agrego los sub-paneles al panel principal
        this.jPanelPrincipal.add(jPanelJTFs);
        this.jPanelPrincipal.add(jPanelBotones);
        //instancio y configuro el JFrame
        this.jf=new JFrame("Calculadora Pirulo");
        this.jf.add(jPanelPrincipal);       
        this.jf.setLocationRelativeTo(null);
        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.pack(); 
        this.jf.setSize(600,250);
        //this.jf.setMaximumSize(new Dimension(700,900));
        this.jf.setVisible(true);
    }
    //ACCIONES AL USAR LOS COMPONENETES
    //Accion dependiendo del evento entrante
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Los botones en gral lo unico que hacer es agregar el string pertinente
        //Unicamente el boton "=" solicito la operacion aritmetica infija        
        //si se aprieta el boton 0
        if(ae.getSource()==jbCero){
            //agregar 0 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"0");
        }
        //si se aprieta el boton 1
        if(ae.getSource()==jbUno){
            //agregar 1 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"1");
        }
        //si se aprieta el boton 2
        if(ae.getSource()==jbDos){
            //agregar 2 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"2");
        }
        //si se aprieta el boton 3
        if(ae.getSource()==jbTres){
            //agregar 3 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"3");
        }
        //si se aprieta el boton 4
        if(ae.getSource()==jbCuatro){
            //agregar 4 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"4");
        }
        //si se aprieta el boton 5
        if(ae.getSource()==jbCinco){
            //agregar 5 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"5");
        }
        //si se aprieta el boton 6
        if(ae.getSource()==jbSeis){
            //agregar 6 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"6");
        }
        //si se aprieta el boton 7
        if(ae.getSource()==jbSiete){
            //agregar 7 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"7");
        }
        //si se aprieta el boton 8
        if(ae.getSource()==jbOcho){
            //agregar 8 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"8");
        }
        //si se aprieta el boton 9
        if(ae.getSource()==jbNueve){
            //agregar 9 a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"9");
        }
        //si se aprieta el boton "Abrir Parentesis"
        if(ae.getSource()==jbAbroParentesis){
            //agregar ( a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"(");
        }
        //si se aprieta el boton "Cerrar Parentesis"
        if(ae.getSource()==jbCierroParentesis){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+")");
        }
        //si se aprieta el boton "AND"
        if(ae.getSource()==jbAND){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"&&");
        }
        //si se aprieta el boton "OR"
        if(ae.getSource()==jbOR){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"||");
        }
        //si se aprieta el boton "NOT"
        if(ae.getSource()==jbNOT){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"!");
        }
        //si se aprieta el boton ">="
        if(ae.getSource()==jbMayorOIgual){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+">=");
        }
        //si se aprieta el boton "<="
        if(ae.getSource()==jbMenorOIgual){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"<=");
        }
        //si se aprieta el boton "=="
        if(ae.getSource()==jbIgual){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"="+"=");
        }
        //si se aprieta el boton "<"
        if(ae.getSource()==jbMenor){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+"<");
        }
        //si se aprieta el boton ">"
        if(ae.getSource()==jbMayor){
            //agregar ) a la derecha
            jtfIngreso.setText(jtfIngreso.getText()+">");
        }
        //si se aprieta el boton "MC"
        if(ae.getSource()==jbMC){
            //limpiar variable "variable memoria almacenada"
            this.memoria="";
            jtfResultado.setText("Memory cleaned!");
        }
        //si se aprieta el boton "MR"
        if(ae.getSource()==jbMR){
            //se recupera la memoria y permenece como esta
            jtfResultado.setText(this.memoria);
        }
        //si se aprieta el boton "MS"
        if(ae.getSource()==jbMS){
            //se almacena lo que hay en jtfResultado
            this.memoria=jtfResultado.getText();
        }
        //si se aprieta el boton "C"
        if(ae.getSource()==jbLimpiar){
            //se ponen en vacíos los JTFs
            jtfIngreso.setText("");
            jtfResultado.setText("");
        }        
        //si se aprieta el boton "MOD"        
        if(ae.getSource()==jbMOD){
            //agregar "%" a la expresion actual
            jtfIngreso.setText(jtfIngreso.getText()+"%");                        
        }    
        //si se aprieta el boton "!="
        if(ae.getSource()==jbDistinto){
            jtfIngreso.setText(jtfIngreso.getText()+"!=");
        }
        //si se aprieta el boton "/"
        if(ae.getSource()==jbDivision){
            jtfIngreso.setText(jtfIngreso.getText()+"/");
        }
        //si se aprieta el boton "*"
        if(ae.getSource()==jbMultiplicacion){
            jtfIngreso.setText(jtfIngreso.getText()+"*");
        }
        //si se aprieta el boton "+"
        if(ae.getSource()==jbSuma){
            jtfIngreso.setText(jtfIngreso.getText()+"+");
        }
        //si se aprieta el boton "-"
        if(ae.getSource()==jbResta){
            jtfIngreso.setText(jtfIngreso.getText()+"-");
        }
        
        //******SOLICITUD DE OPERACION ARITMETICA***********  
        //Siempre cuando se presiona "=" o "+/-"
        ExpresionAritmeticaInfija expresionAritmInf = new ExpresionAritmeticaInfija();
        //si se aprieta el boton igual
        if(ae.getSource()==jbResultado){            
            //evaluar expresion
            jtfResultado.setText(expresionAritmInf.evaluarExpresion(jtfIngreso.getText()));                    
        }
        //si se aprieta el boton "+/-"
        //si viene en negativo
        if(ae.getSource()==jbCambioDeSigno){
            //agregar "+/-" a la expresion actual
            jtfIngreso.setText(jtfIngreso.getText()+"+/-");                        
        }
    }   

            

    
    
    
    
}
