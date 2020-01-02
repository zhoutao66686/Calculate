package ch2.view;
import java.awt.event.*;
public class HandleEvent implements ActionListener{
    CalculatorWindow window;
    HandleEvent(CalculatorWindow window) {
       this.window=window;
    }
    public void showMess() {
       window.resultShow.setText(" =  "+get(window.computer.getResult()));
       window.showTempResult.setText(get(window.computer.getTempResult())+" ");
       window.showOperator.setText("  "+window.computer.getOperator()+" ");
       window.showDataItem.setText("  "+get(window.computer.computerDataItem()));
    }
    public String get(double r){//���ظ������Ĵ���ʾ�����С��������0,ʡ��С��
       String s="";
       Double d = new Double(r);
       long n = d.longValue();//�õ�r��������
       if(Math.abs(r-n)>0)
            s =""+r;
       else
            s =""+n;
       return s;
    }
    public void actionPerformed(ActionEvent e){}
}