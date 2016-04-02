package com.marketing.tool.service;

import java.io.ByteArrayOutputStream;

import com.marketing.tool.vo.DownLoadReportVo;

public interface DownLoadReportService {

	public ByteArrayOutputStream getReportDocument(DownLoadReportVo reportVo);
}
