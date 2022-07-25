package com.example.dukedemo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class InvoicePDFCreator extends Scene2Controller {
    public static void main(String[] args) throws IOException {

    }

    public static void createPDF() throws IOException {


        //creating the PDF
        PDDocument document = new PDDocument();

        //creating the blank page to our PDF
        PDPage page =  new PDPage();

        //Adding the blank page to our PDF
        document.addPage(page);

        //initializing the content stream
        PDPageContentStream ContentStream = new PDPageContentStream(document,page);


        //header font
        PDFont HeaderFont = new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD);
        //date font
        PDFont DateFont = new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE);
        //main font Bold
        PDFont MainFontBold = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD);
        //main font
        PDFont MainFont = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);


        String invoiceTitle = "Duke's Auto";
        String SubTitle = "Invoice";

        List<String> comments = Arrays.asList(DOI.split(" "));

        //today's date
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        String date = dateFormat.format(new Date());
        //



        //Dukes Auto
        ContentStream.beginText();
        ContentStream.newLineAtOffset(50, 725);
        ContentStream.setFont(HeaderFont, 20);
        ContentStream.showText(invoiceTitle);
        ContentStream.endText();
        //


        //Invoice
        ContentStream.beginText();
        ContentStream.newLineAtOffset(490,725);
        ContentStream.setFont(HeaderFont,18);
        ContentStream.showText(SubTitle);
        ContentStream.endText();
        //

        //Date
        ContentStream.beginText();
        ContentStream.newLineAtOffset(500,780);
        ContentStream.setFont(DateFont,12);
        ContentStream.showText(date);
        ContentStream.endText();
        //


        //Line break
        ContentStream.setStrokingColor(Color.DARK_GRAY);
        ContentStream.setLineWidth(1);
        int initx = 25;
        int inity = 715;
        int Length = 550;
        int Height = 2;

        ContentStream.addRect(initx,inity,Length,Height);
        ContentStream.stroke();
        //


        //Customer name header
        ContentStream.beginText();
        ContentStream.newLineAtOffset(25,685);
        ContentStream.setFont(MainFontBold,12);
        ContentStream.showText("Customer name: ");
        ContentStream.endText();
        //

        //Customer name
        ContentStream.beginText();
        ContentStream.newLineAtOffset(115,685);
        ContentStream.setFont(MainFont,12);
        ContentStream.showText("[ " + customer.toString() + " ]");
        ContentStream.endText();
        //



        //Vehicle info header
        ContentStream.beginText();
        ContentStream.newLineAtOffset(25,650);
        ContentStream.setFont(MainFontBold,12);
        ContentStream.showText("Vehicle info: ");
        ContentStream.endText();
        //

        //vehicle info
        ContentStream.beginText();
        ContentStream.newLineAtOffset(95,650);
        ContentStream.setFont(MainFont,12);
        ContentStream.showText("[ " + vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + "]    " +  "[ Mileage: " + vehicle.getMileage()
                + " ]   [ VIN: " + vehicle.getVin() +" ]" );
        ContentStream.endText();
        //



        //Line break
        ContentStream.setStrokingColor(Color.DARK_GRAY);
        ContentStream.setLineWidth(1);
        initx = 25;
        inity = 640;
        Length = 550;
        Height = 2;

        ContentStream.addRect(initx,inity,Length,Height);
        ContentStream.stroke();
        //


        //Showing parts and pricing
        int yOffSet = 600;
        ContentStream.setFont(MainFont,10);
        for (Map.Entry entry : PriceAndParts.entrySet()) {
            ContentStream.beginText();
            ContentStream.newLineAtOffset(25,yOffSet);
            if (entry.getKey() != ""){
                ContentStream.showText("Item " + entry.getKey() + " - " + entry.getValue());
            }
            yOffSet = yOffSet - 25;
            ContentStream.endText();
            System.out.println(entry.getKey().getClass());
        }
        //

        //Line break
        ContentStream.setStrokingColor(Color.DARK_GRAY);
        ContentStream.setLineWidth(1);
        initx = 25;
        inity = 405;
        Length = 550;
        Height = 2;

        ContentStream.addRect(initx,inity,Length,Height);
        ContentStream.stroke();
        //


        //Mechanic Comments
        ContentStream.beginText();
        ContentStream.newLineAtOffset(25,390);
        ContentStream.setLeading(14f);
        ContentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ITALIC),12);
        ContentStream.showText("Mechanic Name: Duke");
        ContentStream.newLine();
        ContentStream.showText("Mechanic Comments:");
        ContentStream.newLine();
        ContentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN),12);

        int count = 0;
        for (String string: comments){
            if (count == 15){
                ContentStream.newLine();
                count = 0;
            }
            count++;
            ContentStream.showText(string + " ");
        }

        ContentStream.endText();
        //






        //disclosure
        ContentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ITALIC),10);
        ContentStream.beginText();
        ContentStream.newLineAtOffset(25,200);
        ContentStream.setLeading(12f);
        ContentStream.showText("TERMS: STRICTLY CASH UNLESS ARRANGEMENTS ARE MADE. I hereby authorize the repair work hereinafter to be done ");
        ContentStream.newLine();
        ContentStream.showText("along with the necessary material and agree that you are not responsible for loss or damage to vehicle or articles ");
        ContentStream.newLine();
        ContentStream.showText("left in the vehicle in case of fire theft, or any other cause beyond your control or for any delays caused by");
        ContentStream.newLine();
        ContentStream.showText("Unavailability of parts or delays in  arts shipments by the supplier or transporter. I here by Grant you or");
        ContentStream.newLine();
        ContentStream.showText("your employees permission to operate the vehicle herein described on streets, highways, or elsewhere for the ");
        ContentStream.newLine();
        ContentStream.showText("purpose of testing and/or inspection. An express mechanics lien is hereby acknowledged on above vehicle to secure the amount of repairs.");
        ContentStream.newLine();
        ContentStream.showText("DISCLAIMER OF WARRANTIES. Any warranties on the products sold hereby are those made by the manufacture. The seller hereby expressly");
        ContentStream.newLine();
        ContentStream.showText("disclaims all warranties either express or implied, including any implied warranty of merchantability or fitness for a particular");
        ContentStream.newLine();
        ContentStream.showText("purpose, and the seller neither assumes nor authorizes any other person to assume for it any liability in connection with ");
        ContentStream.newLine();
        ContentStream.showText("the sale of said products. Any limitation contained herein does not apply where prohibited by law.");
        ContentStream.endText();
        //





        //signature box
        ContentStream.beginText();
        ContentStream.newLineAtOffset(27,18);
        ContentStream.setFont(MainFont,10);
        ContentStream.showText("SIGNATURE:");
        ContentStream.endText();

        ContentStream.setStrokingColor(Color.DARK_GRAY);
        ContentStream.setLineWidth(1);
        initx = 25;
        inity = 15;
        Length = 350;
        Height = 40;

        ContentStream.addRect(initx,inity,Length,Height);
        ContentStream.stroke();
        //










        ContentStream.close();
        document.save("C:\\Users\\azdmc\\Desktop\\test\\Boop.pdf");

    }
}
