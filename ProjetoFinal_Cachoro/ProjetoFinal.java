package ProjetoFinal_Cachoro;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

public class ProjetoFinal
        implements GLEventListener, 
        KeyListener{

    GLU glu = new GLU();
    GLUT glut = new GLUT();
    float pos[] = {0, 1, 0, 0};

    public static void main(String args[]) {
        ProjetoFinal projetoFinalT5 = new ProjetoFinal();
    }
    private double glevantar;
    private double gAbrirB;
    private double gcamera;
    
    private double incG =0.2;
    private double incA =0.2;
    private double incC1;
    private double incC2;
    private double incP;
    private double incO;

    private boolean Humano;
    private boolean Cachoro;
    
    private boolean BEsquerdo;
    private boolean BDireito;
    
    private boolean Ecauda;
    private boolean Epenis;
    private boolean Eorelha;
    private boolean Epescoco;
    private boolean Ebraco;
    private boolean Eperna;
    
    private boolean Dcauda;
    private boolean Dpenis;
    private boolean Dorelha;
    private boolean Dpescoco;
    private boolean Dbraco;
    private boolean Dperna;
    
    private double Cauda;
    private double Penis;
    private double Orelha;
    private double Pescoco;
    private double Braco;
    private double Perna;
  

        public ProjetoFinal() {
        GLJPanel canvas = new GLJPanel();
        canvas.addGLEventListener(this);

        JFrame frame = new JFrame("Projeto Cachorro");
        frame.setSize(600, 600);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        frame.addKeyListener((KeyListener) this);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        System.exit(0);
                    }
                }).start();
            }
        });

    }

    @Override

    public void init(GLAutoDrawable glAuto) {
        Animator a = new Animator(glAuto);
        a.start();
        GL gl = glAuto.getGL();
        gl.glClearColor(0.4f, 0.4f, 0.4f, 0.4f);
        gl.glEnable(GL.GL_DEPTH_TEST);

        //Habilita o teste de profundidade
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
    }

    double r = 0;
    float posZ = -10;
    float incZ = 0.1f;

    @Override
    public void display(GLAutoDrawable glAuto) {

        GL2 gl = glAuto.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT
                | GL.GL_DEPTH_BUFFER_BIT
        );
        GL2 g2 = glAuto.getGL().getGL2();

        gl.glLoadIdentity();
        gl.glTranslated(0, 0, -15);
        gl.glRotated(-gcamera, 0, 1, 0);

        gcamera = gcamera + 0.2;
        
        pos[2]=posZ;
        posZ += incZ;
        
        if(posZ > 80)
            incZ = -5f;
        if(posZ < -80)
            incZ = 5f;
        
        
//        gl.glLightfv(GL2.GL_LIGHT0,
//                     GL2.GL_POSITION,
//                     pos,
//                     0);
//        
        
         gl.glRotated(90, 0, 1, 0);
         Cachoro(gl);
         gl.glTranslated(0, -2.8, 0);
         Piso(gl);
         
         
         
//----------------------------------------------------

//TECLADO    
    //levantar     
        if (Humano && glevantar <= 90) 
            glevantar = glevantar + incG;
        
        else
            if (Cachoro && glevantar >=0) 
            glevantar = glevantar - incG;
 
    //Abrir Braço     
        if (BDireito && gAbrirB <= 90) 
            gAbrirB = gAbrirB + incA;
        
        else
            if (BEsquerdo && gAbrirB >=0) 
            gAbrirB = gAbrirB - incA;
    //Sentar
    

//-----------------------------------------------------
////AUTOMATICO
//  //Levantar
//        if (glevantar >= 0) {
//            incG = 0.4;
//        }
//        if (glevantar <= -90) {
//            incG = -0.4;
//        }
//        glevantar = glevantar - incG;
//               
    //Cauda(Abanar)
        if (Cauda <= 0){
            incC1 = -0.4;
        }
        else 
            if (Cauda >= 25){ 
            incC1 = 0.4;
        }
        Cauda = Cauda - incC1;
      
//   //Perna (Sentar)
//        if (Perna >= 0) {
//            incP = 0.4;
//        }
//        if (Perna <= -90) {
//            incP = -0.4;
//        }
//        Perna = Perna - incP; 
//        
     //Orelha (Abanar)
        if (Orelha >= 0) {
            incO = 0.4;
        }
        if (Orelha <= -90) {
            incO = -0.4;
        }
        Orelha = Orelha - incO;            
    }
