package com.jk1205.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jk1205.pojo.TUser;




public class ReadExcel {
    //������
    private int totalRows = 0;  
    //������
    private int totalCells = 0; 
    //������Ϣ������
    private String errorMsg;
    //���췽��
    public ReadExcel(){}
    //��ȡ������
    public int getTotalRows()  { return totalRows;} 
    //��ȡ������
    public int getTotalCells() {  return totalCells;} 
    //��ȡ������Ϣ
    public String getErrorInfo() { return errorMsg; }  
    
  /**
   * ��֤EXCEL�ļ�
   * @param filePath
   * @return
   */
  public boolean validateExcel(String filePath){
	  if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){  
          errorMsg = "�ļ�������excel��ʽ";  
          return false;  
      }  
        return true;
  }
    
  /**
   * ��EXCEL�ļ�����ȡ�ͻ���Ϣ����
   * @param fielName
   * @return
   */                                 
  public List<TUser> getExcelInfo(String fileName,MultipartFile Mfile){
      
      //��spring�ļ��ϴ���MultipartFileת����CommonsMultipartFile����
       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //��ȡ���ش洢·��
       File file = new  File("c:\\temp");
       //����һ��Ŀ¼ ������·�����ɵ�ǰ File ����ָ����������һ����ĸ�·������
       if (!file.exists()) file.mkdirs();
       //�½�һ���ļ�
       File file1 = new File("c:\\temp\\" + new Date().getTime() + ".xlsx"); 
       //���ϴ����ļ�д���½����ļ���
       try {
           cf.getFileItem().write(file1); 
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       //��ʼ���ͻ���Ϣ�ļ���    
       List<TUser> customerList=new ArrayList<TUser>();
       //��ʼ��������
       InputStream is = null;  
       try{
          //��֤�ļ����Ƿ�ϸ�
          if(!validateExcel(fileName)){
              return null;
          }
          //�����ļ����ж��ļ���2003�汾����2007�汾
          boolean isExcel2003 = true; 
          if(WDWUtil.isExcel2007(fileName)){
              isExcel2003 = false;  
          } 
        // �ַ��ֽ�ת����  
          //�����½����ļ�ʵ����������
          is = new FileInputStream(file1);
          //����excel��������ݶ�ȡ�ͻ���Ϣ
          customerList = getExcelInfo(is, isExcel2003); 
          is.close();
      }catch(Exception e){
          e.printStackTrace();
      } finally{
          if(is !=null)
          {
              try{
                  is.close();
              }catch(IOException e){
                  is = null;    
                  e.printStackTrace();  
              }
          }
      }
      return customerList;
  }
  /**
   * ����excel��������ݶ�ȡ�ͻ���Ϣ
   * @param is ������
   * @param isExcel2003 excel��2003����2007�汾
   * @return
   * @throws IOException
   */
  public  List<TUser> getExcelInfo(InputStream is,boolean isExcel2003){
       List<TUser> customerList=null;
       try{
           /** ���ݰ汾ѡ�񴴽�Workbook�ķ�ʽ */
    	   Workbook wb = null;
           //��excel��2003ʱ
           if(isExcel2003){
               wb = new HSSFWorkbook(is); 
               System.out.println("2003");
           } else{//��excel��2007ʱ
       
               wb = new org.apache.poi.xssf.usermodel.XSSFWorkbook(is);
         	   System.out.println("2007");
             
           }
           //��ȡExcel����ͻ�����Ϣ
           customerList=readExcelValue(wb);
        
       }
       catch (IOException e)  {  
           e.printStackTrace();  
       }  
       return customerList;
  }
  /**
   * ��ȡExcel����ͻ�����Ϣ
   * @param wb
   * @return
   */
  private List<TUser> readExcelValue(Workbook wb){ 
      //�õ���һ��shell  
       Sheet sheet=wb.getSheetAt(0);
       
      //�õ�Excel������
       this.totalRows=sheet.getPhysicalNumberOfRows();
       
      //�õ�Excel������(ǰ����������)
       if(totalRows>=1 && sheet.getRow(0) != null){
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
       }
       
       List<TUser> customerList=new ArrayList<TUser>();
       TUser customer;            
      //ѭ��Excel����,�ӵڶ��п�ʼ�����ⲻ���
       for(int r=1;r<totalRows;r++){
           Row row = sheet.getRow(r);
           if (row == null) continue;
           customer = new TUser();
           
           //ѭ��Excel����
           for(int c = 0; c <this.totalCells; c++){    
               Cell cell = row.getCell(c);
               if (null != cell){
                   if(c==0){
                       System.out.println(cell);
                       if(cell!=null)
                	   customer.setUname(cell.toString());//�ͻ�����
                       
                   }else if(c==1){
                	   System.out.println(cell);
                	   if(cell!=null)
                        customer.setRname(cell.toString());//�ͻ����
                   }else if(c==2){
                	   System.out.println(cell);
                	   if(cell!=null)
                     customer.setPwd(cell.toString());//����                
    
                   }else if(c==3){
                	   System.out.println(cell);
                	   if(cell!=null){
                	
                		   String gid=cell+"";
                		  double i=Double.parseDouble(gid);
                		  int b=(int) i;
                         customer.setGid(b);//�ͻ���Դ
                	   }
                   }else if(c==4){
                	   System.out.println(cell);
                	   if(cell!=null){
                		   String gid=cell+"";
                 		  double i=Double.parseDouble(gid);
                 		  int b=(int) i;              		   
                       customer.setAid(b);//ְ��
                       
                	   }
                   }
               }
           }
           //��ӿͻ�
           customerList.add(customer);
       }
       return customerList;
  }

}

class WDWUtil {

    // @�������Ƿ���2003��excel������true��2003 
    public static boolean isExcel2003(String filePath)  {  
         return filePath.matches("^.+\\.(?i)(xls)$");  
     }  
   
    //@�������Ƿ���2007��excel������true��2007 
    public static boolean isExcel2007(String filePath)  {  
         return filePath.matches("^.+\\.(?i)(xlsx)$");  
     }  
 
}
