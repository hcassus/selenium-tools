package br.org.cassus.seleniumtools.assist.table;

public interface HeadersTableAssist extends TableAssist {

	public String getValueByReference(final String referenceColName, final String referenceVal, final String actualColName);
	
	public String getValueByColumnAndLine(final String colName,final int row);
	
	
	
	
}