package com.running4light.gdms.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface FileService {

	XSSFWorkbook exportExcelInfo(String ... someParam);

}
