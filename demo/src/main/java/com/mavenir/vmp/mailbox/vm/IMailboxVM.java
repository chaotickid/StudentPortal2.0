/**
 *
 */
package com.mavenir.vmp.mailbox.vm;

/**
 * @author Vlatka, OptimIT
 *
 */
public interface IMailboxVM {

	/**
	 * Checks if is creates the vm.
	 *
	 * @return true, if is creates the vm
	 */
	boolean isCreateVM();

	/**
	 * Checks if is edits the vm.
	 *
	 * @return true, if is edits the vm
	 */
	boolean isEditVM();

	/**
	 * Checks if is search vm.
	 *
	 * @return true, if is search vm
	 */
	boolean isSearchVM();
}
