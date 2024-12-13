package com.mavenir.vmp.mailbox.vm;


/**
 * The Class MailboxVM.
 */
public class MailboxSearchVM extends MailboxVM implements IMailboxVM {

	@Override
	public boolean isCreateVM() {
		return false;
	}

	@Override
	public boolean isEditVM() {
		return false;
	}

	@Override
	public boolean isSearchVM() {
		return true;
	}

}
