/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author Jinesh
 */
public class Cricket {

    /**
     * @param args the command line arguments
     */
   public static   HashMap<String,Integer> batmap = new HashMap();
    public static   HashMap<String,Integer> mom = new HashMap();

   public static    HashMap<String,Integer> bowlmap = new HashMap();
    public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";
    public static void main(String[] args) throws IOException, InterruptedException {

                String baseuri = "http://www.espncricinfo.com";
		Document doc = Jsoup.connect(baseuri+"/indian-premier-league-2017/engine/series/1078425.html").userAgent("Mozilla/5.0").get();
                    
           FileInputStream  help = new FileInputStream(new File("C:\\IPL\\ipl.xlsx"));
           XSSFWorkbook wb1 = new XSSFWorkbook(help);
int i =0;
          XSSFSheet sheet1 = wb1.getSheetAt(0);
    // Create a row and put some cells in it. Rows are 0 based.
    for(int m=2;m<17;m++){
          XSSFRow row1 = sheet1.getRow(m);
          batmap.put(row1.getCell(1).getStringCellValue(), 0);
           batmap.put(row1.getCell(7).getStringCellValue(), 0);
            bowlmap.put(row1.getCell(1).getStringCellValue(), 0);
           bowlmap.put(row1.getCell(7).getStringCellValue(), 0);
              mom.put(row1.getCell(1).getStringCellValue(), 0);
           mom.put(row1.getCell(7).getStringCellValue(), 0);
    }

               String x1 =doc.select("#full-scorecard").html();
                   
                // String x =doc.select(data(".//*[@id='viewport']/div[3]/div/div[3]/div/div[1]/div/div/ul/li[1]/div[1]/ul/li[1]/a")).attr("href");
                System.out.println("it is "+x1);
              
                while(i<200){
                    String y="not there";
                    Elements x = doc.select("#viewport>div:eq(3)>div>div:eq(2)>div>div:eq(0)>div>div>ul>li:eq("+i+")>div:eq(0)>ul>li:eq(0)>a");
                    
                    
                    if(x.size()==1&& x.first().text().equalsIgnoreCase("scorecard")){
                    y =  x.get(0).attr("href");
                    match(baseuri+y);
                    }
                   System.out.println(y);
                   i++;
                }
                
                for(int j=2;j<17;j++){
                     XSSFRow row1 = sheet1.getRow(j);
                     Integer jba = Integer.valueOf(batmap.get(row1.getCell(1).getStringCellValue()));
                     Integer rba = Integer.valueOf(batmap.get(row1.getCell(7).getStringCellValue()));
                      Integer jbo = Integer.valueOf(bowlmap.get(row1.getCell(1).getStringCellValue()));
                       Integer rbo = Integer.valueOf(bowlmap.get(row1.getCell(7).getStringCellValue()));
                       Integer jmom = Integer.valueOf(mom.get(row1.getCell(1).getStringCellValue()));
                         Integer rmom = Integer.valueOf(mom.get(row1.getCell(7).getStringCellValue()));
                     row1.createCell(3).setCellValue(jba);
                     row1.createCell(9).setCellValue(rba);
                     row1.createCell(4).setCellValue(jbo);
                     row1.createCell(10).setCellValue(rbo);
                     row1.createCell(5).setCellValue(jmom);
                     
                     row1.createCell(11).setCellValue(rmom);
                     row1.createCell(6).setCellValue(jba*10+jbo*250+jmom*250);
                    
                     row1.createCell(12).setCellValue(rba*10+rbo*250+rmom*250);
                }
                XSSFRow row1 = sheet1.getRow(18);
                XSSFCell cell = row1.createCell(6);
                String strFormula= "SUM(G3:G17)";
                cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell.setCellFormula(strFormula);
                 XSSFCell cell1 = row1.createCell(12);
                String strFormula1= "SUM(M3:M17)";
                cell1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
                cell1.setCellFormula(strFormula1);
            FileOutputStream fileOut = new FileOutputStream("C:\\IPL\\ipl.xlsx");

    wb1.write(fileOut);
    fileOut.close();
    wb1.close();

    }
    
   /*   //.//*[@id='viewport']/div[3]/div/div[3]/div/div[1]/div/div/ul/li[1]/div[1]/ul/li[1]/a
                String x =doc.select("#viewport>div:eq(3)>div>div:eq(2)>div>div:eq(0)>div>div>ul>li:eq(0)>div:eq(0)>ul>li:eq(0)>a").attr("href");*/
 private static String data(String x,Document doc){
          StringBuilder sb = new StringBuilder();
       String y  =  x.substring(x.indexOf("'")+1);
       String id = y.substring(0,y.indexOf("'"));
       String z = y.substring(y.indexOf("'")+3);
       sb.append("#"+id);
      
            String[] d = z.split("/");
            for(int i=0; i<d.length;i++){
                String a = d[i];
               if(a.contains("[")){
                   String c = a.substring(0,a.indexOf("["));
                   String b = a.substring(a.indexOf("[")+1,a.indexOf("]"));
                   Integer o = Integer.valueOf(b)-1;
                   System.out.println(sb.toString());
                    Element docu1 = doc.select(sb.toString()).first();
                    if(docu1!=null){
                    Elements doc1 = docu1.children();
                   int j =-1;
                   int n=0;
                    for ( n =0;n<doc1.size();n++) {
                        if(doc1.get(n).tagName().equalsIgnoreCase(c)){
                            j++;
                        }
                     if(j==o)break;   
                    }
                   sb.append(">"+c+":eq("+n+")");
                   
                    }
               }else{
                   sb.append(">"+a);
               }
            }
       
       
      //  System.out.println(sb.toString());
        return sb.toString();
    }
    

    

