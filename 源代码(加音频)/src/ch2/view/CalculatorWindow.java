package ch2.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import ch2.data.*;
public class CalculatorWindow extends JFrame {
    Computer  computer;     //��Ҫ�ṩ��ͼ�Ķ���
    JButton numberButton[]; //���ְ�ť
    JButton operatorButton[];//�Ӽ��˳���ť
    JButton dot,pOrN,back,equation,clear;//С���㣬������,�˸�,�Ⱥ�,����; 
    JButton sqrt,reciprocal;//��ƽ������������ť
    JButton sin,cos,tan;//��sin��cos��tan
    JButton smile;//����
    JButton factorial;
    JTextField resultShow;          //��ʾ������
    JTextField showTempResult; //��ʾ��ǰ������̵���ʱ���
    JLabel     showOperator  ; //��ʾ�������
    JTextField showDataItem; //��ʾ��ǰ���������������
    JTextArea  saveComputerProcess; //��ʾ���㲽��
    JButton saveButton,copyButton,clearTextButton;//���������̵Ȱ�ť
    public CalculatorWindow(){
        computer = new Computer();
        initView();             //���ý���
        initActionListener();  //ע�������
    }
    public void initView(){
        setTitle("������");
        JPanel panelLeft,panelRight; 
        resultShow=new JTextField(10);
        resultShow.setHorizontalAlignment(JTextField.LEFT);
        resultShow.setForeground(Color.blue);
        resultShow.setFont(new Font("TimesRoman",Font.BOLD,14));
        resultShow.setEditable(false);
        resultShow.setBackground(Color.green);
        showTempResult=new JTextField();
        showTempResult.setHorizontalAlignment(JTextField.RIGHT);
        showTempResult.setFont(new Font("Arial",Font.BOLD,14));
        showTempResult.setBackground(Color.cyan);
        showTempResult.setEditable(false);
        showOperator = new JLabel();
        showOperator.setBackground(Color.pink);
        showOperator.setFont(new Font("Arial",Font.BOLD,18));
        showOperator.setHorizontalAlignment(JTextField.CENTER);
        showDataItem = new JTextField(); 
        showDataItem.setBackground(Color.white);
        showDataItem.setHorizontalAlignment(JTextField.LEFT);
        showDataItem.setFont(new Font("Arial",Font.BOLD,14));
        showDataItem.setEditable(false);
        saveComputerProcess=new JTextArea();
        saveComputerProcess.setEditable(false);
        saveComputerProcess.setFont(new Font("����",Font.PLAIN,14));
        numberButton=new JButton[10];
        for(int i=0;i<=9;i++) {
            numberButton[i] = new JButton("" + i);
            numberButton[i].setFont(new Font("Arial", Font.BOLD, 20));
        }
        operatorButton=new JButton[4];
        String �������[]={"+","-","*","/"}; 
        for(int i=0;i<4;i++){
           operatorButton[i]=new JButton(�������[i]);
           operatorButton[i].setFont(new Font("Arial",Font.BOLD,20));
            operatorButton[i].setForeground(Color.RED);
        }
        dot=new JButton(".");
        pOrN=new JButton("+/-");
        pOrN.setForeground(Color.BLUE);
        equation=new JButton("=");
        equation.setForeground(Color.BLUE);
        back  = new JButton("�˸�");
        back.setForeground(Color.BLUE);
        clear = new JButton("C");
        clear.setForeground(Color.BLUE);
        sqrt=new JButton("sqrt");
        sqrt.setForeground(Color.BLUE);
        reciprocal=new JButton("1/x");
        reciprocal.setForeground(Color.BLUE);
        saveButton=new JButton("����");
        copyButton=new JButton("����");
        clearTextButton=new JButton("���");

        sin=new JButton("sin");
        sin.setForeground(Color.BLUE);
        cos=new JButton("cos");
        cos.setForeground(Color.BLUE);
        tan=new JButton("tan");
        tan.setForeground(Color.BLUE);

        smile = new JButton("(��'~'��)");
        smile.setForeground(Color.BLUE);

        factorial = new JButton("!");
        factorial.setForeground(Color.BLUE);


        panelLeft=new JPanel(); //��ʼ���֣�����������Ҫ������
        panelRight=new JPanel();
        panelLeft.setLayout(new BorderLayout()); 
        JPanel centerInLeft=new JPanel();
        Box boxH=Box.createHorizontalBox();
        boxH.add(showTempResult);
        boxH.add(showOperator);
        boxH.add(showDataItem);
        panelLeft.add(boxH,BorderLayout.NORTH);
        panelLeft.add(centerInLeft,BorderLayout.CENTER);
        centerInLeft.setLayout(new GridLayout(5,6));

        centerInLeft.add(numberButton[7]); //���ֵĵ�1��
        centerInLeft.add(numberButton[8]);
        centerInLeft.add(numberButton[9]);
        centerInLeft.add(operatorButton[0]);
        centerInLeft.add(back);
        centerInLeft.add(sin);

        centerInLeft.add(numberButton[4]);//���ֵĵ�2��
        centerInLeft.add(numberButton[5]);
        centerInLeft.add(numberButton[6]);
        centerInLeft.add(operatorButton[1]);
        centerInLeft.add(clear);
        centerInLeft.add(cos);

        centerInLeft.add(numberButton[1]);//��3��
        centerInLeft.add(numberButton[2]);
        centerInLeft.add(numberButton[3]);
        centerInLeft.add(operatorButton[2]);
        centerInLeft.add(reciprocal);
        centerInLeft.add(tan);

        centerInLeft.add(numberButton[0]); //��4��
        centerInLeft.add(pOrN);
        centerInLeft.add(dot);
        centerInLeft.add(operatorButton[3]);
        centerInLeft.add(sqrt);
        centerInLeft.add(equation);

        centerInLeft.add(new JLabel()); //��5��
        centerInLeft.add(new JLabel());
        centerInLeft.add(new JLabel());
        centerInLeft.add(new JLabel());
        centerInLeft.add(factorial);
        centerInLeft.add(smile);


        panelRight.setLayout(new BorderLayout());
        panelRight.add(resultShow,BorderLayout.NORTH);
        panelRight.add(
        new JScrollPane(saveComputerProcess),BorderLayout.CENTER);
        JPanel southInPanelRight=new JPanel();
        southInPanelRight.add(saveButton);
        southInPanelRight.add(copyButton);
        southInPanelRight.add(clearTextButton);
        panelRight.add(southInPanelRight,BorderLayout.SOUTH);
        JSplitPane split=new JSplitPane
                (JSplitPane.HORIZONTAL_SPLIT,panelLeft,panelRight);
        add(split,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(150,130,888,490);
        validate(); 
   }
   public void initActionListener(){
        HandleDigit handleDigit = new HandleDigit(this);
        for(int i=0;i<=9;i++){
          numberButton[i].addActionListener(handleDigit); //Ϊ���ְ�ťע�������
        } 
        dot.addActionListener(handleDigit);
        HandleOperator handleOperator = new HandleOperator(this);
        for(int i=0;i<4;i++){
          operatorButton[i].addActionListener(handleOperator);
        }
        pOrN.addActionListener(new HandlePN(this));
        sqrt.addActionListener(new HandleSqrt(this));
        reciprocal.addActionListener(new HandleReciprocal(this));
        back.addActionListener(new HandleBack(this));
       sin.addActionListener(new HandleSin(this));
       cos.addActionListener(new HandleCos(this));
       tan.addActionListener(new HandleTan(this));
       smile.addActionListener(new HandleSmile(this));
       factorial.addActionListener(new HandleFactorial(this));
       equation.addActionListener(new HandleEquation(this));
        clear.addActionListener(new HandleClear(this));
        HandleFile handleFile = new HandleFile(this);
        saveButton.addActionListener(handleFile);
        copyButton.addActionListener(handleFile);
        clearTextButton.addActionListener(handleFile);
   }

}
