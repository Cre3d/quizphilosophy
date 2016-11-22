package filquiz;


//Import

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


class Quiz extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
			JPanel panel;
         JPanel panelresult;
         JRadioButton choice1;
         JRadioButton choice2;
         JRadioButton choice3;
         JRadioButton choice4;
         ButtonGroup bg;
         JLabel lblmess;
         JButton btnext;
         String[][] qpa;
         String[][] qca;
         int qaid;
         HashMap<Integer, String> map;

         Quiz(){
                   initializedata();
                   setTitle("Quiz filozoficzny");
                   setDefaultCloseOperation(EXIT_ON_CLOSE);
                   setSize(430,350);
                   setLocation(300,100);
                  setResizable(false);
                  Container cont=getContentPane();
                   cont.setLayout(null);           
                   cont.setBackground(Color.GRAY);
                 bg=new ButtonGroup();      
                 choice1=new JRadioButton("Choice1",true);
                 choice2=new JRadioButton("Choice2",false);
                 choice3=new JRadioButton("Choice3",false);
                 choice4=new JRadioButton("Choice4",false);
                 bg.add(choice1);
                 bg.add(choice2);
                 bg.add(choice3);
                 bg.add(choice4);
                 lblmess=new JLabel("Wybierz poprawną odpowiedź!");
                 lblmess.setForeground(Color.BLUE);
                 lblmess.setFont(new Font("Arial", Font.BOLD, 11));
                 btnext=new JButton("Następne pytanie!");
                 btnext.setForeground(Color.GREEN);                 
                 btnext.addActionListener(this);
                 panel=new JPanel();
                 panel.setBackground(Color.LIGHT_GRAY);
                panel.setLocation(10,10);
                 panel.setSize(400,300);
                 panel.setLayout(new GridLayout(6,2));
                 panel.add(lblmess);
                 panel.add(choice1);
                 panel.add(choice2);
                 panel.add(choice3);
                 panel.add(choice4);
                panel.add(btnext);
               cont.add(panel);
               setVisible(true);
                 qaid=0;
                 readqa(qaid);
         
         }
         
     public void actionPerformed(ActionEvent e){
         
                     if(btnext.getText().equals("Następne pytanie!")){
                                 if(qaid<20){
                                             
                                             map.put(qaid,getSelection());
                                             qaid++;
                                             readqa(qaid);
                                             }
                                 else {
                                             map.put(qaid,getSelection());
                                             btnext.setText("Wyświetl odpowiedzi!");
                                             
                                          }
                                 }
                     else if(btnext.getText().equals("Wyświetl odpowiedzi!"))
                                 new Report();
                     
                     
         }
         

         
     public void initializedata(){
                     //Tabela QPA przechowuje pytanie i możliwe odpowiedzi
                     qpa=new String[21][5];

                     qpa[0][0]="Pytanie";
                     qpa[0][1]="Odpowiedz 0";
                     qpa[0][2]="Odpowiedz 1";
                     qpa[0][3]="Odpowiedz 2";
                     qpa[0][4]="Odpowiedz 3";

                     qpa[1][0]="What is the use of the println method?";
                     qpa[1][1]="It is used to print text on the screen.";
                     qpa[1][2]="It is used to print text on the screen with the line break.";
                     qpa[1][3]="It is used to read text from keyboard.";
                     qpa[1][4]="It is used to read text from a file.";
                     
                     qpa[2][0]="How to read a character from the keyboard?";
                     qpa[2][1]="char c=System.read()";
                     qpa[2][2]="char c=System.in.read()";
                     qpa[2][3]="char c=(char)System.read()";
                     qpa[2][4]="char c=(char)System.in.read()";

                     qpa[3][0]="Which one is a single-line comment?";
                     qpa[3][1]="/...";
                     qpa[3][2]="//...";
                     qpa[3][3]="/*...";
                     qpa[3][4]="/*...*/";

                     qpa[4][0]="How do you declare an integer variable x?";
                     qpa[4][1]="int x";
                     qpa[4][2]="x as Integer";
                     qpa[4][3]="Int[] x";
                     qpa[4][4]="No one is correct.";

                     qpa[5][0]="How do you convert a string of number to a number?";
                     qpa[5][1]="int num=Integer.parseInt(str_num)";
                     qpa[5][2]="int num=str_num.toInteger()";
                     qpa[5][3]="int num=(int)str_num";
                     qpa[5][4]="int num=(Integer)str_num";

                     qpa[6][0]="What is the value of x? int x=3>>2";
                     qpa[6][1]="1";
                     qpa[6][2]="0";
                     qpa[6][3]="3";
                     qpa[6][4]="-3";

                     qpa[7][0]="How to do exit a loop?";
                     qpa[7][1]="Using exit";
                     qpa[7][2]="Using break";
                     qpa[7][3]="Using continue";
                     qpa[7][4]="Using terminate";

                     qpa[8][0]="What is the correct way to allocate one-dimensional array?";
                     qpa[8][1]="int[size] arr=new int[]";
                     qpa[8][2]="int arr[size]=new int[]";
                     qpa[8][3]="int[size] arr=new int[size]";
                     qpa[8][4]="int[] arr=new int[size]";

                     qpa[9][0]="What is the correct way to allocate two-dimensional array?";
                     qpa[9][1]="int[size][] arr=new int[][]";
                     qpa[9][2]="int arr=new int[rows][cols]";
                     qpa[9][3]="int arr[rows][]=new int[rows][cols]";
                     qpa[9][4]="int[][] arr=new int[rows][cols]";
                     
                     qpa[10][0]="How to run Java program on the command prompt?";
                     qpa[10][1]="javac JavaProgram";
                     qpa[10][2]="java JavaProgram";
                     qpa[10][3]="javac JavaProgram.java";
                     qpa[10][4]="No one";
                     
                     qpa[11][0]="How to run Java program on the command prompt?";
                     qpa[11][1]="javac JavaProgram";
                     qpa[11][2]="java JavaProgram";
                     qpa[11][3]="javac JavaProgram.java";
                     qpa[11][4]="No one";

                     qpa[12][0]="What is the use of the println method?";
                     qpa[12][1]="It is used to print text on the screen.";
                     qpa[12][2]="It is used to print text on the screen with the line break.";
                     qpa[12][3]="It is used to read text from keyboard.";
                     qpa[12][4]="It is used to read text from a file.";
                     
                     qpa[13][0]="How to read a character from the keyboard?";
                     qpa[13][1]="char c=System.read()";
                     qpa[13][2]="char c=System.in.read()";
                     qpa[13][3]="char c=(char)System.read()";
                     qpa[13][4]="char c=(char)System.in.read()";

                     qpa[14][0]="Which one is a single-line comment?";
                     qpa[14][1]="/...";
                     qpa[14][2]="//...";
                     qpa[14][3]="/*...";
                     qpa[14][4]="/*...*/";

                     qpa[15][0]="How do you declare an integer variable x?";
                     qpa[15][1]="int x";
                     qpa[15][2]="x as Integer";
                     qpa[15][3]="Int[] x";
                     qpa[15][4]="No one is correct.";

                     qpa[16][0]="How do you convert a string of number to a number?";
                     qpa[16][1]="int num=Integer.parseInt(str_num)";
                     qpa[16][2]="int num=str_num.toInteger()";
                     qpa[16][3]="int num=(int)str_num";
                     qpa[16][4]="int num=(Integer)str_num";

                     qpa[17][0]="What is the value of x? int x=3>>2";
                     qpa[17][1]="1";
                     qpa[17][2]="0";
                     qpa[17][3]="3";
                     qpa[17][4]="-3";

                     qpa[18][0]="How to do exit a loop?";
                     qpa[18][1]="Using exit";
                     qpa[18][2]="Using break";
                     qpa[18][3]="Using continue";
                     qpa[18][4]="Using terminate";

                     qpa[19][0]="What is the correct way to allocate one-dimensional array?";
                     qpa[19][1]="int[size] arr=new int[]";
                     qpa[19][2]="int arr[size]=new int[]";
                     qpa[19][3]="int[size] arr=new int[size]";
                     qpa[19][4]="int[] arr=new int[size]";

                     qpa[20][0]="What is the correct way to allocate two-dimensional array?";
                     qpa[20][1]="int[size][] arr=new int[][]";
                     qpa[20][2]="int arr=new int[rows][cols]";
                     qpa[20][3]="int arr[rows][]=new int[rows][cols]";
                     qpa[20][4]="int[][] arr=new int[rows][cols]";

                     
                     //Tabela QCA przechowuje pytanie i POPRAWNĄ odpowiedz
                     //Odpowiedz poprawna musi byc dokladnie taka sama jak z QPA!!
                     qca=new String[21][2];
                     
                     qca[0][0]="Pytanie";
                     qca[0][1]="Odpowiedz Poprawna";

                     qca[1][0]="What is the use of the println method?";
                     qca[1][1]="It is used to print text on the screen with the line break.";

                     qca[2][0]="How to read a character from the keyboard?";
                     qca[2][1]="char c=(char)System.in.read()";

                     qca[3][0]="Which one is a single-line comment?";
                     qca[3][1]="//...";


                     qca[4][0]="How do you declare an integer variable x?";
                     qca[4][1]="int x";

                     qca[5][0]="How do you convert a string of number to a number?";
                     qca[5][1]="int num=Integer.parseInt(str_num)";

                     qca[6][0]="What is the value of x? int x=3>>2";
                     qca[6][1]="0";
                     
                     qca[7][0]="How to do exit a loop?";
                     qca[7][1]="Using break";
                     
                     qca[8][0]="What is the correct way to allocate one-dimensional array?";
                     qca[8][1]="int[] arr=new int[size]";

                     qca[9][0]="What is the correct way to allocate two-dimensional array?";
                     qca[9][1]="int[][] arr=new int[rows][cols]";
                     
                     qca[10][0]="How to run Java program on the command prompt?";
                     qca[10][1]="javac JavaProgram";
                     
                     qca[11][0]="How to run Java program on the command prompt?";
                     qca[11][1]="No one";

                     qca[12][0]="What is the use of the println method?";
                     qca[12][1]="It is used to print text on the screen with the line break.";

                     qca[13][0]="How to read a character from the keyboard?";
                     qca[13][1]="char c=(char)System.in.read()";

                     qca[14][0]="Which one is a single-line comment?";
                     qca[14][1]="//...";


                     qca[15][0]="How do you declare an integer variable x?";
                     qca[15][1]="int x";

                     qca[16][0]="How do you convert a string of number to a number?";
                     qca[16][1]="int num=Integer.parseInt(str_num)";

                     qca[17][0]="What is the value of x? int x=3>>2";
                     qca[17][1]="0";
                     
                     qca[18][0]="How to do exit a loop?";
                     qca[18][1]="Using break";
                     
                     qca[19][0]="What is the correct way to allocate one-dimensional array?";
                     qca[19][1]="int[] arr=new int[size]";

                     qca[20][0]="What is the correct way to allocate two-dimensional array?";
                     qca[20][1]="int[][] arr=new int[rows][cols]";
                     
                     
                     
                     //Tworzy mape odpowiedzi
                     map=new HashMap<Integer, String>();
                     
                     }
     public String getSelection(){
                     String selectedChoice=null;
                     Enumeration<AbstractButton> buttons=bg.getElements();  
                     while(buttons.hasMoreElements())  
                     {  
                     JRadioButton temp=(JRadioButton)buttons.nextElement(); 
                     if(temp.isSelected())  
                                 {  
                                             selectedChoice=temp.getText();
                                 }  
                      }   
                     return(selectedChoice);
         }


     public void readqa(int qid){
                     lblmess.setText("  "+qpa[qid][0]);
                     choice1.setText(qpa[qid][1]);
                     choice2.setText(qpa[qid][2]);
                     choice3.setText(qpa[qid][3]);
                     choice4.setText(qpa[qid][4]);
                     choice1.setSelected(true); 
         }
    public void reset(){
                     qaid=0;
                     map.clear();
                     readqa(qaid);
                     btnext.setText("Następne");
                     }
     public int calCorrectAnswer(){
                     int qnum=21;
                     int count=0;
                     for(int qid=0;qid<qnum;qid++)
                                 if(qca[qid][1].equals(map.get(qid))) count++;
                     return count;
         }

     public class Report extends JFrame{
                     Report(){
                                 setTitle("Quiz Filozoficzny - Odpowiedzi!");
                                 setSize(1500,750);
                                 setBackground(Color.WHITE);
                                 addWindowListener(new WindowAdapter(){
                                                         public void windowClosing(WindowEvent e){
                                                                     dispose();
                                                                     reset();
                                                         }
                                             });
                                 Draw d=new Draw();                                   
                                 add(d);
                                 setVisible(true);
                                 }
                     
                     
                 class Draw extends Canvas{
                                 public void paint(Graphics g){
                                             int qnum=21;
                                             int x=10;
                                             int y=20;
                                             for(int i=0;i<qnum;i++){
                                                         //Pierwsza kolumna
                                                         g.setFont(new Font("Arial",Font.BOLD,12));                                          
                                                         g.drawString(i+1+". "+qca[i][0], x,y);
                                                         y+=30;            
                                                         g.setFont(new Font("Arial",Font.PLAIN,12));                              
                                                         g.drawString("      Poprawna odpowiedź:"+qca[i][1], x,y);
                                                         y+=30;
                                                         g.drawString("      Twoja odpowiedź:"+map.get(i), x,y);
                                                         y+=30;
                                                         //Druga kolumna
                                                         if(y>600 && x==10)
                                                         {y=30;
                                                           x=500;
                                                         }
                                                         //Trzecia kolumna
                                                         if(y>600 && x==500)
                                                         {y=30;
                                                         x=950;
                                                       }
                                                         
                                                        
                                                         
                                             }
                                             //Wyświetl poprawną ilość odpowiedzi
                                             int numc=calCorrectAnswer();
                                             g.setColor(Color.BLUE);
                                             g.setFont(new Font("Arial",Font.BOLD,14));
                                             g.drawString("Twoja liczba poprawnych odpowiedzi:"+numc,550,700);
                     
                                             
                                 }
                     }
                                 
         }
         

         

}


public class filquiz{

         public static void main(String args[]){
                      new Quiz();

         }
}