//------------------------------------
    public void reshape(GLAutoDrawable gLAutoDrawable, int x, int y, int w, int h) {

        GL2 gl = gLAutoDrawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60, 1, 1, 300);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslated(0, 0, -10);
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {

    }

    @Override
    public void dispose(GLAutoDrawable glad) {

    }
    
//MEMBRO INFERIOR (BASE) -----------------------------------------------------------------------
    private void Cachoro(GL2 gl) {
    //BASE
        gl.glPushMatrix();
//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
//        gl.glRotated(-glevantar, 0, 0, 1);
//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
                gl.glPushMatrix();
                    gl.glScaled(1.2, 1.5, 3);
                    gl.glRotated(-10, 0, 0, 1);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                    glut.glutSolidCube(1);
                gl.glPopMatrix();           
    //PERNA ESQUERDA                           
                gl.glPushMatrix();                   
                    gl.glRotated(-13, 0, 0, 1);
                    gl.glTranslated(0, -1.2, -1);
                    gl.glPushMatrix();
                        gl.glScaled(0.75, 1.2, 0.5);
                        gl.glRotated(-13, 0, 0, 1);
                        gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                        glut.glutSolidCube(1); 
                    gl.glPopMatrix();
                    
                    gl.glRotated(Perna, 0, 0, 1);
                    gl.glRotated(10, 0, 0, 1);
                    gl.glTranslated(-0.2, -0.7, 0);
                    gl.glScaled(0.4, 1.2, 0.4);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                    glut.glutSolidCube(1);
                               
                    gl.glTranslated(0.35, -0.6, 0);
                    gl.glScaled(1, 0.25, 1);
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    glut.glutSolidCube(1);
                    
                gl.glPopMatrix();
//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr 
//                gl.glRotated(-glevantar, 0, 0, 1);
//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
        //PERNA DIREITA            
                gl.glPushMatrix();                   
                    gl.glRotated(-13, 0, 0, 1);
                    gl.glTranslated(0, -1.2, 1);
                    gl.glPushMatrix();
                        gl.glScaled(0.75, 1.2, 0.5);
                        gl.glRotated(-13, 0, 0, 1);
                        gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                        glut.glutSolidCube(1); 
                    gl.glPopMatrix();
                    
                    gl.glRotated(Perna, 0, 0, 1);
                    gl.glRotated(10, 0, 0, 1);
                    gl.glTranslated(0, -0.7, 0);
                    gl.glScaled(0.4, 1.2, 0.4);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                    glut.glutSolidCube(1);
                               
                    gl.glTranslated(0.35, -0.6, 0);
                    gl.glScaled(1, 0.25, 1);
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    glut.glutSolidCube(1);
                    
                gl.glPopMatrix();       
        //CAUDA   
                gl.glPushMatrix();
                    gl.glRotated(Cauda, 1, 0, 0);
                    gl.glRotated(45, 0, 0, 1);
                    gl.glTranslated(0, 1.3, 0);
                    gl.glScaled(0.2, 3, 0.2);
                    gl.glRotated(25, 0, 0, 1);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja                  
                    glut.glutSolidCube(1);
                gl.glPopMatrix();              
        //PENIS  
                gl.glPushMatrix();
//                    gl.glRotated(Penis, 1, 0, 0);
                    gl.glRotated(-15, 0, 0, 1);
                    gl.glTranslated(1, -0.2, 0);
                    gl.glScaled(1, 0.22, 0.2);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja                  
                    glut.glutSolidCube(1);
                gl.glPopMatrix();
    //CORPO
//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr   
            gl.glRotated(glevantar, 0, 0, 1); 
//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr 
        //CORPO                                 
                gl.glPushMatrix();
                    gl.glTranslated(1.8, 0.2, 0);
                    gl.glScaled(5, 1.5, 1.5);
                    gl.glRotated(1, 0, 0, 1);
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    glut.glutSolidCube(1);
                gl.glPopMatrix(); 
                
        //PEITO
                gl.glTranslated(3.6, 0.1, 0);
                gl.glPushMatrix();   
                    gl.glScaled(2.4, 2, 2);
                    gl.glRotated(-5, 0, 0, 1);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                    glut.glutSolidCube(1);
                gl.glPopMatrix();
        //PERNA DIREITA
                gl.glPushMatrix();
                    gl.glRotated(-glevantar, 0, 0, 1);
                    gl.glRotated(-gAbrirB, 1, 0, 0);
                    gl.glTranslated(0.4, -1.1, 1);              
                    gl.glScaled(0.5, 3.3, 0.5);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                    glut.glutSolidCube(1);
                    gl.glTranslated(0.35, -0.45, 0);
                    gl.glScaled(0.95, 0.1, 0.9);
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    glut.glutSolidCube(1);
                gl.glPopMatrix(); 
        //PERNA ESQUERDA
                gl.glPushMatrix();
                    gl.glRotated(-glevantar, 0, 0, 1);
                    gl.glRotated(gAbrirB, 1, 0, 0);
                    gl.glTranslated(0.4, -1.1, -1); 
                    gl.glScaled(0.5, 3.3, 0.5);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                    glut.glutSolidCube(1);
                    gl.glTranslated(0.35, -0.45, 0);
                    gl.glScaled(0.95, 0.1, 0.9);
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    glut.glutSolidCube(1);
                gl.glPopMatrix(); 
        //PESCOÇO
                //Pescoço
                 gl.glRotated(-glevantar, 0, 0, 1);
                 gl.glTranslated(0.55, 0.8, 0);
                 gl.glPushMatrix();                       
                    gl.glScaled(1, 1.2, 0.6);
                    gl.glRotated(-4, 0, 0, 1);
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    glut.glutSolidCube(1);
                 gl.glPopMatrix();
        //CABEÇA
                //NarizParte1
                gl.glPushMatrix();
                    gl.glTranslated(0.8, 0.8, 0);
                    gl.glScaled(0.8, 0.8, 0.8);
                    gl.glRotated(-5, 0, 0, 1);
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    glut.glutSolidCube(1);
                gl.glPopMatrix();
                //NarizParte2
                gl.glPushMatrix();
                    gl.glTranslated(1.12, 1.25, 0);
                    gl.glScaled(0.3, 0.3, 0.3);
                    gl.glRotated(30, 0, 0, 1);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja
                    glut.glutSolidCube(1);  
                gl.glPopMatrix();
                //Olho Esquerdo
                gl.glPushMatrix();
                    gl.glTranslated(0.55, 1.35, 0.2);
                    gl.glScaled(0.1, 0.1, 0.1);
                    gl.glColor3d(1, 1, 1);//Cor Laranja
                    glut.glutSolidCube(1);  
                gl.glPopMatrix();
                //Olho Direito
                gl.glPushMatrix();
                    gl.glTranslated(0.55, 1.35, -0.2);
                    gl.glScaled(0.1, 0.1, 0.1);                  
                    gl.glColor3d(1, 1, 1);//Cor Laranja
                    glut.glutSolidCube(1);  
                gl.glPopMatrix(); 
                //cabeça 
                gl.glTranslated(0, 1.2, 0);
                gl.glPushMatrix();                    
                    gl.glColor3d(0.66, 0.66, 0.66);//Cor Sizenta
                    gl.glScaled(1.1, 0.9, 0.9);
                    gl.glRotated(-5, 0, 0, 1);
                    glut.glutSolidCube(1);
                gl.glPopMatrix();
                //Orelha direita
                gl.glPushMatrix();
                    gl.glRotated(Orelha, 0, 0, 1);
                    gl.glTranslated(0, -0.3, 0.5);
                    gl.glScaled(0.5, 1, 0.5);
                    gl.glRotated(-5, 0, 0, 1);
                    gl.glColor3d(0.93, 0.57, 0.13);//Cor Laranja      
                    glut.glutSolidCube(1);
                gl.glPopMatrix();
                //Orelha Esquerda
                gl.glPushMatrix();
                    gl.glRotated(Orelha, 0, 0, 1);
                    gl.glTranslated(0, -0.3, -0.5);
                    gl.glScaled(0.5, 1, 0.5);
                    gl.glRotated(-5, 0, 0, 1);
                    glut.glutSolidCube(1);
                gl.glPopMatrix();
                
              
        gl.glPopMatrix();
    }
    
    
    private void Piso(GL2 gl) {
                gl.glPushMatrix();
                    gl.glRotated(90, 0, 0, 1);
                    gl.glScaled(0.5, 1, 0.5);
                    gl.glColor3d(1, 0, 0);
                    glut.glutSolidSphere(20, 2, 200);
                gl.glPopMatrix();
    }
    
    
    public void keyTyped(KeyEvent e) {

    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Humano = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Cachoro = true;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            BDireito = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            BEsquerdo = true;
        }

    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Humano = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Cachoro = false;
        }       
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            BDireito = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            BEsquerdo = false;
        }

    }  
}