    private static void match(String x) throws IOException {
        System.out.println(x);
      
    
       Document doc1 = Jsoup.connect(x).userAgent("Mozilla/5.0").get();
    //    Element z1 = doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table[2]/tbody/tr[8]/td[2]/a",doc1)).first();
                
       
        Element y1;
     /*  y1 = doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/",doc1)).first();
        
      Elements x2 = y1.children();
     */
     for(int j =1;j<4;j++){
    //   if(!x2.get(j).tagName().equals("table"))continue;

        //   if(x2.get(j).className().contains("batting-table")){
           //    count++;
                          for(int i=2;i<24;i=i+2){
                              int n= j+1;
      String name = doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table["+j+"]/tbody/tr["+i+"]/td[2]",doc1)).text();
      String data =  doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table["+j+"]/tbody/tr["+i+"]/td[4]",doc1)).text();
        System.out.println("name is "+ name);
      if(name.contains("†")|| name.contains("*")){
          name = name.substring(0,name.length()-1);
      }
      if(name.contains("Watson")){
          System.out.println();
      }
      if(batmap.containsKey(name)){
          batmap.put(name, batmap.get(name)+Integer.valueOf(data));
      }
        
       
           }
                          j++;
     }
         for(int y=2;y<5;y++){
       for(int i=2;i<24;i=i+2){
   
    
        String name = doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table["+y+"]/tbody/tr["+i+"]/td[2]",doc1)).text();
     String  data =  doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table["+y+"]/tbody/tr["+i+"]/td[6]",doc1)).text();
       if(name.contains("Watson")){
          System.out.println();
      }
       if(name.contains("†")|| name.contains("*")){
          name = name.substring(0,name.length()-1);
      }
      if(bowlmap.containsKey(name)){
          bowlmap.put(name, bowlmap.get(name)+Integer.valueOf(data));
      }
      
       }
       y++;
    }
     Elements x3 =  doc1.select(data(".//*[@id='full-scorecard']/div[3]/div/div/div[2]",doc1));
       
       String y ="";
      
       if(x3.text().contains("Player of the ")){
           String v =x3.toString().substring(x3.toString().indexOf("Player of the "));
          for(String x5:mom.keySet()){
                   if(v.contains(x5)){
           mom.put(x5, mom.get(x5)+1);
           break;
          }
      
       }
       
       }
       
     
           
    }
     
}


  /*  name = doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table[4]/tbody/tr["+i+"]/td[2]")).text();
       data =  doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table[4]/tbody/tr["+i+"]/td[4]")).text();
       if(name.contains("†")|| name.contains("*")){
          name = name.substring(0,name.length()-1);
      }
      if(batmap.containsKey(name)){
          batmap.put(name, batmap.get(name)+Integer.valueOf(data));
      }*/
    
        /*  Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the search term.");
		String searchTerm = scanner.nextLine();
		System.out.println("Please enter the number of results. Example: 5 10 20");
		int num = scanner.nextInt();
		scanner.close();*/
		
		//String searchURL =( GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
		//without proper User-Agent, we will get 403 error

    
        // TODO code application logic here
     /*  driver.get("http://www.espncricinfo.com/india/content/player");
       findandclick(".//*[@id='ProfilesearchTxtBox']","dhoni");
       findandclick(".//*[@id='plyrSrchBg']/form/input[2]");
       findandclick(".//*[@id='ciHomeContentlhs']/div[5]/div/p[2]/a");
       Thread.sleep(5000);
       Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='ciHomeContentlhs']/div[4]/table[3]/tbody/tr[9]/td[2]/form/select")));
       dropdown.selectByVisibleText("Batting innings list");
        findandclick(".//*[@id='ciHomeContentlhs']/div[3]/table[4]/tbody/tr[7]/td[14]/a");
        
       WebElement x =driver.findElement(By.xpath(".//*[@id='full-scorecard']/div[2]/div/table[1]"));
       
       System.out.print(x.getText());*/

/*         //.//*[@id='viewport']/div[3]/div/div[3]/div/div[1]/div/div/ul/li[1]/div[1]/ul/li[1]/a
                //String x =doc.select("#viewport>div:eq(3)>div>div:eq(2)>div>div:eq(0)>div>div>ul>li:eq(0)>div:eq(0)>ul>li:eq(0)>a").text();
                    String x =doc.select(data(".//*[@id='full-scorecard']/div[2]/div/table[2]/tbody/tr[2]/td[2]/a")).toString();
                   
                // String x =doc.select(data(".//*[@id='viewport']/div[3]/div/div[3]/div/div[1]/div/div/ul/li[1]/div[1]/ul/li[1]/a")).attr("href");
                System.out.println(x);
                
		//String text = doc.getElementById("ProfilesearchTxtBox").text();
          //     System.out.println(doc.getElementById("ciHomeContentlhs").data());
		//below will print HTML data, save it to a file and open in browser to compare
		//System.out.println(doc.html());
		
		//If google search results HTML change the <h3 class="r" to <h3 class="r1"
		//we need to change below accordingly
		Elements results = doc.select("h3.r > a");

		for (Element result : results) {
			String linkHref = result.attr("href");
			String linkText = result.text();
			System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
		}
	
    */

 /*  String name = doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table[3]/tbody/tr["+i+"]/td[2]")).text();
      String data =  doc1.select(data(".//*[@id='full-scorecard']/div[2]/div/table[3]/tbody/tr["+i+"]/td[6]")).text();
 
      if(name.contains("†")|| name.contains("*")){
          name = name.substring(0,name.length()-1);
      }
  
      if(bowlmap.containsKey(name)){
          bowlmap.put(name, bowlmap.get(name)+Integer.valueOf(data));
      }*/