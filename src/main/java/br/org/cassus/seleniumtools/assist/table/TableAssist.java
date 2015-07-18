package br.org.cassus.seleniumtools.assist.table;

public interface TableAssist {

	String getValueByPosition(int row, int column);
	
	int countRows();
	
	String getValueByReference(int refColIndex, String refVal, int actualColIndex);
	
}