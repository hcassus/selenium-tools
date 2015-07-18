package br.org.cassus.seleniumtools.assist.table;

/**Determines the kinds of tables for the table factory<br/>
 *	<b>EXPLICIT_HEADER</b> - tables containing "thead"
 *	<b>IMPLICIT_HEADER</b> - tables containing header on first "tbody" row
 *	<b>HEADERLESS</b> - tables containing no rows
 **/
public enum TableType {
	EXPLICIT_HEADER,
	IMPLICIT_HEADER,
	HEADERLESS,
	UNKNOWN;
}
