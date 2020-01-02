package ch2.data;
import java.util.*;
public class Computer {
   public double result;    //�������ý��
   public Stack<Character>  dataItem;  //���������������
   public Stack<Double>  tempResult;   //�ö�ջ�����ʱ���
   public Stack<Character>  operator;  //����������
   public Computer(){
       init();
   }
   public void init() {
       dataItem = new Stack<Character>();
       tempResult = new Stack<Double>();
       dataItem.push('0');
       operator = new Stack<Character>();  
   }
   public void setDataItem(char c){ 
       if(c!='.')
         dataItem.push(c);
       else {
          if(!dataItem.contains('.'))
             dataItem.push(c);
       }
   }
   public void setOperator(char p){ 
       if(dataItem.empty()){   //���û��������
          operator.clear();//��ֹ�û����ϸ����򷴸�����һ�������
          operator.push(p);//��ջѹ����������������û����ȷ���������
          return;
       }
       if(operator.empty()) {     //���û�������
          operator.push(p);       //��ջѹ�������
          double m = computerDataItem(); //����������
          dataItem.removeAllElements();  //���������е��������
          tempResult.push(m);           //����ʱ���mѹ��tempResult
       } 
       else {                     //����������
          double mData = computerDataItem(); //����������
          dataItem.removeAllElements();  //���������е��������
          char yuansuan =operator.pop(); //�������е������
          double rTemp =tempResult.pop();     //������ʱ���
          if(yuansuan == '+'){
             rTemp = rTemp+mData;
          }
          else if(yuansuan == '-') {
             rTemp = rTemp-mData;
          }
          else if(yuansuan == '*') {
             rTemp = rTemp*mData;
          }
          else if(yuansuan == '/') {
             rTemp = rTemp/mData;
          }
          tempResult.push(rTemp);  //������ʱ���rTempѹ��tempResult
          operator.push(p);        //�������ѹ��operator
       }
   }
   public char getOperator() {
      if(operator.empty()){
         return '\0';
      }
      return operator.peek();
   }
   public void backspace() {
      if(dataItem.size()>=1){
         dataItem.pop();
      }
   }
   public void initDataItemByMath(MathComputer computer){ 
       computer.handle(this);     //��compter�е������������ѧ����
   }
   public double getResult() {    //�õ�������
      double endItem = 0;
      if(dataItem.empty()){
         endItem = tempResult.peek();
      }
      else {
         endItem = computerDataItem();
      }
      if(operator.empty()) {
         result = endItem;
         return result;
      }
      char yuansuan =operator.peek(); //���������
      if(yuansuan == '+'){
          result = tempResult.peek()+endItem;
      }
      else if(yuansuan == '-') {
          result = tempResult.peek()-endItem;
      }
      else if(yuansuan == '*') {
          result = tempResult.peek()*endItem;
      }
      else if(yuansuan == '/') {
          result = tempResult.peek()/endItem;
      }
      return result;
   }
   public double getTempResult() {    //�õ���ʱ���
      double r = 0;
      if(tempResult.empty()){
         r = computerDataItem();
      }
      else {
         r= tempResult.peek();
      }
      return r;
   }
   public double computerDataItem(){  //������������double�ͽ��
      if(dataItem.empty()){
         return tempResult.peek();
      }
      StringBuffer str = new StringBuffer();
      double doubleData = 0;
      for(int i=0;i<dataItem.size();i++) {
          str.append(dataItem.get(i));//��ȡ��ջ�е�����(������ջ)
      }
      try{
         doubleData = Double.parseDouble(str.toString());
      }
      catch(NumberFormatException exp){
          doubleData = 0;
      }
      return doubleData;
  }
}
