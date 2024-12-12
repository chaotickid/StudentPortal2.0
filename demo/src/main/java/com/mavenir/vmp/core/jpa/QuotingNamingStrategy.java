package com.mavenir.vmp.core.jpa;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import org.hibernate.cfg.ImprovedNamingStrategy;

import com.google.common.collect.ImmutableMap;

/**
 * Naming strategy that prefers quoted names and embedded underscores.
 *
 */
public class QuotingNamingStrategy extends ImprovedNamingStrategy {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Map from singular to plural form for nouns that can't be pluralized by simply
	 * appending 's' character at the end.
	 */
	private final Map<String, String> plurals;

	public QuotingNamingStrategy() {
		plurals =
				ImmutableMap.<String, String>builder().build();
	}

	/**
	 * Returns quoted upper-cased name.
	 *
	 * @param name name
	 */
	private String quote(String name) {
		if (isQuoted(name, '`') || isQuoted(name, '"')) {
			return name;
		}

		return '`' + name.replace("`", "").toUpperCase(Locale.US) + '`';
	}

	/**
	 * Returns true if the given name is quoted with the specified character.
	 *
	 * @param name name
	 * @param quote quote character
	 */
	private boolean isQuoted(String name, char quote) {
		if (name == null || name.isEmpty()) {
			return false;
		}

		return name.charAt(0) == quote && name.charAt(name.length() - 1) == quote;
	}

	@Override
	public String classToTableName(String className) {
		String plural = plurals.get(className);
		if (plural != null) {
			return quote(plural);
		}

		return quote(super.classToTableName(stripDbPrefix(className) + 's'));
	}

	/**
	 * Returns string with 'Db' prefix removed.
	 *
	 * Strings without prefix are returned unmodified. The 'Db' prefix is required to prevent name
	 * clashes with existing standard Java classes (like Connection). Stripping the prefix allows
	 * for shorter and more manageable table names.
	 *
	 * @param className the fully-qualified class name
	 */
	private String stripDbPrefix(String className) {
		return Pattern.matches("^Db[A-Z].*$", className) ? className.substring(2) : className;
	}

	@Override
	public String propertyToColumnName(String propertyName) {
		return quote(super.propertyToColumnName(propertyName));
	}

	@Override
	public String tableName(String tableName) {
		return quote(super.tableName(tableName));
	}

	@Override
	public String columnName(String columnName) {
		return quote(super.columnName(columnName));
	}

	@Override
	public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity,
			String associatedEntityTable, String propertyName) {

		return quote(super.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable,
				propertyName));
	}

	@Override
	public String joinKeyColumnName(String joinedColumn, String joinedTable) {
		return quote(super.joinKeyColumnName(joinedColumn, joinedTable));
	}

	@Override
	public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName,
			String referencedColumnName) {

		String baseName =
				super.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName, referencedColumnName);

		return quote(baseName + '_' + referencedColumnName);
	}

	@Override
	public String logicalColumnName(String columnName, String propertyName) {
		return quote(super.logicalColumnName(columnName, propertyName));
	}

	@Override
	public String logicalCollectionTableName(String tableName, String ownerEntityTable, String associatedEntityTable,
			String propertyName) {

		return quote(super.logicalCollectionTableName(tableName, ownerEntityTable, associatedEntityTable, propertyName));
	}

	@Override
	public String logicalCollectionColumnName(String columnName, String propertyName, String referencedColumn) {

		return quote(super.logicalCollectionColumnName(columnName, propertyName, referencedColumn));
	}

}
