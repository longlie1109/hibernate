package MyCustom;


import Main.Main;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.util.Vector;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XuLyFileExcel {

    public void xuatExcel(JTable tbl) {
        try {
			Main.changLNF("Windows");
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
            TableModel dtm = tbl.getModel();

            JFileChooser chooser = new MyFileChooser("export/");
            chooser.setDialogTitle("LÆ°u vÃ o");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
            chooser.setFileFilter(fnef);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                // Láº¥y Ä‘Æ°á»�ng dáº«n vá»«a chá»�n + tÃªn tá»‡p
                String path = chooser.getSelectedFile().getPath();
                if (!path.contains(".xlsx")) {
                    path += ".xlsx";
                }

                XSSFWorkbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Sheet 1");

                Font headerFont = workbook.createFont();
                headerFont.setBold(true);
                headerFont.setFontHeightInPoints((short) 14);
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFont(headerFont);
                headerCellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
                headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerCellStyle.setBorderTop(BorderStyle.THIN);
                headerCellStyle.setBorderBottom(BorderStyle.THIN);
                headerCellStyle.setBorderLeft(BorderStyle.THIN);
                headerCellStyle.setBorderRight(BorderStyle.THIN);
                headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

                Row headerRow = sheet.createRow(0);

                // Táº¡o header
                for (int i = 0; i < dtm.getColumnCount(); i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(dtm.getColumnName(i));
                    cell.setCellStyle(headerCellStyle);
                }

                Font contentFont = workbook.createFont();
                contentFont.setBold(false);
                contentFont.setFontHeightInPoints((short) 13);
                contentFont.setColor(IndexedColors.BLACK.getIndex());
                CellStyle contentCellStyle = workbook.createCellStyle();
                contentCellStyle.setFont(contentFont);
                contentCellStyle.setBorderTop(BorderStyle.THIN);
                contentCellStyle.setBorderBottom(BorderStyle.THIN);
                contentCellStyle.setBorderLeft(BorderStyle.THIN);
                contentCellStyle.setBorderRight(BorderStyle.THIN);

                for (int i = 0; i < dtm.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < dtm.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(dtm.getValueAt(i, j) + "");
                        cell.setCellStyle(contentCellStyle);
                        sheet.autoSizeColumn(j);
                    }
                }

                // Ghi file
                FileOutputStream fileOut = new FileOutputStream(path);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();

                new MyDialog("Xuáº¥t file thÃ nh cÃ´ng!", MyDialog.SUCCESS_DIALOG);
            }
        } catch (Exception e) {
            try {
				new MyDialog("Xuáº¥t file tháº¥t báº¡i!", MyDialog.ERROR_DIALOG);
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }

    public void nhapExcel(JTable tbl) {
        try {
			Main.changLNF("Windows");
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
            TableModel dtm = tbl.getModel();

            JFileChooser chooser = new MyFileChooser("export/");
            chooser.setDialogTitle("Chá»�n file");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
            chooser.setFileFilter(fnef);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File fileSelected = chooser.getSelectedFile();
                FileInputStream fis = new FileInputStream(fileSelected);
                BufferedInputStream bis = new BufferedInputStream(fis);

                XSSFWorkbook wb = new XSSFWorkbook(bis);
                Sheet sheet = wb.getSheetAt(0);

                DefaultTableModel dtmtbl = (DefaultTableModel) dtm;
                dtmtbl.setRowCount(0);
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    Vector vec = new Vector();
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        if (dtmtbl.getColumnCount() != row.getLastCellNum()) {
                            new MyDialog("Nháº­p file tháº¥t báº¡i!", MyDialog.ERROR_DIALOG);
                            return;
                        }
                        Cell cell = row.getCell(j);
                        vec.add(cell.getStringCellValue());
                    }
                    dtmtbl.addRow(vec);
                }
                new MyDialog("Nháº­p file thÃ nh cÃ´ng!", MyDialog.SUCCESS_DIALOG);
            }
        } catch (Exception e) {
            try {
				new MyDialog("Nháº­p file tháº¥t báº¡i!", MyDialog.ERROR_DIALOG);
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }

}
