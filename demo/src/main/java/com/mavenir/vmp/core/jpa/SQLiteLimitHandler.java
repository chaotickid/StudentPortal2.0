///**
// *
// */
//package com.mavenir.vmp.core.jpa;
//
//import org.hibernate.dialect.Dialect;
////import org.hibernate.dialect.pagination.LegacyLimitHandler;
////import org.hibernate.engine.spi.RowSelection;
//
///**
// * Legacy Limit handler does not override bindLimitParametersInReverseOrder
// * returning false and breaking paging along with it.
// *
// */
//public class SQLiteLimitHandler /*extends LegacyLimitHandler*/ {
//
//	/**
//	 * @param dialect
//	 * @param sql
//	 * @param selection
//	 */
////	public SQLiteLimitHandler(Dialect dialect, String sql, RowSelection selection) {
////		super(dialect);
////	}
//
//	/* (non-Javadoc)
//	 * @see org.hibernate.dialect.pagination.LegacyLimitHandler#bindLimitParametersInReverseOrder()
//	 */
//	//@Override
//	public boolean bindLimitParametersInReverseOrder() {
//		return true;
//	}
//
//}
