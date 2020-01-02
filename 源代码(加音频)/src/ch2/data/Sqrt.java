package ch2.data;
public class Sqrt implements MathComputer {
   public void handle(Computer data){
       String s ="";
       double r =data.computerDataItem();
       r =Math.sqrt(r);
       Double d = new Double(r);
       long n = d.longValue();//�õ�r��������
       if(Math.abs(r-n)>0) //С�����ֲ���0
            s =""+r;
       else
            s =""+n;//���С��������0,ʡ��С��
       data.dataItem.removeAllElements();
       for(int i = 0;i<s.length();i++){
          data.dataItem.push(s.charAt(i));
       }
   }
}
