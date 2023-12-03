import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class PDF {

    public static void main(String[] args) {
    	
        String filePath = "E:\\sample2.pdf";
        Scanner s=new Scanner(System.in);
        System.out.println("Enter 1 to view or 2 to search the word");
        int option=s.nextInt();
        if(option==1)
        {
        try {
            PDDocument document = PDDocument.load(new File(filePath));
            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            for (int page = 1; page <= document.getNumberOfPages(); page++) {
                pdfTextStripper.setStartPage(page);
                pdfTextStripper.setEndPage(page);

                String pageText = pdfTextStripper.getText(document);
                System.out.println(pageText);
            }

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        else if(option==2)
        {
        	System.out.println("Enter the word want to search");
        	s.nextLine();
        	String word=s.nextLine();
        	int linecount=0;
        	 try {
                 PDDocument document = PDDocument.load(new File(filePath));
                 PDFTextStripper pdfTextStripper = new PDFTextStripper();

                 for (int page = 1; page <= document.getNumberOfPages(); page++) {
                     pdfTextStripper.setStartPage(page);
                     pdfTextStripper.setEndPage(page);

                     String pageText = pdfTextStripper.getText(document);
                     String array[]=pageText.split("[\n]");
                     for(int i=0;i<array.length;i++)
                     {
                    	 linecount++;
                    	 String array1[]=array[i].split(" ");
                    	 for(int j=0;j<array1.length;j++)
                    	 {
                    		 
                    		 if(array1[j].trim().toLowerCase().equals(word))
                    		 {                    	 
                    			 System.out.println(array1[j]+" in line number "+linecount);
                    		 }
                    	 }
                     }
                 }

                 document.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
        	
        }
    }
}