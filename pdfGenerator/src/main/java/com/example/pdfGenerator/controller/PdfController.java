package com.example.pdfGenerator.controller;

import com.example.pdfGenerator.services.PdfService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/generate")
    public void PdfGenerate(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat= new SimpleDateFormat("yyyy-mm-dd:hh:mm:ss");
        String currentDateTime= dateFormat.format(new Date());

        String headerKey= "Content-Disposition";
        String headerValue= "attachment; fileName=pdf_"+ currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfService.export(response);
    }
}
