package ch2.test;
import ch2.data.*;
public class AppTest {
   public static void main(String [] args){
      Computer com0 = new Computer();
      System.out.println("�����ǽ��мӷ�����:");
      com0.setDataItem('3');
      com0.setOperator('+');
      com0.setDataItem('1');
      com0.setDataItem('5');
      System.out.println("TempResult="+com0.getTempResult());
      System.out.println("DataItem="+com0.computerDataItem());
      System.out.println("result="+com0.getResult());
      System.out.println("\n");

      System.out.println("�����ǽ��м�������:");
      Computer com1 = new Computer();
      com1.setDataItem('4');
      com1.setOperator('-');
      com1.setDataItem('1');
      com1.setDataItem('0');
      System.out.println("TempResult="+com1.getTempResult());
      System.out.println("DataItem="+com1.computerDataItem());
      System.out.println("result="+com1.getResult());
      System.out.println("\n");

      System.out.println("�����ǽ��г˷�����:");
      Computer com2 = new Computer();
      com2.setDataItem('4');
      com2.setOperator('*');
      com2.setDataItem('2');
      com2.setDataItem('0');
      System.out.println("TempResult="+com2.getTempResult());
      System.out.println("DataItem="+com2.computerDataItem());
      System.out.println("result="+com2.getResult());
      System.out.println("\n");

      System.out.println("�����ǽ��г�������:");
      Computer com3 = new Computer();
      com3.setDataItem('4');
      com3.setDataItem('0');
      com3.setOperator('/');
      com3.setDataItem('2');
      System.out.println("TempResult="+com3.getTempResult());
      System.out.println("DataItem="+com3.computerDataItem());
      System.out.println("result="+com3.getResult());
      System.out.println("\n");

      System.out.println("�����ǽ��и��Ų���:");
      System.out.println("result="+Math.sqrt(4));
      System.out.println("\n");

      System.out.println("�����ǽ��е�������:");
      System.out.println("result="+Math.pow(10,-1));
      System.out.println("\n");

      System.out.println("�����ǽ���sin��������:");
      System.out.println("result="+Math.sin(Math.PI/6));
      System.out.println("\n");

      System.out.println("�����ǽ���cos��������:");
      System.out.println("result="+Math.cos(Math.PI/6));
      System.out.println("\n");

      System.out.println("�����ǽ���tan��������:");
      System.out.println("result="+Math.tan(Math.PI/6));
      System.out.println("\n");

      System.out.println("�����ǽ��н׳˲���:");
      System.out.println("result="+Factoral.factorial(5));
      System.out.println("\n");
   }
}