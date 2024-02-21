package com.example.pdfGenerator.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class PdfService {

    public void export(HttpServletResponse response) throws IOException {
        Document document= new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle= FontFactory.getFont(FontFactory.HELVETICA_BOLD,18);
//        fontTitle.setSize(18);

        Paragraph titleParagraph= new Paragraph("This is Title.", fontTitle);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);

        Font fontParagraph= FontFactory.getFont(FontFactory.HELVETICA,12);
//        fontParagraph.setSize(12);

        Paragraph contParagraph= new Paragraph("This is paragraph.", fontParagraph);
        contParagraph.setAlignment(Element.ALIGN_LEFT);

        document.add(titleParagraph);
        document.add(contParagraph);
        document.close();

    }
}
