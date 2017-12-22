
import java.util.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Trial extends Frame  implements Runnable,ActionListener,MouseListener{
    TreeMap<Integer,Integer> tmap=new TreeMap<Integer,Integer>();
    ArrayList<Integer> a500 =new ArrayList<Integer>();
    ArrayList<Integer> a550 =new ArrayList<Integer>();
    ArrayList<Integer> a600 =new ArrayList<Integer>();
    ArrayList<Integer> a650 =new ArrayList<Integer>();
    ArrayList<Integer> bullet=new ArrayList<Integer>();
    
    static int score;
    ImageIcon a,b,c,d1;
    static Boolean flag=true,flag5=false;//set to false once game is over
    public boolean flag1=false,flag2=false,flag3=false,flag4=false,flag11=false,flag22=false,flag33=false,flag44=false;
    
    static int i,top;
    int miss=0;
    static TextField l;
    static int random()
    {
        
        Random tem=new Random();
        return(tem.nextInt(4));
    }
    
    public void run()
    {String s;
        if(Thread.currentThread().getName()=="generation"){
            
            for(int k=0;k<100;k++)//while(!gameover)
            {try{
                if(score<10)
                    Thread.sleep(5000);
                else
                {if(score<50)
                    Thread.sleep(2000);
                else
                    Thread.sleep(1000);
                }
            }
                catch(InterruptedException e)
                {}
                int k1=Trial.random();
                switch(k1)
                {
                    case 0:a500.add(0);
                        break;
                    case 1:a550.add(0);
                        break;
                        
                        
                    case 2:a600.add(0);
                        break;
                    case 3:a650.add(0);
                        break;
                        
                }
                
                //tmap.put(k1*50+500,10);
            }
        }
        if(Thread.currentThread().getName()=="painting"){
            while(flag){
                System.out.println("hello");
                repaint();
            }
        }
        
    }
    public void mouseClicked(MouseEvent me){
        
        bullet.add(100);
        
        for(int w=0;w<a500.size();w++){
            if(400<=a500.get(w)&&a500.get(w)<=440){flag1=true;flag11=true;a500.set(w,a500.get(w)+1);}
            
        }
        for(int w=0;w<a550.size();w++){
            if(390<=a550.get(w)&&a550.get(w)<=430){flag2=true;flag22=true;a550.set(w,a550.get(w)+1);}
            
            
        }
        for(int w=0;w<a600.size();w++){
            if(380<=a600.get(w)&&a600.get(w)<=420){flag3=true;flag33=true;a600.set(w,a600.get(w)+1);}
        }
        for(int w=0;w<a650.size();w++){
            if(370<=a650.get(w)&&a650.get(w)<=410){flag4=true;flag44=true;a650.set(w,a650.get(w)+1);}
            
        }
       if(flag1||flag2||flag3||flag4)
            score++;
        else miss++;
       // Integer rea=score;
        
       // l.setText(rea.toString(score));
        flag1=false;flag2=false;flag3=false;flag4=false;
        if(miss==5)flag=false;
        
        
        
        
        
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    
    
    public void paint(Graphics g){
        System.out.println("debug");
        //g.drawLine(100,500,350,500);
        
        {
            g.drawImage(b.getImage(),10,489, this);
            for(int ij=0;ij<a500.size();ij++){
                if(a500.get(ij)>700)a500.remove(ij);
                else{
                if(((a500.get(ij)%10)!=0)&&(a500.get(ij)>500)){//score++;
                    if(flag11)
                    { Integer rea=score;
                            l.setText(rea.toString(score));}
                        g.drawImage(c.getImage(),500,a500.get(ij),this);flag11=false;}
                else g.drawImage(a.getImage(),500,a500.get(ij),this);
                a500.set(ij,a500.get(ij)+10);
                    }}
            for(int ij=0;ij<a550.size();ij++){
                if(a550.get(ij)>700)a550.remove(ij);
                else{
                if(((a550.get(ij)%10)!=0)&&(a550.get(ij)>500)){
                    if(flag22){Integer rea=score;
                    
                        l.setText(rea.toString(score));}
                    g.drawImage(c.getImage(),550,a550.get(ij),this);flag22=false;}
                else g.drawImage(a.getImage(),550,a550.get(ij),this);
                    a550.set(ij,a550.get(ij)+10);}
            }
            for(int ij=0;ij<a600.size();ij++){
                if(a600.get(ij)>700)a600.remove(ij);
                else{
                if(((a600.get(ij)%10)!=0)&&(a600.get(ij)>500)){
                    if(flag33 ){Integer rea=score;
                    
                        l.setText(rea.toString(score));}
                    g.drawImage(c.getImage(),600,a600.get(ij),this);flag33=false;}
                else
                    g.drawImage(a.getImage(),600,a600.get(ij),this);
                    a600.set(ij,a600.get(ij)+10);}
            }
            for(int ij=0;ij<a650.size();ij++){
                if(a650.get(ij)>700)a650.remove(ij);
                else{
                if(((a650.get(ij)%10)!=0)&&(a650.get(ij)>500)){
                    if(flag44){Integer rea=score;
                    
                        l.setText(rea.toString(score));}
                    g.drawImage(c.getImage(),650,a650.get(ij),this);flag44=false;}
                else
                    g.drawImage(a.getImage(),650,a650.get(ij),this);
                    a650.set(ij,a650.get(ij)+10);}
            }
            for(int d=0;d<bullet.size();d++){
                g.drawImage(d1.getImage(),bullet.get(d),500,this);bullet.set(d,bullet.get(d)+50);
            }
            
            try{Thread.sleep(100);}catch(Exception e){}
        }
        
        
        
        
        
        
        
        if(flag5){
            System.out.println("hi");
            g.drawLine(100,500,1000,500);
            try{ Thread.sleep(1000);
                
            }catch(InterruptedException e)
            {}
        }}

    Trial()
    {        b=new ImageIcon("shoot.png");
        a=new ImageIcon("scroll.png");
        c=new ImageIcon("die.png");
        d1=new ImageIcon("bullet.png");
        
        l=new TextField("0");l.setBounds(100,600,50,20);
        l.setEditable(false);
        add(l);
        addMouseListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {System.exit (0);
            }
        });
        //    setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent a)
    {
        
        String st=a.getActionCommand();
        if(st=="Shoot")
        {
            flag5=true;
            // drawLine(100,500,1000,500);
            // draw
            
            for(int w=0;w<a500.size();w++){
                if(480<=a500.get(w)&&a500.get(w)<=520)flag1=true;
                
            }
            for(int w=0;w<a550.size();w++){
                if(480<=a550.get(w)&&a550.get(w)<=520)flag2=true;
                
                
            }
            for(int w=0;w<a600.size();w++){
                if(480<=a600.get(w)&&a600.get(w)<=520)flag3=true;
            }
            for(int w=0;w<a650.size();w++){
                if(480<=a650.get(w)&&a650.get(w)<=520)flag4=true;
                
            }
            if(flag1||flag2||flag3||flag4)
                score++;
            else miss++;
            Integer rea=score;
            
            l.setText(rea.toString(score));
            flag1=false;flag2=false;flag3=false;flag4=false;
            if(miss==5)flag=false;
            
        }
        flag5=false;
    }
    public static void main(String a[])
    {//Runnable r=new Runnable();
        
        Trial t=new Trial();
        /*try{Thread.sleep(2000);}
         catch(InterruptedException e)
         {System.out.println("after sleep");}*/
        Thread mythread =new Thread(t,"generation");
        Thread pain=new Thread(t,"painting");
        
        mythread.start();
        pain.start();
        t.setTitle("Game");
        t.setLayout(null);
        t.setVisible(true);
        t.setSize(1000,1000);
        
        //t.setBackground(Color.blue);
        //try
        {while(flag)
        { i=random();
            //	Thread.sleep(100);
            //System.out.println(i);
            
            //Thread.sleep();
        }
        }//catch(InterruptedException e)
        {
            System.out.println("interrupted exception");
        }
        
    }
    
}
